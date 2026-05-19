/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.front.atv.controller;

import com.front.atv.model.UserDTO;
import com.front.atv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService service;
    
    @PostMapping("/registrar")
    public String registrar(@RequestBody UserDTO user) {
        service.register(user);
        return "Cadastro feito com sucesso!";
    }
    
    @PostMapping("/logar")
    public String login(@RequestBody UserDTO user) {
        return service.login(user);
        
    }
}
