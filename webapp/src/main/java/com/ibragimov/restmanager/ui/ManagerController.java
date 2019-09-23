package com.ibragimov.restmanager.ui;

import com.ibragimov.restmanager.model.Manager;
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
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @RequestMapping(value = "/")
    public String index() {
        return "redirect:/getHome";
    }

    @RequestMapping(value = "/getHome", method = RequestMethod.GET)
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView("main");
        String message = "Вы на главной странице управления клиентами. Воспользуйтесь кнопками навигации";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value = "/getManagers", method = RequestMethod.GET)
    public ModelAndView getManagers() {
        ModelAndView modelAndView = new ModelAndView("managers");
        List<Manager> managers = managerService.getAllManagers();
        managers.removeIf(manager -> !manager.isActive());
        modelAndView.addObject("managers", managers);
        return modelAndView;
    }

    @RequestMapping(value = "/updateManager", method = RequestMethod.GET)
    public ModelAndView showUpdateManager(@RequestParam(value = "managerId", required = false) Integer id) {
        if (id == null) {
            return new ModelAndView("main").addObject("message", "Не верный идентификатор");
        }
        Manager manager = managerService.getById(id);
        ModelAndView modelAndView = new ModelAndView("updateManager");
        modelAndView.addObject("manager", manager);
        modelAndView.addObject("assistants", managerService.getAllManagers());
        return modelAndView;
    }

    @RequestMapping(value = "/updateManager", method = RequestMethod.POST)
    public String doUpdateManager(@ModelAttribute Manager manager) {
        Manager newManager = new Manager(manager.getName(), manager.getSurname(), manager.getMiddlename(),
                manager.getPhone(), manager.getAssistant());
        newManager = managerService.updateManager(newManager);
        return "redirect:/showManagerPage?managerId=" + newManager.getId();
    }

    @RequestMapping(value = "/showManagerPage", method = RequestMethod.GET)
    public ModelAndView showManagerPage(@RequestParam(value = "managerId") Integer id) {
        ModelAndView modelAndView = new ModelAndView("managerPage");
        Manager manager = managerService.getById(id);
        modelAndView.addObject("clients", manager.getClients()).addObject("manager", manager);
        return modelAndView;
    }

    @RequestMapping(value = "/createManager", method = RequestMethod.GET)
    public ModelAndView showCreateManager() {
        ModelAndView modelAndView = new ModelAndView("createManager");
        modelAndView.addObject("assistants", managerService.getAllManagers());
        return modelAndView;
    }

    @RequestMapping(value = "/createManager", method = RequestMethod.POST)
    public String doCreateManager(@ModelAttribute Manager manager) {
        Manager newManager = new Manager(manager.getName(), manager.getSurname(), manager.getMiddlename(),
                manager.getPhone(), manager.getAssistant());
        newManager = managerService.createManager(newManager);
        return "redirect:/showManagerPage?managerId=" + newManager.getId();
    }

    @RequestMapping(value = "/deleteManager", method = RequestMethod.POST)
    public String deleteManager(@RequestParam(value = "managerId") Integer id) {
        Manager deletedManager = managerService.getById(id);
        managerService.deleteManager(deletedManager);
        return "redirect:/getManagers";
    }

}
