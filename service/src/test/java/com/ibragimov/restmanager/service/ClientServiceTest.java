package com.ibragimov.restmanager.service;

import com.ibragimov.restmanager.dao.ClientRepository;
import com.ibragimov.restmanager.model.Client;
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
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    public void createClientTest() {
        Manager assistant = new Manager("Sidorov", "Sergey", "Semenovich", "321");
        Manager manager = new Manager(1, "Ivanov", "Ivan", "Ivanovich", "123", assistant);
        Client client = new Client(1, "Vova", "Moscow", manager);
        when(clientRepository.save(client)).thenReturn(client);
        Client actual = clientService.createClient(client);

        assertEquals(client, actual);
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    public void getAllClientTest() {
        List<Client> expected = new ArrayList<>();
        expected.add(new Client(1, "Vova", "Moscow", null));
        expected.add(new Client(2, "Petya", "Vladimir", null));
        expected.add(new Client(3, "Vasya", "Kazan", null));
        when(clientRepository.findAll()).thenReturn(expected);
        List<Client> actual = clientService.getAllClients();

        assertEquals(expected, actual);
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    public void getByIdTest() {
        Client expected = new Client(1, "Vova", "Moscow", null);
        when(clientRepository.findById(1)).thenReturn(java.util.Optional.of(expected));
        Client actual = clientService.getById(1);

        assertEquals(expected, actual);
        verify(clientRepository, times(1)).findById(1);
    }

    @Test
    public void updateClientTest() {
        Client client = new Client(1, "Vova555", "Moscow", null);
        when(clientRepository.save(client)).thenReturn(client);
        Client actual = clientService.updateClient(client);

        assertEquals(client, actual);
        verify(clientRepository).save(client);
    }

    @Test
    public void deleteClientTest() {
        Client client = new Client(1, "Vova555", "Moscow", null);
        Client expected = new Client(1, "Vova555", "Moscow", null);
        expected.setActive(false);
        when(clientRepository.save(client)).thenReturn(expected);
        clientService.deleteClient(client);

        assertEquals(expected, client);
        verify(clientRepository).save(client);
    }

}
