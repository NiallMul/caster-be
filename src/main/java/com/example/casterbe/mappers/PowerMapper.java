package com.example.casterbe.mappers;

import com.example.casterbe.dao.PowerEntity;
import com.example.casterbe.model.Power;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface PowerMapper {
    PowerEntity modelToEntity(Power power);

    @InheritInverseConfiguration
    Power entityToModel(PowerEntity powerEntity);

    default List<Power> mapAbilityEntitiesToModels(List<PowerEntity> abilityEntityList) {
        return Optional.ofNullable(abilityEntityList)
                .filter(list -> !list.isEmpty())
                .orElse(Collections.emptyList())
                .stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }
}
