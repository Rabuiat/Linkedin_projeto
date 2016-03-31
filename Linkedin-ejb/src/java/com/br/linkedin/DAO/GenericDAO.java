/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.linkedin.DAO;

import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author 41411803
 */
@Local
public interface GenericDAO<E> {

    public void persist(E e);
    public List<E> read();
    public E readById(long id);
    public void delete(E e);
    public void setEm(EntityManager em);

}
