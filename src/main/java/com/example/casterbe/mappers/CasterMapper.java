package com.example.casterbe.mappers;

import com.example.casterbe.dao.CasterEntity;
import com.example.casterbe.model.Caster;
import com.example.casterbe.model.CasterList;
import org.mapstruct.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, uses = PowerMapper.class)
public interface CasterMapper {
    @Mapping(source = "caster.id", target = "id", qualifiedByName = "generateUuid")
    @Mapping(source = "caster.name", target = "name")
    @Mapping(source = "caster.powers", target = "powerList")
    @Mapping(source = "casterList", target = "list_id")
    CasterEntity modelToEntity(Caster caster, CasterList casterList);

    Caster entityToModel(CasterEntity caster);

    default List<Caster> mapCasterListEntitiesToModels(List<CasterEntity> casters) {
        return Optional.ofNullable(casters)
                .filter(list -> !list.isEmpty())
                .orElse(Collections.emptyList())
                .stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Named("generateUuid")
    static String generateUuid(String id){
        if (id==null || id.isEmpty()){
            UUID newUuid = UUID.randomUUID();
            return newUuid.toString();
        } else return id;
    }
}
