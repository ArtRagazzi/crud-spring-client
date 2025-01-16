package com.artragazzi.crud_spring.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tb_client")

public class Client {
    @Id
    @CPF
    @NotNull(message = "O campo nome não pode ser nulo")                // Validação na aplicação
    @Column(name = "cpf", nullable = false)                           // Restrição no banco
    private String cpf;
    @Column(nullable = false)
    private String name;

    //Length so funciona com String, para numero utilize @MAX E @MIN
    //@Column(nullable = false, length = 3)

    @Min(0)
    @Max(120)
    private Integer age;
    @Column(nullable = false)
    private String city;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
