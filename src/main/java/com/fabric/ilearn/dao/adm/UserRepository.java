package com.fabric.ilearn.dao.adm;

import com.fabric.ilearn.model.adm.AdmUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<AdmUser, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "userPrinciple-graph")
    AdmUser getByUserName(String userName);
}

