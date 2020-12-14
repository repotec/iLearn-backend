package com.fabric.ilearn.mapper.lrn.lesson;

import com.fabric.ilearn.dto.lrn.lesson.LessonLocaleDto;
import com.fabric.ilearn.model.lrn.lesson.LrnLessonLocale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LessonLocalMapper {
    @Mapping(target = "displayName", source = "lessonDisplayName")
    LessonLocaleDto lessonLocaleToLessonLocaleDto(LrnLessonLocale lrnLessonLocale);
}
