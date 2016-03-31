/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.linkedin.DAO;

import com.br.linkedin.entities.Profissionais;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author 41411803
 */
@Stateless
public class ProfissionaisDAO implements GenericDAO<Profissionais> {
    
    private EntityManager em;

    @Override
    public void persist(Profissionais e) {
        em.persist(e);
    }

    @Override
    public List<Profissionais> read() {
        List<Profissionais> profissionais  = em.createQuery("SELECT c FROM Profissionais c", Profissionais.class).getResultList();
        return profissionais;
    }

    @Override
    public Profissionais readById(long id) {
        Profissionais profissionais = em.find(Profissionais.class, id);
        return profissionais;
    }

    @Override
    public void delete(Profissionais e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
