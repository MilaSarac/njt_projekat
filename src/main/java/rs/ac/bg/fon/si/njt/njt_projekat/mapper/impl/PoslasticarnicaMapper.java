/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.mapper.impl;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.si.njt.njt_projekat.dto.impl.PoslasticarnicaDto;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Poslasticarnica;
import rs.ac.bg.fon.si.njt.njt_projekat.mapper.DtoEntityMapper;

/**
 *
 * @author Mila
 */

@Component
public class PoslasticarnicaMapper implements DtoEntityMapper<PoslasticarnicaDto, Poslasticarnica> {

    @Override
    public PoslasticarnicaDto toDto(Poslasticarnica e) {
        /*PoslasticarnicaDto dto = new PoslasticarnicaDto(e.getId(), e.getNaziv(), e.getAdresa());
        return dto;*/
        return new PoslasticarnicaDto(e.getId(), e.getNaziv(), e.getAdresa());
    }

    @Override
    public Poslasticarnica toEntity(PoslasticarnicaDto t) {
        return new Poslasticarnica(t.getId(), t.getNaziv(), t.getAdresa(), null);
    }
    
}
