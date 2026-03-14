/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.entity.impl;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.MyEntity;

/**
 *
 * @author Mila
 */

@Entity
@Table(name = "poslasticarnica")
//marker interface-i koji imaju ulogu da klasu samo oznace kao entity
public class Poslasticarnica implements MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private String adresa;
    
    @OneToMany (mappedBy = "poslasticarnica", cascade = CascadeType.ALL)
    //veza je definisana u klasi Kolac, u polju "poslasticarnica"
    //sve operacije na poslasticarnici prenose se na njene proizvode
    private List<Kolac> kolaci;

    public Poslasticarnica() {
    }

    public Poslasticarnica(Long id, String naziv, String adresa, List<Kolac> kolaci) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.kolaci = kolaci;
    }

    public Poslasticarnica(Long poslasticarnicaId) {
        this.id = poslasticarnicaId;
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

    public List<Kolac> getKolaci() {
        return kolaci;
    }

    public void setKolaci(List<Kolac> kolaci) {
        this.kolaci = kolaci;
    }
    
    
}
