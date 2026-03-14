/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.mapper.impl;

import rs.ac.bg.fon.si.njt.njt_projekat.dto.impl.RadnikDto;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Radnik;

import rs.ac.bg.fon.si.njt.njt_projekat.mapper.DtoEntityMapper;

/**
 *
 * @author Mila
 */
public class RadnikMapper implements DtoEntityMapper<RadnikDto, Radnik> {

    @Override
    public RadnikDto toDto(Radnik e) {
        return new RadnikDto(e.getIdRadnik(), e.getIme(), e.getPrezime(), e.getUsername(), e.getPassword());
    }

    @Override
    public Radnik toEntity(RadnikDto t) {
        return new Radnik(t.getIdRadnik(), t.getIme(), t.getPrezime(), t.getUsername(), t.getPassword());
    }
    
}
