package com.fabric.ilearn.dao.lrn;

import com.fabric.ilearn.model.lrn.lesson.LrnLesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends CrudRepository<LrnLesson, Long> {
    //@EntityGraph(attributePaths = {"lrnLessonLocales"})
    //List<LrnLesson> findAllByLrnLessonLocalesLocaleCode(@Param("localCode") String localCode);

    @EntityGraph(attributePaths = {"lrnLessonLocales"})
    Slice<LrnLesson> findAllByLrnLessonLocalesLocaleCode(@Param("localCode") String localCode);

    @EntityGraph(attributePaths = {"lrnLessonLocales"})
    List<LrnLesson> findAllByLrnLessonLocalesLocaleCodeAndRegisteredSubjectId(@Param("localCode") String localCode, long registeredSubjectId);

    List<LrnLesson> findAll();
}
