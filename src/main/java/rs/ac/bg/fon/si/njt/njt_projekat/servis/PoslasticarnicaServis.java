/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.servis;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.si.njt.njt_projekat.dto.impl.PoslasticarnicaDto;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Poslasticarnica;
import rs.ac.bg.fon.si.njt.njt_projekat.mapper.impl.PoslasticarnicaMapper;
import rs.ac.bg.fon.si.njt.njt_projekat.repository.impl.PoslasticarnicaRepository;

/**
 *
 * @author Mila
 */

@Service
//automatski registruje ovu klasu kao bean u app tacnije application context-u
//zato ne moramo da napisemo PoslasticarnicaServis = new PoslasticarnicaServis();
//mapiranje
public class PoslasticarnicaServis {
    
    private final PoslasticarnicaRepository poslRep;
    private final PoslasticarnicaMapper poslMap;

    @Autowired
    //automatski da uradi ovo
    public PoslasticarnicaServis(PoslasticarnicaRepository poslRep, PoslasticarnicaMapper poslMap) {
        this.poslRep = poslRep;
        this.poslMap = poslMap;
    }
    
    //mora da vrati Dto kontroleru
    //a repository mu daje entity
    public List<PoslasticarnicaDto> findAll(){
        return poslRep.findAll() //lista poslasticarnica entity-ja
                .stream() //pretvara listu u stream, stream api omogucava da nad celom listom ili nizom izvrsimo neke operacije u ansem slucaju .map i .collect
                .map(poslMap::toDto) //za svaku posl iz liste ce da pozove iz poslmappera toDto i vraca dto objekat
                .collect(Collectors.toList()); //taj dto objkeat uz pomoc ove f-je se pakuje u listu
    }
    
    public PoslasticarnicaDto findById(Long id) throws Exception{
        return poslMap.toDto(poslRep.findById(id));
    }

    public PoslasticarnicaDto create(PoslasticarnicaDto poslDto) {
        Poslasticarnica posl = poslMap.toEntity(poslDto);
        poslRep.save(posl);
        return poslMap.toDto(posl);
    }

    public void deleteById(Long id) {
        poslRep.deleteById(id);
    }

    public PoslasticarnicaDto update(PoslasticarnicaDto poslDto) {
        Poslasticarnica updated = poslMap.toEntity(poslDto);
        poslRep.save(updated);
        return poslMap.toDto(updated);
    }
    
    
    
}
