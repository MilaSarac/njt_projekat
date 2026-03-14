/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.dto.impl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.Date;
import java.util.List;
import rs.ac.bg.fon.si.njt.njt_projekat.dto.Dto;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Klijent;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Radnik;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.StavkaPorudzbine;

/**
 *
 * @author Mila
 */
public class PorudzbinaDto implements Dto {
    
    private Long id;
    @NotNull(message = "Datum je obavezan")
    private Date datum;
    @NotNull(message = "Price is required.")
    @Positive(message = "Price must be greater than zero.")
    private Double ukupanIznos;
    @NotNull(message = "Porudzbina mora imati klijenta")
    private Long klijentId;
    @NotNull(message = "Porudzbina mora imati radnika")
    private Long radnikId;
    @Valid
    @NotEmpty(message = "racun mora imati bar jednu stavku")
    private List<StavkaPorudzbineDto> stavkePorudzbine;

    public PorudzbinaDto() {
    }

    public PorudzbinaDto(Long id, Date datum, Double ukupanIznos, Long klijentId, Long radnikId, List<StavkaPorudzbineDto> stavkePorudzbine) {
        this.id = id;
        this.datum = datum;
        this.ukupanIznos = ukupanIznos;
        this.klijentId = klijentId;
        this.radnikId = radnikId;
        this.stavkePorudzbine = stavkePorudzbine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(Double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Long getKlijentId() {
        return klijentId;
    }

    public void setKlijentId(Long klijentId) {
        this.klijentId = klijentId;
    }

    public Long getRadnikId() {
        return radnikId;
    }

    public void setRadnikId(Long radnikId) {
        this.radnikId = radnikId;
    }

    public List<StavkaPorudzbineDto> getStavkePorudzbine() {
        return stavkePorudzbine;
    }

    public void setStavkePorudzbine(List<StavkaPorudzbineDto> stavkePorudzbine) {
        this.stavkePorudzbine = stavkePorudzbine;
    }

    
}
