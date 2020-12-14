package com.fabric.ilearn.mapper.lrn.semester;


import com.fabric.ilearn.dto.lrn.semester.SemesterDto;
import com.fabric.ilearn.model.lrn.semester.LrnSemester;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = SemesterLocaleMapper.class)
public interface SemesterMapper {
    @Mapping(target = "semesterId", source = "semesterId")
    @Mapping(target = "semesterFrom", source = "semesterFrom")
    @Mapping(target = "semesterTo", source = "semesterTo")
    @Mapping(target = "locale", source = "lrnSemester.lrnSemesterLocales")
    SemesterDto semesterToSemesterDto(LrnSemester lrnSemester);
}