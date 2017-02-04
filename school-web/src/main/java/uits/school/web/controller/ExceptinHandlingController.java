/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uits.school.web.controller;

//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author user
 */
@ControllerAdvice
public class ExceptinHandlingController {
    
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFoundHandler(){
        System.out.println("user not found");
        return "error/404";
    }
    
}
