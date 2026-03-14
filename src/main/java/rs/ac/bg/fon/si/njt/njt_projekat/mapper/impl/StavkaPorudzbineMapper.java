/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.mapper.impl;

import rs.ac.bg.fon.si.njt.njt_projekat.dto.impl.StavkaPorudzbineDto;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Kolac;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Porudzbina;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.StavkaPorudzbine;
import rs.ac.bg.fon.si.njt.njt_projekat.mapper.DtoEntityMapper;

/**
 *
 * @author Mila
 */
public class StavkaPorudzbineMapper implements DtoEntityMapper<StavkaPorudzbineDto, StavkaPorudzbine> {

    @Override
    public StavkaPorudzbineDto toDto(StavkaPorudzbine e) {
        Long porudzbinaId = e.getPorudzbina() != null ? e.getPorudzbina().getId() : null;
        Long kolacId = e.getKolac() != null ? e.getKolac().getId() : null;
        return new StavkaPorudzbineDto(
                e.getRb(),
                e.getIznos(),
                e.getCena(),
                e.getKolicina(),
                porudzbinaId,
                kolacId);
    }

    @Override
    public StavkaPorudzbine toEntity(StavkaPorudzbineDto t) {
        Porudzbina porudzbina = t.getPorudzbinaId() != null ? 
                new Porudzbina(t.getPorudzbinaId()) : null;
        Kolac kolac = t.getKolacId() != null ? new Kolac(t.getKolacId()) : null;
        return new StavkaPorudzbine(
                t.getRb(),
                t.getIznos(),
                t.getCena(),
                t.getKolicina(),
                porudzbina,
                kolac);
    }
    
}
