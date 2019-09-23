package com.ibragimov.restmanager.service;

import com.ibragimov.restmanager.dao.ManagerRepository;
import com.ibragimov.restmanager.model.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManagerService {

    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Transactional
    public Manager createManager(Manager manager) {
        logger.debug("Create new Manager with name='{}' and surname='{}'", manager.getName(), manager.getSurname());
        return managerRepository.save(manager);
    }

    public List<Manager> getAllManagers() {
        logger.debug("Get all managers from table");
        return (List<Manager>) managerRepository.findAll();
    }

    @Transactional
    public Manager updateManager(Manager manager) {
        logger.debug("Edit the Manager with id='{}'", manager.getId());
        return managerRepository.save(manager);
    }

    @Transactional
    public Manager deleteManager(Manager manager) {
        logger.debug("Delete Manager with id='{}'", manager.getId());
        if (manager.getAssistant() == null) {
            logger.debug("Can't delete Manager with id='{}' because assistant is absent'");
            return manager;
        }
        manager.setActive(false);
        manager = managerRepository.save(manager);
        return manager.getAssistant();
    }

    public Manager getById(Integer id) {
        return managerRepository.findById(id).orElse(null);
    }

}
