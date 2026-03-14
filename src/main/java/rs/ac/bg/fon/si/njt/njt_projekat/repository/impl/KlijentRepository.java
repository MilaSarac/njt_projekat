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
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Klijent;
import rs.ac.bg.fon.si.njt.njt_projekat.repository.MyAppRepository;

/**
 *
 * @author Mila
 */

@Repository
public class KlijentRepository implements MyAppRepository<Klijent, Long> {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Klijent> findAll() {
        return entityManager.createQuery(
                "SELECT k FROM Klijent k", 
                Klijent.class).getResultList();
    }

    @Override
    public Klijent findById(Long id) throws Exception {
        Klijent klijent = entityManager.find(Klijent.class, id);
        if(klijent == null){
            throw new Exception("Mesto nije pronadjeno!");
        }
        return klijent;
    }

    @Override
    @Transactional
    public void save(Klijent entity) {
        if(entity.getIdKlijent() == null){
            entityManager.persist(entity);
        } else{
            entityManager.merge(entity);
        }
    }
    
    @Override
    @Transactional
    public void deleteById(Long id) {
        Klijent klijent = entityManager.find(Klijent.class, id);
        if(klijent != null){
            entityManager.remove(klijent);
        }
    }
    
}
