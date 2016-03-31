/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.linkedin.DAO;

import com.br.linkedin.entities.Especializacao;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author 41411803
 */
@Stateless
public class EspecializacaoDAO implements GenericDAO<Especializacao>{
    
    private EntityManager em;

    @Override
    public void persist(Especializacao e) {
        em.persist(e);
    }

    @Override
    public List<Especializacao> read() {
        List<Especializacao> especializacoes = em.createQuery("SELECT c FROM Especializacao c", Especializacao.class).getResultList();
        return especializacoes;
    }

    @Override
    public Especializacao readById(long id) {
        Especializacao especializacao = em.find(Especializacao.class, id);
        return especializacao;
    }

    @Override
    public void delete(Especializacao e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
