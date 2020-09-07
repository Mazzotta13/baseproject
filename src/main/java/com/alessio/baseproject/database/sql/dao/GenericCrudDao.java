package com.alessio.baseproject.database.sql.dao;

import java.util.Optional;

public interface GenericCrudDao<T, P> {
    Optional<T> selectByPrimaryKey(P primayKey);
    T insert(T record);
    int updateByPrimaryKey(T record);
    int updateByPrimaryKeySelective(T record);
    int deleteByPrimaryKey(P primaryKey);
}