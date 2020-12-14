package com.fabric.ilearn.mapper.lrn.lesson;

import com.fabric.ilearn.dto.lrn.lesson.LessonDto;
import com.fabric.ilearn.model.lrn.lesson.LrnLesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = LessonLocalMapper.class)
public interface LessonMapper {
    @Mapping(target = "lessonId", source = "lessonId")
    @Mapping(target = "url", source = "lessonUrl")
    @Mapping(target = "locale", source = "lrnLesson.lrnLessonLocales")
    LessonDto lrnLessonToLessonDto(LrnLesson lrnLesson);
}
