package com.alessio.baseproject.database.sql.dao.converter;

import com.alessio.baseproject.database.rawmodel.UserEntity;
import com.alessio.baseproject.database.sql.dao.model.BatchAdditionalInfo;
import com.alessio.baseproject.database.sql.dao.model.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;

@Mapper
public interface UserDaoConverter {
    UserDaoConverter INSTANCE = Mappers.getMapper(UserDaoConverter.class);

//    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "additionalInfo", ignore = true)
    UserDto map(UserEntity userEntity);

//    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "additionalInfo", ignore = true)
    UserEntity map(UserDto userDto);

    @AfterMapping
    default void afterMapping(@MappingTarget UserDto result, UserEntity entity) {
        if (result != null && !CollectionUtils.isEmpty(entity.getAdditionalInfo())) {
            ObjectMapper mapper = new ObjectMapper();
            BatchAdditionalInfo additionalInfo = mapper.convertValue(entity.getAdditionalInfo(), BatchAdditionalInfo.class);
            result.setAdditionalInfo(additionalInfo);
        }
    }

    @AfterMapping
    default void afterMapping(@MappingTarget UserEntity result, UserDto dto) {
        if (result != null && dto.getAdditionalInfo() != null) {
            ObjectMapper mapper = new ObjectMapper();
            HashMap additionalInfo = mapper.convertValue(dto.getAdditionalInfo(), HashMap.class);
            result.setAdditionalInfo(additionalInfo);
            System.out.println(result.toString());
        }
    }
}