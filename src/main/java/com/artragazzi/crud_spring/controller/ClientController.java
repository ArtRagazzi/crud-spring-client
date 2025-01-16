package com.artragazzi.crud_spring.controller;

import com.artragazzi.crud_spring.ClientService.ClientService;
import com.artragazzi.crud_spring.model.Client;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> insert(@Valid @RequestBody Client client) {
        return ResponseEntity.ok(clientService.insert(client));
    }

    @GetMapping
    public ResponseEntity<List<Client>>findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<Client>findByCPF(@PathVariable String cpf){
        Client clientFinded = clientService.findById(cpf);
        return ResponseEntity.ok().body(clientFinded);
    }

    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity<Client> delete (@PathVariable String cpf){
        clientService.delete(cpf);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{cpf}")
    public ResponseEntity<Client> update(@PathVariable String cpf, @RequestBody Client clientUpdated){
        clientUpdated = clientService.update(cpf, clientUpdated);
        return ResponseEntity.ok().body(clientUpdated);
    }

}
