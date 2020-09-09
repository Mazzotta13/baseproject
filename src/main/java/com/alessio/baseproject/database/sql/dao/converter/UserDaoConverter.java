package com.alessio.baseproject.database.sql.dao.converter;

import com.alessio.baseproject.database.rawmodel.UserEntity;
import com.alessio.baseproject.database.sql.dao.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDaoConverter {
    UserDaoConverter INSTANCE = Mappers.getMapper(UserDaoConverter.class);

    @Mapping(target = "creationDate", ignore = true)
    UserDto map(UserEntity userEntity);

    @Mapping(target = "creationDate", ignore = true)
    UserEntity map(UserDto userDto);
}