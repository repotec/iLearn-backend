package com.fabric.ilearn.mapper.lrn.semester;

import com.fabric.ilearn.dto.lrn.level.LevelLocaleDto;
import com.fabric.ilearn.dto.lrn.semester.SemesterLocaleDto;
import com.fabric.ilearn.model.lrn.semester.LrnSemesterLocale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SemesterLocaleMapper {
    @Mapping(target = "displayName", source = "semesterDisplayName")
    SemesterLocaleDto semesterLocalToSemesterLocalDto(LrnSemesterLocale lrnSemesterLocale);
}
