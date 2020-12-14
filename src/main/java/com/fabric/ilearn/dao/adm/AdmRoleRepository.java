package com.fabric.ilearn.dao.adm;

import com.fabric.ilearn.model.adm.AdmRole;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdmRoleRepository extends CrudRepository<AdmRole, Long> {
    @EntityGraph(attributePaths = {"admRoleLocales"})
    List<AdmRole> findAll();

    @EntityGraph(attributePaths = {"admRoleLocales"})
    List<AdmRole> findAllByAdmRoleLocalesLocaleCode(@Param("localeCode") String localeCode);
}

