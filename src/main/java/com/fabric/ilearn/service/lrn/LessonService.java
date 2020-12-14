package com.fabric.ilearn.service.lrn;

import com.fabric.ilearn.dao.lrn.LessonRepository;
import com.fabric.ilearn.dto.lrn.lesson.LessonDto;
import com.fabric.ilearn.mapper.lrn.lesson.LessonLocalMapper;
import com.fabric.ilearn.mapper.lrn.lesson.LessonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {
    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    LessonMapper lessonMapper;

    public List<LessonDto> findAll(){
        return lessonRepository.findAll().stream().map(lessonMapper::lrnLessonToLessonDto).collect(Collectors.toList());
    }

    public Slice<LessonDto> findAllByLocaleCode(String localeCode){
        return lessonRepository.findAllByLrnLessonLocalesLocaleCode(localeCode).map(lessonMapper::lrnLessonToLessonDto);

        //return lessonRepository.findAllByLrnLessonLocalesLocaleCode(localeCode).stream().map(lessonMapper::lrnLessonToLessonDto).collect(Collectors.toList());
    }

    public List<LessonDto> findAllByLocaleCodeAndRegisteredSubjectId(String localeCode, long registeredSubjectId){
        return lessonRepository.findAllByLrnLessonLocalesLocaleCodeAndRegisteredSubjectId(localeCode, registeredSubjectId).stream().map(lessonMapper::lrnLessonToLessonDto).collect(Collectors.toList());
    }

}
