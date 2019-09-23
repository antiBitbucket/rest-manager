package com.ibragimov.restmanager.service;

import com.ibragimov.restmanager.dao.ManagerRepository;
import com.ibragimov.restmanager.model.Manager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {

    @Mock
    private ManagerRepository managerRepository;

    @InjectMocks
    private ManagerService managerService;

    @Test
    public void createManagerTest() {
        Manager assistant = new Manager("Sidorov", "Sergey", "Semenovich", "321");
        Manager manager = new Manager(1, "Ivanov", "Ivan", "Ivanovich", "123", assistant);
        when(managerRepository.save(manager)).thenReturn(manager);
        Manager actual = managerService.createManager(manager);

        assertEquals(manager, actual);
        verify(managerRepository, times(1)).save(manager);
    }

    @Test
    public void getAllManagersTest() {
        List<Manager> expected = new ArrayList<>();
        Manager assistant = new Manager("Sidorov", "Sergey", "Semenovich", "321");
        expected.add(assistant);
        expected.add(new Manager(1, "Ivanov", "Ivan", "Ivanovich", "123", assistant));
        expected.add(new Manager(2, "Ivanov", "Ivan", "Ivanovich", "123", assistant));
        when(managerRepository.findAll()).thenReturn(expected);
        List<Manager> actual = managerService.getAllManagers();

        assertEquals(expected, actual);
        verify(managerRepository, times(1)).findAll();
    }

    @Test
    public void updateManagerTest() {
        Manager assistant = new Manager("Sidorov", "Sergey", "Semenovich", "321");
        Manager manager = new Manager(1, "Ivanov", "Ivan1", "Ivanovich", "123", assistant);
        managerService.updateManager(manager);

        verify(managerRepository).save(manager);
    }

    @Test
    public void deleteManagerFalseTest() {
        Manager manager = new Manager(1, "Ivanov", "Ivan", "Ivanovich", "123", null);
        Manager actual = managerService.deleteManager(manager);

        assertEquals(manager, actual);
    }

    @Test
    public void deleteManagerTrueTest() {
        Manager assistant = new Manager("Sidorov", "Sergey", "Semenovich", "321");
        Manager manager = new Manager(1, "Ivanov", "Ivan1", "Ivanovich", "123", assistant);
        when(managerRepository.save(manager)).thenReturn(manager);
        Manager actual = managerService.deleteManager(manager);

        assertEquals(assistant, actual);
        verify(managerRepository, times(1)).save(manager);
    }

}
