/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import rs.ac.bg.fon.si.njt.njt_projekat.dto.impl.PorudzbinaDto;
import rs.ac.bg.fon.si.njt.njt_projekat.dto.impl.StavkaPorudzbineDto;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Klijent;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Porudzbina;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Radnik;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.StavkaPorudzbine;
import rs.ac.bg.fon.si.njt.njt_projekat.mapper.DtoEntityMapper;

/**
 *
 * @author Mila
 */
public class PorudzbinaMapper implements DtoEntityMapper<PorudzbinaDto, Porudzbina> {

    private final StavkaPorudzbineMapper stavkaMapper;

    public PorudzbinaMapper(StavkaPorudzbineMapper stavkaMapper) {
        this.stavkaMapper = stavkaMapper;
    }
    
    @Override
    public PorudzbinaDto toDto(Porudzbina e) {
        Long radnikId = e.getRadnik() != null ? e.getRadnik().getIdRadnik() : null;
        Long klijentId = e.getKlijent() != null ? e.getKlijent().getIdKlijent() : null;
        List<StavkaPorudzbineDto> stavke = new ArrayList<>();
        if(e.getStavkePorudzbine()!=null) {
            stavke = e.getStavkePorudzbine()
                    .stream()
                    .map(stavkaMapper::toDto)
                    .collect(Collectors.toList());
        }
        return new PorudzbinaDto(e.getId(), 
                e.getDatum(), 
                e.getUkupanIznos(), 
                klijentId, 
                radnikId, 
                stavke);
    }
    

    @Override
    public Porudzbina toEntity(PorudzbinaDto t) {
        Radnik radnik = t.getRadnikId() != null ? 
                new Radnik(t.getRadnikId()) : null;
        Klijent klijent = t.getKlijentId() != null ? new Klijent(t.getKlijentId()) : null;
        List<StavkaPorudzbine> stavke = new ArrayList<>();
        if(t.getStavkePorudzbine()!=null) {
            stavke = t.getStavkePorudzbine()
                    .stream()
                    .map(stavkaMapper::toEntity)
                    .collect(Collectors.toList());
        }
        /*if(t.getStavkePorudzbine()!=null){
            t.getStavkePorudzbine().forEach(d -> o.addItem(itemMapper.toEntity(d)));
        }*/
        return new Porudzbina(t.getId(), 
                t.getDatum(), 
                t.getUkupanIznos(), 
                klijent, 
                radnik, 
                stavke);
    }
    
}
