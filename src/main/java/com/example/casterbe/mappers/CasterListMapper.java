package com.example.casterbe.mappers;

import com.example.casterbe.dao.CasterListEntity;
import com.example.casterbe.model.CasterList;
import org.mapstruct.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, uses = CasterMapper.class)
public interface CasterListMapper {
    CasterListEntity modelToEntity(CasterList casterList);

    @InheritInverseConfiguration
    CasterList entityToModel(CasterListEntity casterList);

    default List<CasterList> mapCasterListEntitiesToModels(List<CasterListEntity> casterLists) {
        return Optional.ofNullable(casterLists)
                .filter(list -> !list.isEmpty())
                .orElse(Collections.emptyList())
                .stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }
}
