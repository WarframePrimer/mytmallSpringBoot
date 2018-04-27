package com.warframe.tmall.service;


import com.warframe.tmall.common.pojo.DataTablesResult;
import com.warframe.tmall.domain.pojo.TbThanks;

public interface ThanksService {

    /**
     * 获得捐赠列表
     * @return
     */
    DataTablesResult getThanksList();

    DataTablesResult getThanksListByPage(int page, int size);

    /**
     * 统计捐赠表数目
     * @return
     */
    Long countThanks();

    /**
     * 添加捐赠
     * @param tbThanks
     * @return
     */
    int addThanks(TbThanks tbThanks);

    /**
     * 更新捐赠
     * @param tbThanks
     * @return
     */
    int updateThanks(TbThanks tbThanks);

    /**
     * 删除捐赠
     * @param id
     * @return
     */
    int deleteThanks(int id);
}
