package com.warframe.tmall.service.impl;


import com.warframe.tmall.common.exception.TmallException;
import com.warframe.tmall.common.pojo.DataTablesResult;
import com.warframe.tmall.domain.pojo.TbOrder;
import com.warframe.tmall.domain.pojo.TbOrderExample;
import com.warframe.tmall.domain.pojo.TbOrderItem;
import com.warframe.tmall.domain.pojo.TbOrderItemExample;
import com.warframe.tmall.repository.TbOrderItemMapper;
import com.warframe.tmall.repository.TbOrderMapper;
import com.warframe.tmall.repository.TbOrderShippingMapper;
import com.warframe.tmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Exrickx
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TbOrderMapper tbOrderMapper;
    @Autowired
    private TbOrderItemMapper tbOrderItemMapper;
    @Autowired
    private TbOrderShippingMapper tbOrderShippingMapper;
    @Override
    public DataTablesResult getOrderList() {

        DataTablesResult result=new DataTablesResult();
        TbOrderExample example=new TbOrderExample();
        List<TbOrder> list=tbOrderMapper.selectByExample(example);
        if(list==null){
            throw new TmallException("获取订单列表失败");
        }
        result.setSuccess(true);
        result.setData(list);
        return result;
    }

    @Override
    public Long countOrder() {

        TbOrderExample example=new TbOrderExample();
        Long result=tbOrderMapper.countByExample(example);
        if(result==null){
            throw new TmallException("统计订单数目失败");
        }
        return result;
    }

    @Override
    public int deleteOrder(String id) {

        if(tbOrderMapper.deleteByPrimaryKey(id)!=1){
            throw new TmallException("删除订单数失败");
        }

        TbOrderItemExample example=new TbOrderItemExample();
        TbOrderItemExample.Criteria criteria= example.createCriteria();
        criteria.andOrderIdEqualTo(id);
        List<TbOrderItem> list =tbOrderItemMapper.selectByExample(example);
        for(TbOrderItem tbOrderItem:list){
            if(tbOrderItemMapper.deleteByPrimaryKey(tbOrderItem.getId())!=1){
                throw new TmallException("删除订单商品失败");
            }
        }

        if(tbOrderShippingMapper.deleteByPrimaryKey(id)!=1){
            throw new TmallException("删除物流失败");
        }
        return 1;
    }

    @Override
    public int cancelOrder() {

        TbOrderExample example=new TbOrderExample();
        List<TbOrder> list=tbOrderMapper.selectByExample(example);
        for(TbOrder tbOrder:list){
            judgeOrder(tbOrder);
        }
        return 1;
    }

    /**
     * 判断订单是否超时未支付
     */
    public String judgeOrder(TbOrder tbOrder){

        String result=null;
        if(tbOrder.getStatus()==0){
            //判断是否已超1天
            long diff=System.currentTimeMillis()-tbOrder.getCreateTime().getTime();
            long days = diff / (1000 * 60 * 60 * 24);
            if(days>=1){
                //设置失效
                tbOrder.setStatus(5);
                tbOrder.setCloseTime(new Date());
                if(tbOrderMapper.updateByPrimaryKey(tbOrder)!=1){
                    throw new TmallException("设置订单关闭失败");
                }
            }else {
                //返回到期时间
                long time=tbOrder.getCreateTime().getTime()+1000 * 60 * 60 * 24;
                result= String.valueOf(time);
            }
        }
        return result;
    }
}
