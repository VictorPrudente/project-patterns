package com.bootcamp.dio.projectpatterns.service;


import com.bootcamp.dio.projectpatterns.entities.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json")
    Address findCep(@PathVariable("cep") String cep);

}
