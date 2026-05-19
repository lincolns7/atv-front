/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.front.atv.service;

import com.front.atv.model.UserDTO;
import com.front.atv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Aluno
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private TokenService tokenService;
    
    public void register(UserDTO user) {
        String mensagem = "";
        if (user.getNome(). equals("")) {
            mensagem = "Nome não preenchido";
        }
        else if(user.getEmail().equals("")) {
            mensagem = "Email não preenchido";
        }
        else if(user.getSenha().equals("")) {
            mensagem = "Senha não preenchido";
        }
        else if(user.getRole().equals("")) {
            mensagem = "FORNECEDOR";
        }
        
        if (!mensagem.equals("")) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), mensagem);
        }
        
        repository.register(user);
    }
    public String login(UserDTO user) {
        String mensagem = "";
        if (user.getEmail().equals("")) {
            mensagem = "Email não preenchido";
        }
        else if (user.getSenha().equals("")) {
            mensagem = "Senha não preenchida";
        }
        
        if (!mensagem.equals("")) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), mensagem);
        }
        
        UserDTO dadosLogados = repository.login(user.getEmail(), user.getSenha());
        return tokenService.gerarToken(dadosLogados);
    }
}
