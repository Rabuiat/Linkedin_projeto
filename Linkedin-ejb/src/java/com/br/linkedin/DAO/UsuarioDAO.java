/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.linkedin.DAO;

import com.br.linkedin.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author 41411803
 */
@Stateless
public class UsuarioDAO implements GenericDAO<Usuario>{
    
    private EntityManager em;

    @Override
    public void persist(Usuario e) {
        em.persist(e);
    }

    @Override
    public List<Usuario> read() {
        List<Usuario> usuarios = em.createQuery("SELECT c FROM Usuario c", Usuario.class).getResultList();
        return usuarios;
    }

    @Override
    public Usuario readById(long id) {
        Usuario usuario = em.find(Usuario.class,id );
        return usuario;
    }

    @Override
    public void delete(Usuario e) {
        em.remove(e);
    }

    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
}
