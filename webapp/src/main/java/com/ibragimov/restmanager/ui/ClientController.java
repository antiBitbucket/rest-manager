package com.ibragimov.restmanager.ui;

import com.ibragimov.restmanager.model.Client;
import com.ibragimov.restmanager.service.ClientService;
import com.ibragimov.restmanager.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClientController {

    private final ClientService clientService;
    private final ManagerService managerService;

    @Autowired
    public ClientController(ClientService clientService, ManagerService managerService) {
        this.clientService = clientService;
        this.managerService = managerService;
    }

    @RequestMapping(value = "/getClients", method = RequestMethod.GET)
    public ModelAndView getClients() {
        ModelAndView modelAndView = new ModelAndView("clients");
        List<Client> clients = clientService.getAllClients();
        clients.removeIf(client -> !client.isActive());
        modelAndView.addObject("clients", clients);
        return modelAndView;
    }

    @RequestMapping(value = "/updateClient", method = RequestMethod.GET)
    public ModelAndView showUpdateClient(@RequestParam(value = "clientId", required = false) Integer id) {
        if (id == null) {
            return new ModelAndView("main").addObject("message", "Не верный идентификатор");
        }
        Client client = clientService.getById(id);
        ModelAndView modelAndView = new ModelAndView("updateClient");
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    @RequestMapping(value = "/updateClient", method = RequestMethod.POST)
    public String doUpdateClient(@ModelAttribute Client client) {
        Client newClient = new Client(client.getId(), client.getName(), client.getAddress(), client.getManager());
        newClient = clientService.updateClient(newClient);
        return "redirect:/showClientPage?clientId=" + newClient.getId();
    }

    @RequestMapping(value = "/showClientPage", method = RequestMethod.GET)
    public ModelAndView showClientPage(@RequestParam(value = "clientId") Integer id) {
        ModelAndView modelAndView = new ModelAndView("clientPage");
        Client client = clientService.getById(id);
        modelAndView.addObject("client", client);
        return modelAndView;
    }

    @RequestMapping(value = "/createClient", method = RequestMethod.GET)
    public ModelAndView showCreateClient() {
        ModelAndView modelAndView = new ModelAndView("createClient");
        modelAndView.addObject("managers", managerService.getAllManagers());
        return modelAndView;
    }

    @RequestMapping(value = "/createClient", method = RequestMethod.POST)
    public String doCreateClient(@ModelAttribute Client client) {
        Client newClient = new Client(client.getName(), client.getAddress(), client.getManager());
        newClient = clientService.createClient(newClient);
        return "redirect:/showClientPage?clientId=" + newClient.getId();
    }

    @RequestMapping(value = "/deleteClient", method = RequestMethod.POST)
    public String deleteClient(@RequestParam(value = "clientId") Integer id) {
        Client deletedClient = clientService.getById(id);
        clientService.deleteClient(deletedClient);
        return "redirect:/getClients";
    }

}
