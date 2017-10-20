/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.notes.bean;


import com.incca.notes.client.users.UsersWS;
import com.incca.notes.client.users.UsersWS_Service;
import com.incca.notes.client.users.Users;
import javax.faces.bean.ManagedBean;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author JohnF
 */
@ManagedBean
public class UserBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/NotesAPI2/UsersWS.wsdl")
    private UsersWS_Service service;
    private Users usuarios;
    private String message;
   
    public void add() {
        if (addUser(usuarios)) {
            message = "Se ha creado el usuario";
        } else {
            message = "Error";
        }
    }
    
     public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Users getUsers() {
        return usuarios;
    }


    public void setUsers(Users usuarios) {
        this.usuarios = usuarios;
    }

    public UserBean() {
        usuarios = new Users();
    }

    private Boolean addUser(Users user) {
        UsersWS port = service.getUsersWSPort();
        return port.add(user);
    }

}
