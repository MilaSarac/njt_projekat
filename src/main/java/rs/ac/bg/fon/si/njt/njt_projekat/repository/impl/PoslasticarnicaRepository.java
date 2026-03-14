/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.si.njt.njt_projekat.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Poslasticarnica;
import rs.ac.bg.fon.si.njt.njt_projekat.repository.MyAppRepository;

/**
 *
 * @author Mila
 */

@Repository
public class PoslasticarnicaRepository implements MyAppRepository<Poslasticarnica, Long> {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Poslasticarnica> findAll() {
        return entityManager.createQuery(
                "SELECT p FROM Poslasticarnica p", 
                Poslasticarnica.class).getResultList();
    }

    @Override
    public Poslasticarnica findById(Long id) throws Exception {
        Poslasticarnica posl = entityManager.find(Poslasticarnica.class, id);
        if(posl == null){
            throw new Exception("Poslasticarnica nije pronadjena!");
        }
        return posl;
    }

    @Override
    @Transactional
    //treba da se operacija obavi u okviru jedne transakcije pa ne pisemo begin, commit..
    public void save(Poslasticarnica entity) {
        if(entity.getId() == null){
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Poslasticarnica posl = entityManager.find(Poslasticarnica.class, id);
        if(posl!= null){
            entityManager.remove(posl);
        }
    }
    
}
