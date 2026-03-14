/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.servis;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.si.njt.njt_projekat.dto.impl.MestoDto;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Mesto;
import rs.ac.bg.fon.si.njt.njt_projekat.mapper.impl.MestoMapper;
import rs.ac.bg.fon.si.njt.njt_projekat.repository.impl.MestoRepository;

/**
 *
 * @author Mila
 */

@Service
public class MestoServis {
    
    private final MestoRepository mestoRepository;
    private final MestoMapper mestoMapper;

    @Autowired
    public MestoServis(MestoRepository mestoRepository, MestoMapper mestoMapper) {
        this.mestoRepository = mestoRepository;
        this.mestoMapper = mestoMapper;
    }
    
    public List<MestoDto> findAll(){
        return mestoRepository.findAll() 
                .stream()
                .map(mestoMapper::toDto) 
                .collect(Collectors.toList()); 
    }
    
    public MestoDto create(MestoDto mestoDto) {
        Mesto mesto = mestoMapper.toEntity(mestoDto);
        mestoRepository.save(mesto);
        return mestoMapper.toDto(mesto);
    }
    
    public void deleteById(Long id) {
        mestoRepository.deleteById(id);
    }
    
    public MestoDto update(MestoDto mestoDto) {
        Mesto updated = mestoMapper.toEntity(mestoDto);
        mestoRepository.save(updated);
        return mestoMapper.toDto(updated);
    }
}
