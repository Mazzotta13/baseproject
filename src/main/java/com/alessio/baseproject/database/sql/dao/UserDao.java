package com.alessio.baseproject.database.sql.dao;

import com.alessio.baseproject.database.sql.dao.model.UserDto;

import java.util.List;

public interface UserDao extends GenericCrudDao<UserDto, String> {
    List<UserDto> findAll();
}
