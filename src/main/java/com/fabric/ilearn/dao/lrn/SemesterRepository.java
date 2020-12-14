package com.fabric.ilearn.dao.lrn;

import com.fabric.ilearn.model.lrn.semester.LrnSemester;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SemesterRepository extends CrudRepository<LrnSemester, Long> {
    @EntityGraph(attributePaths = "lrnSemesterLocales")
    List<LrnSemester> findAllByLrnSemesterLocalesLocaleCode(String localeCode);

    @EntityGraph(attributePaths = "lrnSemesterLocales")
    List<LrnSemester> findAllByLrnSemesterLocalesLocaleCodeAndSemesterId(String localeCode, long semesterId);
}
