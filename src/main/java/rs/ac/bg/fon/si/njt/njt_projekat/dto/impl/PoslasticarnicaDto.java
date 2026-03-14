/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.dto.impl;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import rs.ac.bg.fon.si.njt.njt_projekat.dto.Dto;

/**
 *
 * @author Mila
 */

//zaduzena za validaciju
public class PoslasticarnicaDto implements Dto{
    
    private Long id;
    //obavezno polje
    @NotEmpty(message = "Name iz required.")
    private String naziv;
    @NotBlank(message = "Address iz required.")
    @Size(max=200, message = "Address cannot be longer than 200 characters.")
    private String adresa;

    public PoslasticarnicaDto() {
    }

    public PoslasticarnicaDto(Long id, String naziv, String adresa) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    
}
