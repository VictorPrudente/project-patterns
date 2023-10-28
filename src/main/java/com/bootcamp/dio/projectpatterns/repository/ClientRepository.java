package com.bootcamp.dio.projectpatterns.repository;


import com.bootcamp.dio.projectpatterns.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    
}
