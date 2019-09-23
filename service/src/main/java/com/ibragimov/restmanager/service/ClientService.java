package com.ibragimov.restmanager.service;

import com.ibragimov.restmanager.dao.ClientRepository;
import com.ibragimov.restmanager.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public Client createClient(Client client) {
        logger.debug("Create new Client with name='{}'", client.getName());
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        logger.debug("Get all clients from table");
        return (List<Client>) clientRepository.findAll();
    }

    public Client getById(Integer id) {
        logger.debug("Get Client with id='{}'", id);
        return clientRepository.findById(id).orElse(null);
    }

    @Transactional
    public Client updateClient(Client client) {
        logger.debug("Edit Client with id='{}'", client.getId());
        return clientRepository.save(client);
    }

    public void deleteClient(Client client) {
        client.setActive(false);
        updateClient(client);
    }

}
