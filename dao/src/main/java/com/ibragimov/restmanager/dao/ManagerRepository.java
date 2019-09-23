package com.ibragimov.restmanager.dao;

import com.ibragimov.restmanager.model.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Integer> {

}
