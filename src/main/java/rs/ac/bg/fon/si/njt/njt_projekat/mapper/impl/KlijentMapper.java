/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.mapper.impl;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.si.njt.njt_projekat.dto.impl.KlijentDto;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Klijent;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Mesto;
import rs.ac.bg.fon.si.njt.njt_projekat.mapper.DtoEntityMapper;

/**
 *
 * @author Mila
 */

@Component
public class KlijentMapper implements DtoEntityMapper<KlijentDto, Klijent> {

    @Override
    public KlijentDto toDto(Klijent e) {
        Long mestoId = e.getMesto() != null ? e.getMesto().getIdMesto() : null;
        return new KlijentDto(e.getIdKlijent(), e.getIme(), e.getPrezime(), e.getBrojTelefona(), e.getEmail(), mestoId);
    }

    @Override
    public Klijent toEntity(KlijentDto t) {
        Mesto mesto = t.getMestoId() != null ? 
                new Mesto(t.getMestoId()) : null;
        return new Klijent(
                t.getIdKlijent(),
                t.getIme(),
                t.getPrezime(),
                t.getBrojTelefona(),
                t.getEmail(),
                mesto);
    }
    
}
