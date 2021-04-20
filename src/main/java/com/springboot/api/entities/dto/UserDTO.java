package com.springboot.api.entities.dto;

import com.springboot.api.entities.User;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserDTO {

    @NotBlank(message = "{name.not.blank}")
    private String name;


    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;

    @NotBlank(message = "{cpf.not.blank}")
    @CPF(message ="{cpf.not.valid}")
    private String cpf;

    @NotBlank(message = "{birthdate.not.blank}")
    private String birthdate;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.birthdate = sdf.format(user.getBirthdate());
    }

    public UserDTO(String name, String email, String cpf, String birthdate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public User toUser() {

        User user = new User();

        user.setName(this.name);
        user.setEmail(this.email);
        user.setCpf(this.cpf);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            user.setBirthdate(sdf.parse(this.birthdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return user;
    }
}
