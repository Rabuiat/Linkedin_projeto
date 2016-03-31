/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.linkedin.DAO;

import com.br.linkedin.entities.Busca;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author 41411803
 */
@Stateless
public class BuscaDAO implements GenericDAO<Busca> {
    
    private EntityManager em;

    @Override
    public void persist(Busca e) {
        em.persist(e);
    }

    @Override
    public List<Busca> read() {
        List<Busca> buscas = em.createQuery("SELECT c FROM Busca c", Busca.class).getResultList();
        return buscas;
    }

    @Override
    public Busca readById(long id) {
        Busca busca = em.find(Busca.class, id);
        return busca;
    }

    @Override
    public void delete(Busca e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
