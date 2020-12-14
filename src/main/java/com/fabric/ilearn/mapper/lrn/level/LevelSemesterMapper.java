package com.fabric.ilearn.mapper.lrn.level;

import com.fabric.ilearn.dto.lrn.level.LevelSemesterDto;
import com.fabric.ilearn.model.lrn.level.LrnLevel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = LevelLocalesMapper.class)
public interface LevelSemesterMapper {
    @Mapping(target = "levelId", source = "levelId")
    @Mapping(target = "icon", source = "levelIconPath")
    @Mapping(target = "locale", source = "lrnLevel.lrnLevelLocales")
    LevelSemesterDto LevelToLevelDto(LrnLevel lrnLevel);
}
