package com.warframe.tmall.repository;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {


    void save(T t);

    void delete(Long id);

    void update(T t);

    T getById(Long id);

//     List<T> listAll();

    List<T> findByPage(@Param("params") Map<String, Object> params, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    int getTotalNumber();
}
