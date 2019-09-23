package com.ibragimov.restmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MANAGER_TBL")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String name;
    private String middlename;
    private String phone;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assistant")
    private Manager assistant;
    @Column(name = "status")
    private boolean active;
    @JsonIgnore
    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
    private List<Client> clients = new ArrayList<>();

    public Manager() {
    }

    public Manager(Integer id, String surname, String name, String middlename, String phone, Manager assistant) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.phone = phone;
        this.assistant = assistant;
        active = true;
    }

    public Manager(String surname, String name, String middlename, String phone, Manager assistant) {
        this(null, surname, name, middlename, phone, assistant);
    }

    public Manager(String surname, String name, String middlename, String phone) {
        this(surname, name, middlename, phone, null);
    }

    public Manager(String surname, String name, String phone) {
        this(surname, name, null, phone);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Manager getAssistant() {
        return assistant;
    }

    public void setAssistant(Manager assistant) {
        this.assistant = assistant;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Manager)) {
            return false;
        }
        Manager manager = (Manager) o;
        return Objects.equals(id, manager.id) &&
                Objects.equals(phone, manager.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phone);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middlename='" + middlename + '\'' +
                ", phone='" + phone + '\'' +
                ", assistant=" + assistant +
                '}';
    }

}
