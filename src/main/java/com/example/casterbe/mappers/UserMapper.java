package com.example.casterbe.mappers;

import com.example.casterbe.dao.UserEntity;
import com.example.casterbe.model.User;
import org.mapstruct.*;

import java.util.UUID;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface UserMapper {

    @Mapping(target = "id", source = "id", qualifiedByName = "generateUserUuid")
    UserEntity modelToEntity(User user);

    User entityToModel(UserEntity userEntity);

    @Named("generateUserUuid")
    static String generateUserUuid(String casterId){
        if (casterId==null || casterId.isEmpty()){
            UUID newUuid = UUID.randomUUID();
            return newUuid.toString();
        } else return casterId;
    }

}
