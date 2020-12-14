package com.fabric.ilearn.dao.lrn;

import com.fabric.ilearn.model.lrn.subject.LrnSubject;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends CrudRepository<LrnSubject, Long> {
    @EntityGraph(attributePaths = "lrnSubjectLocales")
    List<LrnSubject> findAllByLrnSubjectLocalesLocaleCode(@Param("localeCode") String localCode);
}
