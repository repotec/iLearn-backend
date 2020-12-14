package com.fabric.ilearn.dao.lrn;

import com.fabric.ilearn.model.lrn.level.LrnLevel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LevelRepository extends CrudRepository<LrnLevel, Long> {
    @EntityGraph(attributePaths = {"lrnLevelLocales"})
    List<LrnLevel> findAll();

    @EntityGraph(attributePaths = {"lrnLevelLocales"})
    List<LrnLevel> findAllByLrnLevelLocalesLocaleCode(@Param("localCode") String localCode);

    @EntityGraph(attributePaths = {"lrnLevelLocales"})
    LrnLevel findAllByLrnLevelLocalesLocaleCodeAndLevelId(String localeCode, long levelId);
}
