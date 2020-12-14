package com.fabric.ilearn.dao.lrn;

import com.fabric.ilearn.model.lrn.subject.LrnRegisteredSubject;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegisteredSubjectRepository extends CrudRepository<LrnRegisteredSubject, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "registeredSubject-graph")
    List<LrnRegisteredSubject> findAllBySemesterIdAndLrnSubjectLrnSubjectLocalesLocaleCode(long semesterId, String localeCode);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "registeredSubject-graph")
    List<LrnRegisteredSubject> findAllByLrnSubjectLrnSubjectLocalesLocaleCode(String localeCode);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "registeredSubject-graph")
    List<LrnRegisteredSubject> findAllBySubjectIdAndLrnSubjectLrnSubjectLocalesLocaleCode(long subjectId, String localeCode);
}
