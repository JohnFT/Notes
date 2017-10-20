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
public class LoginBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/NotesAPI2/UsersWS.wsdl")
    private UsersWS_Service service;

    private String nickname;
    private String pass;

    public String sigIn() {
        if (login(nickname, pass) != null) {
            return "home";
        }
        return null;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private Users login(String nickname, String pass) {
        UsersWS port = service.getUsersWSPort();
        return port.login(nickname, pass);
    }

}
