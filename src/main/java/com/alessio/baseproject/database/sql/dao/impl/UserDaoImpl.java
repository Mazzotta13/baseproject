package com.alessio.baseproject.database.sql.dao.impl;

import com.alessio.baseproject.database.sql.dao.UserDao;
import com.alessio.baseproject.database.sql.dao.converter.UserDaoConverter;
import com.alessio.baseproject.database.sql.dao.mapper.UserEntityMapper;
import com.alessio.baseproject.database.sql.dao.model.UserDto;

import java.util.Optional;
import java.util.UUID;

public class UserDaoImpl implements UserDao {

    private UserEntityMapper userEntityMapper;

    public UserDaoImpl(UserEntityMapper userEntityMapper) {
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public Optional<UserDto> selectByPrimaryKey(String primayKey) {
        return Optional.ofNullable(
                UserDaoConverter.INSTANCE.map(userEntityMapper.selectByPrimaryKey(primayKey)));
    }

    @Override
    public UserDto insert(UserDto record) {
        record = record.setId(UUID.randomUUID().toString().replace("-",""));
        userEntityMapper
                .insert(UserDaoConverter.INSTANCE.map(record));
        return  record;
    }

    @Override
    public int updateByPrimaryKey(UserDto record) {
        return userEntityMapper
                .updateByPrimaryKey(UserDaoConverter.INSTANCE.map(record));
    }

    @Override
    public int updateByPrimaryKeySelective(UserDto record) {
        return userEntityMapper
                .updateByPrimaryKeySelective(UserDaoConverter.INSTANCE.map(record));
    }

    @Override
    public int deleteByPrimaryKey(String primaryKey) {
        return userEntityMapper
                .deleteByPrimaryKey(primaryKey);
    }
}
