package com.example.casterbe.mappers;

import com.example.casterbe.dao.CasterSelectionEntity;
import com.example.casterbe.model.CasterSelection;
import org.mapstruct.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        uses = CasterListMapper.class)
public interface CasterSelectionMapper {
    @Mapping(target = "id", source = "id", qualifiedByName = "generateUuid")
    @Mapping(target = "casterList", source = "casterList")
    CasterSelectionEntity modelToEntity(CasterSelection casterSelection);

    CasterSelection entityToModel(CasterSelectionEntity casterSelectionEntity);

    default List<CasterSelection> mapEntitiesToModels(List<CasterSelectionEntity> raceEntities) {
        return Optional.ofNullable(raceEntities)
                .filter(list -> !list.isEmpty())
                .orElse(Collections.emptyList())
                .stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Named("generateUuid")
    static String generateUuid(String casterId) {
        if (casterId == null || casterId.isEmpty()) {
            UUID newUuid = UUID.randomUUID();
            return newUuid.toString();
        } else return casterId;
    }
}
