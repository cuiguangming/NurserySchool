package com.nursery.common.dao;

import java.util.List;

public interface CrudDao<T> {


    /**
     * 新增
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 修改
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int delete(String id);

    /**
     * 根据对象具体条件删除
     * @param t
     * @return
     */
    int delte(T t);

    /**
     * 查询列表
     * @param t
     * @return
     */
    List<T> findList(T t);

    /**
     * 查询一条
     * @param id
     * @return
     */
    T selectOne(String id);

    /**
     * 查询所有
     * @return
     */
    List<T> findAll();

}
