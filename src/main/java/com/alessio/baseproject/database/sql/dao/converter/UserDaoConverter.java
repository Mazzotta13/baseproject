package com.alessio.baseproject.database.sql.dao.converter;

import com.alessio.baseproject.database.rawmodel.UserEntity;
import com.alessio.baseproject.database.sql.dao.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDaoConverter {
    UserDaoConverter INSTANCE = Mappers.getMapper(UserDaoConverter.class);

    UserDto map(UserEntity userEntity);

    UserEntity map(UserDto userDto);
}