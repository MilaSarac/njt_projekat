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
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Radnik;
import rs.ac.bg.fon.si.njt.njt_projekat.repository.MyAppRepository;

/**
 *
 * @author Mila
 */

@Repository
public class RadnikRepository implements MyAppRepository<Radnik, Long> {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Radnik> findAll() {
        return entityManager.createQuery(
                "SELECT r FROM Radnik r", 
                Radnik.class).getResultList();
    }

    @Override
    public Radnik findById(Long id) throws Exception {
        Radnik radnik = entityManager.find(Radnik.class, id);
        if(radnik == null){
            throw new Exception("Mesto nije pronadjeno!");
        }
        return radnik;
    }

    @Override
    @Transactional
    public void save(Radnik entity) {
        if(entity.getIdRadnik() == null){
            entityManager.persist(entity);
        } else{
            entityManager.merge(entity);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Radnik radnik = entityManager.find(Radnik.class, id);
        if(radnik != null){
            entityManager.remove(radnik);
        }
    }
    
    /*public Radnik findByUsername(String username){
    }
    
    public boolean existsByUsername(String username){
    }

    public boolean existsByEmail(String email){
    }*/
}
