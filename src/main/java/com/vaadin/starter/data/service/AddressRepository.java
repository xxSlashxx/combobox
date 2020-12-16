package com.vaadin.starter.data.service;

import com.vaadin.starter.data.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}