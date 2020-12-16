package com.vaadin.starter.data.service;

import com.vaadin.starter.data.entity.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

@Service
public class AddressService extends CrudService<Address, Integer> {

    private AddressRepository repository;

    public AddressService(@Autowired AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    protected AddressRepository getRepository() {
        return repository;
    }

}
