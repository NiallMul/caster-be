package com.example.casterbe.mappers;

import com.example.casterbe.dao.PowerEntity;
import com.example.casterbe.model.Caster;
import com.example.casterbe.model.Power;
import org.mapstruct.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface PowerMapper {
    @Mapping(target = "id", source = "power.id", qualifiedByName = "generatePowerUuid")
    @Mapping(target = "name", source = "power.name")
    @Mapping(target = "value", source = "power.value")
    @Mapping(target = "casterid", source = "caster")
    PowerEntity modelToEntity(Power power, Caster caster);

    Power entityToModel(PowerEntity powerEntity);

    default List<Power> mapAbilityEntitiesToModels(List<PowerEntity> abilityEntityList) {
        return Optional.ofNullable(abilityEntityList)
                .filter(list -> !list.isEmpty())
                .orElse(Collections.emptyList())
                .stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Named("generatePowerUuid")
    static String generatePowerUuid(String casterId){
        if (casterId==null || casterId.isEmpty()){
            UUID newUuid = UUID.randomUUID();
            return newUuid.toString();
        } else return casterId;
    }
}
