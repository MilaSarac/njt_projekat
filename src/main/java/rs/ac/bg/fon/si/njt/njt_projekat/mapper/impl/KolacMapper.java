/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.mapper.impl;

import org.springframework.stereotype.Component;
import rs.ac.bg.fon.si.njt.njt_projekat.dto.impl.KolacDto;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Kolac;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Poslasticarnica;
import rs.ac.bg.fon.si.njt.njt_projekat.mapper.DtoEntityMapper;

/**
 *
 * @author Mila
 */

@Component
public class KolacMapper implements DtoEntityMapper<KolacDto, Kolac> {

    @Override
    public KolacDto toDto(Kolac e) {
        Long poslId = e.getPoslasticarnica() != null ? e.getPoslasticarnica().getId(): null;
        return new KolacDto(e.getId(), e.getNaziv(), e.getOpis(), e.getCenaPoKomadu(), e.getImageUrl(), poslId);
    }

    @Override
    public Kolac toEntity(KolacDto t) {
        Poslasticarnica posl = t.getPoslasticarnicaId() != null ? 
                new Poslasticarnica(t.getPoslasticarnicaId()) : null;
        return new Kolac(
                t.getId(), 
                t.getNaziv(), 
                t.getOpis(), 
                t.getCenaPoKomadu(), 
                t.getImageUrl(), 
                posl);
    }

    
    
}
