package com.alessio.baseproject.database.sql.dao.impl;

import com.alessio.baseproject.database.rawmodel.UserEntity;
import com.alessio.baseproject.database.rawmodel.UserEntityExample;
import com.alessio.baseproject.database.sql.dao.UserDao;
import com.alessio.baseproject.database.sql.dao.converter.UserDaoConverter;
import com.alessio.baseproject.database.sql.dao.mapper.CardEntityMapper;
import com.alessio.baseproject.database.sql.dao.mapper.UserEntityMapper;
import com.alessio.baseproject.database.sql.dao.model.UserDto;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UserDaoImpl implements UserDao {

    private UserEntityMapper userEntityMapper;
    private CardEntityMapper cardEntityMapper;

    public UserDaoImpl(UserEntityMapper userEntityMapper, CardEntityMapper cardEntityMapper) {
        this.userEntityMapper = userEntityMapper;
        this.cardEntityMapper = cardEntityMapper;
    }

    @Override
    public Optional<UserDto> selectByPrimaryKey(String primayKey) {
        return Optional.ofNullable(
                UserDaoConverter.INSTANCE.map(userEntityMapper.selectByPrimaryKey(primayKey)));
    }

    @Override
    public UserDto insert(UserDto record) {
//        record = record.setId(UUID.randomUUID().toString().replace("-",""));
//        if (record.getCreationDate() == null) {
//            record.setCreationDate(DateTime.now());
//        }
//        userEntityMapper
//                .insert(UserDaoConverter.INSTANCE.map(record));
//        CardEntity cardEtity = new CardEntity();
//        cardEtity.setId(UUID.randomUUID().toString().replace("-",""));
//        cardEtity.setName("name");
//        cardEntityMapper.insert(cardEtity);

        UserEntity userEntity= new UserEntity();
        userEntity.setUtentiId(UUID.randomUUID().toString().replace("-",""));
        userEntity.setName("testName");
        userEntity.setCreationDate(DateTime.now());
        userEntityMapper.insert(userEntity);
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

    @Override
    public List<UserDto> findAll() {
        UserEntityExample example = new UserEntityExample();
        example.createCriteria();
        return userEntityMapper.selectByExample(example).stream()
                .map(UserDaoConverter.INSTANCE::map)
                .collect(Collectors.toList());
    }
}
