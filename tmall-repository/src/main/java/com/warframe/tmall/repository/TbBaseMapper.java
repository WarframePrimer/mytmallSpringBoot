package com.warframe.tmall.repository;


import com.warframe.tmall.domain.pojo.TbBase;
import com.warframe.tmall.domain.pojo.TbBaseExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbBaseMapper {
    long countByExample(TbBaseExample example);

    int deleteByExample(TbBaseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbBase record);

    int insertSelective(TbBase record);

    List<TbBase> selectByExample(TbBaseExample example);

    TbBase selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbBase record, @Param("example") TbBaseExample example);

    int updateByExample(@Param("record") TbBase record, @Param("example") TbBaseExample example);

    int updateByPrimaryKeySelective(TbBase record);

    int updateByPrimaryKey(TbBase record);
}