package com.artragazzi.crud_spring.ClientService;

import com.artragazzi.crud_spring.exceptions.ClientCPFNotFoundException;
import com.artragazzi.crud_spring.model.Client;
import com.artragazzi.crud_spring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Transactional
    public Client insert(Client client){
        return clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Client findById(String cpf){
        return clientRepository.findById(cpf).orElseThrow(()-> new ClientCPFNotFoundException(cpf));
    }

    @Transactional
    public void delete(String cpf){
        clientRepository.deleteById(cpf);
    }

    @Transactional
    public Client update(String cpf, Client newClient){
        Client client = clientRepository.findById(cpf).orElseThrow(()->new ClientCPFNotFoundException(cpf));
        client.setName(newClient.getName());
        client.setCity(newClient.getCity());
        client.setAge(newClient.getAge());
        return clientRepository.save(client);
    }


}
