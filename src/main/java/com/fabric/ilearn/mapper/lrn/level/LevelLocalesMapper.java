package com.fabric.ilearn.mapper.lrn.level;

import com.fabric.ilearn.dto.lrn.level.LevelLocaleDto;
import com.fabric.ilearn.model.lrn.level.LrnLevelLocale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LevelLocalesMapper {
    @Mapping(target = "displayName", source = "levelDisplayName")
    LevelLocaleDto levelLocalDtoToLevelLocal(LrnLevelLocale lrnLevelLocale);
}
