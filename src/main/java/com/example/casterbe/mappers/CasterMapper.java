package com.example.casterbe.mappers;

import com.example.casterbe.dao.CasterEntity;
import com.example.casterbe.model.Caster;
import org.mapstruct.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, uses = PowerMapper.class)
public interface CasterMapper {
    @Mapping(source = "powers", target = "powerList")
    CasterEntity modelToEntity(Caster caster);

    @InheritInverseConfiguration
    Caster entityToModel(CasterEntity caster);

    default List<Caster> mapCasterListEntitiesToModels(List<CasterEntity> casters) {
        return Optional.ofNullable(casters)
                .filter(list -> !list.isEmpty())
                .orElse(Collections.emptyList())
                .stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }
}
