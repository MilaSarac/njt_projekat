/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.servis;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.si.njt.njt_projekat.dto.impl.KlijentDto;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Klijent;
import rs.ac.bg.fon.si.njt.njt_projekat.mapper.impl.KlijentMapper;
import rs.ac.bg.fon.si.njt.njt_projekat.repository.impl.KlijentRepository;


/**
 *
 * @author Mila
 */

@Service
public class KlijentServis {
    
    private final KlijentRepository klijentRepository;
    private final KlijentMapper klijentMapper;

    @Autowired
    public KlijentServis(KlijentRepository klijentRepository, KlijentMapper klijentMapper) {
        this.klijentRepository = klijentRepository;
        this.klijentMapper = klijentMapper;
    }
    
    public List<KlijentDto> findAll(){
        return klijentRepository.findAll() 
                .stream()
                .map(klijentMapper::toDto) 
                .collect(Collectors.toList()); 
    }
    
    public KlijentDto create(KlijentDto klijentDto) {
        Klijent klijent = klijentMapper.toEntity(klijentDto);
        klijentRepository.save(klijent);
        return klijentMapper.toDto(klijent);
    }
    
    public void deleteById(Long id) {
        klijentRepository.deleteById(id);
    }
    
    public KlijentDto update(KlijentDto klijentDto) {
        Klijent updated = klijentMapper.toEntity(klijentDto);
        klijentRepository.save(updated);
        return klijentMapper.toDto(updated);
    }
    
}
