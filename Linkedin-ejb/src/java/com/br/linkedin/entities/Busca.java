/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.linkedin.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 41411803
 */
@Entity
@Table(name = "BUSCA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Busca.findAll", query = "SELECT b FROM Busca b"),
    @NamedQuery(name = "Busca.findByIdBusca", query = "SELECT b FROM Busca b WHERE b.idBusca = :idBusca")})
public class Busca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_BUSCA")
    private Integer idBusca;
    @JoinColumn(name = "COD_PROFISSIONAL", referencedColumnName = "ID_PROFISSIONAL")
    @ManyToOne(optional = false)
    private Profissionais codProfissional;
    @JoinColumn(name = "COD_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private Usuario codUser;

    public Busca() {
    }

    public Busca(Integer idBusca) {
        this.idBusca = idBusca;
    }

    public Integer getIdBusca() {
        return idBusca;
    }

    public void setIdBusca(Integer idBusca) {
        this.idBusca = idBusca;
    }

    public Profissionais getCodProfissional() {
        return codProfissional;
    }

    public void setCodProfissional(Profissionais codProfissional) {
        this.codProfissional = codProfissional;
    }

    public Usuario getCodUser() {
        return codUser;
    }

    public void setCodUser(Usuario codUser) {
        this.codUser = codUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBusca != null ? idBusca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Busca)) {
            return false;
        }
        Busca other = (Busca) object;
        if ((this.idBusca == null && other.idBusca != null) || (this.idBusca != null && !this.idBusca.equals(other.idBusca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.linkedin.entities.Busca[ idBusca=" + idBusca + " ]";
    }
    
}
