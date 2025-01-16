package com.artragazzi.crud_spring.exceptions;

public class ClientCPFNotFoundException extends RuntimeException {
    public ClientCPFNotFoundException(String cpf) {
        super("Cliente com CPF " + cpf + " não encontrado.");
    }
}
