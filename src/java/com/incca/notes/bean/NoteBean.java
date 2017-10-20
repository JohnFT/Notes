/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.notes.bean;

import com.incca.notes.client.notes.Notes;
import com.incca.notes.client.notes.NotesWS;
import com.incca.notes.client.notes.NotesWS_Service;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author JohnF
 */
@ManagedBean
public class NoteBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/NotesAPI2/NotesWS.wsdl")
    private NotesWS_Service service;

    private Notes nota;
    private List<Notes> notas;

    public NoteBean() {
        nota = new Notes();
        notas = new ArrayList<>();
    }

    public void add() {
        if (addNotes(nota)) {
            notas = findByUser(2);
        }
    }

    public Notes getNota() {
        return nota;
    }

    public void setNota(Notes nota) {
        this.nota = nota;
    }

    public List<Notes> getNotes() {
        return notas;
    }

    public void setNotes(List<Notes> notas) {
        this.notas = notas;
    }

    private Boolean addNotes(Notes note) {
        NotesWS port = service.getNotesWSPort();
        return port.addNotes(note);
    }

    private java.util.List<Notes> findByUser(int useCode) {
        NotesWS port = service.getNotesWSPort();
        return port.findByUser(useCode);
    }

}
