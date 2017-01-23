/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uits.school.web.controller;

/**
 *
 * @author user
 */
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super();
    }
    
    public UserNotFoundException(String s) {
        super(s);
    }   
    
}
