package com.example.casterbe.mappers;

import com.example.casterbe.dao.CasterListEntity;
import com.example.casterbe.model.CasterList;
import org.mapstruct.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, uses = CasterMapper.class)
public interface CasterListMapper {
    @Mapping(target = "id", source = "id", qualifiedByName = "generateCasterListUuid")
    CasterListEntity modelToEntity(CasterList casterList);

    CasterList entityToModel(CasterListEntity casterList);

    default List<CasterList> mapCasterListEntitiesToModels(List<CasterListEntity> casterLists) {
        return Optional.ofNullable(casterLists)
                .filter(list -> !list.isEmpty())
                .orElse(Collections.emptyList())
                .stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Named("generateCasterListUuid")
    static String generateCasterListUuid(String casterId){
        if (casterId==null || casterId.isEmpty()){
            UUID newUuid = UUID.randomUUID();
            return newUuid.toString();
        } else return casterId;
    }
}
