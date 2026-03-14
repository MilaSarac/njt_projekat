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
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Kolac;
import rs.ac.bg.fon.si.njt.njt_projekat.repository.MyAppRepository;

/**
 *
 * @author Mila
 */

@Repository
//obelezavamo da bi springova aplikaija znala posle koje klase su sta
//repository-ji su odgovorni za komunikaciju sa bazom podataka
//sve ove metode komuniciraju sa bazom preko EntityManager-a
public class KolacRepository implements MyAppRepository<Kolac, Long>{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Kolac> findAll() {
        return entityManager.createQuery(
                "SELECT k FROM Kolac k", 
                Kolac.class).getResultList();
    }

    @Override
    public Kolac findById(Long id) throws Exception {
        Kolac kolac = entityManager.find(Kolac.class, id);
        if(kolac == null){
            throw new Exception("Kolac nije pronadjen!");
        }
        return kolac;
    }

    @Override
    @Transactional
    public void save(Kolac entity) {
        if(entity.getId() == null){
            //ako nema id kreiraj obj
            entityManager.persist(entity);
        } else {
            //ako ima id azuriraj postojeci
            entityManager.merge(entity);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Kolac kolac = entityManager.find(Kolac.class, id);
        if(kolac != null){
            entityManager.remove(kolac);
        }
    }
    
}
