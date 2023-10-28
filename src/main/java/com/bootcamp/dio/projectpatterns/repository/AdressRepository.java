package com.bootcamp.dio.projectpatterns.repository;


import com.bootcamp.dio.projectpatterns.entities.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends CrudRepository<Address, String> {
}
