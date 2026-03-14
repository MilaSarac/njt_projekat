/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.MyEntity;

/**
 *
 * @author Mila
 */

@Entity
@Table(name = "klijent")
public class Klijent implements MyEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKlijent;
    private String ime;
    private String prezime;
    private String brojTelefona;
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "mesto_id")
    private Mesto mesto;

    public Klijent() {
    }

    public Klijent(Long idKlijent, String ime, String prezime, String brojTelefona, String email, Mesto mesto) {
        this.idKlijent = idKlijent;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.mesto = mesto;
    }

    public Klijent(Long idKlijent) {
        this.idKlijent = idKlijent;
    }

    public Long getIdKlijent() {
        return idKlijent;
    }

    public void setIdKlijent(Long idKlijent) {
        this.idKlijent = idKlijent;
    }
    
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }
    
}
