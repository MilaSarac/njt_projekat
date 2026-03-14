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
import rs.ac.bg.fon.si.njt.njt_projekat.entity.impl.Mesto;
import rs.ac.bg.fon.si.njt.njt_projekat.repository.MyAppRepository;

/**
 *
 * @author Mila
 */
@Repository
public class MestoRepository implements MyAppRepository<Mesto, Long> {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Mesto> findAll() {
        return entityManager.createQuery(
                "SELECT m FROM Mesto m", 
                Mesto.class).getResultList();
    }
    
    @Override
    public Mesto findById(Long id) throws Exception {
        Mesto mesto = entityManager.find(Mesto.class, id);
        if(mesto == null){
            throw new Exception("Mesto nije pronadjeno!");
        }
        return mesto;
    }

    @Override
    @Transactional
    public void save(Mesto entity) {
        if(entity.getIdMesto() == null){
            entityManager.persist(entity);
        } else{
            entityManager.merge(entity);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Mesto mesto = entityManager.find(Mesto.class, id);
        if(mesto != null){
            entityManager.remove(mesto);
        }
    }
    
    
}
