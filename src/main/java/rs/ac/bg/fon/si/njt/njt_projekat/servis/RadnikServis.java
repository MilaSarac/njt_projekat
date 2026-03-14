/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.servis;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.si.njt.njt_projekat.dto.impl.RadnikDto;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Radnik;
import rs.ac.bg.fon.si.njt.njt_projekat.mapper.impl.RadnikMapper;
import rs.ac.bg.fon.si.njt.njt_projekat.repository.impl.RadnikRepository;

/**
 *
 * @author Mila
 */

@Service
public class RadnikServis {
    
    private final RadnikRepository radnikRepository;
    private final RadnikMapper radnikMapper;

    @Autowired
    public RadnikServis(RadnikRepository radnikRepository, RadnikMapper radnikMapper) {
        this.radnikRepository = radnikRepository;
        this.radnikMapper = radnikMapper;
    }
    
    public List<RadnikDto> findAll(){
        return radnikRepository.findAll() 
                .stream()
                .map(radnikMapper::toDto) 
                .collect(Collectors.toList()); 
    }
    
    public RadnikDto create(RadnikDto radnikDto) {
        Radnik radnik = radnikMapper.toEntity(radnikDto);
        radnikRepository.save(radnik);
        return radnikMapper.toDto(radnik);
    }
    
    public void deleteById(Long id) {
        radnikRepository.deleteById(id);
    }
    
    public RadnikDto update(RadnikDto radnikDto) {
        Radnik updated = radnikMapper.toEntity(radnikDto);
        radnikRepository.save(updated);
        return radnikMapper.toDto(updated);
    }
}
