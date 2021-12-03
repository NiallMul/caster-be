package com.example.casterbe.mappers;

import com.example.casterbe.dao.UserEntity;
import com.example.casterbe.model.User;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface UserMapper {

    UserEntity modelToEntity(User user);

    @InheritInverseConfiguration
    User entityToModel(UserEntity userEntity);

}
