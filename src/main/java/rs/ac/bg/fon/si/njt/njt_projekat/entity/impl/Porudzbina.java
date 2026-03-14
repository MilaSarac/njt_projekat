/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.entity.impl;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.MyEntity;

/**
 *
 * @author Mila
 */

@Entity
@Table(name = "porudzbina")
public class Porudzbina implements MyEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datum;
    private Double ukupanIznos;

    @ManyToOne()
    @JoinColumn(name = "klijent_id")
    private Klijent klijent;

    @ManyToOne
    @JoinColumn(name = "radnik_id")
    private Radnik radnik;
    
    @OneToMany(mappedBy = "racun", cascade = CascadeType.ALL, fetch =FetchType.EAGER)
    private List<StavkaPorudzbine> stavkePorudzbine;

    public Porudzbina() {
    }
    
    public Porudzbina(Long id) {
        this.id = id;
    }

    public Porudzbina(Long id, Date datum, Double ukupanIznos, Klijent klijent, Radnik radnik, List<StavkaPorudzbine> stavkePorudzbine) {
        this.id = id;
        this.datum = datum;
        this.ukupanIznos = ukupanIznos;
        this.klijent = klijent;
        this.radnik = radnik;
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

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public List<StavkaPorudzbine> getStavkePorudzbine() {
        return stavkePorudzbine;
    }

    public void setStavkePorudzbine(List<StavkaPorudzbine> stavkePorudzbine) {
        this.stavkePorudzbine = stavkePorudzbine;
    }
    
    
}
