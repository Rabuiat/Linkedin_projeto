/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.linkedin.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 41411803
 */
@Entity
@Table(name = "ESPECIALIZACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especializacao.findAll", query = "SELECT e FROM Especializacao e"),
    @NamedQuery(name = "Especializacao.findByIdEspecializacao", query = "SELECT e FROM Especializacao e WHERE e.idEspecializacao = :idEspecializacao"),
    @NamedQuery(name = "Especializacao.findByNomeEspecializacao", query = "SELECT e FROM Especializacao e WHERE e.nomeEspecializacao = :nomeEspecializacao")})
public class Especializacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESPECIALIZACAO")
    private Integer idEspecializacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOME_ESPECIALIZACAO")
    private String nomeEspecializacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEspecializacao")
    private Collection<Profissionais> profissionaisCollection;

    public Especializacao() {
    }

    public Especializacao(Integer idEspecializacao) {
        this.idEspecializacao = idEspecializacao;
    }

    public Especializacao(Integer idEspecializacao, String nomeEspecializacao) {
        this.idEspecializacao = idEspecializacao;
        this.nomeEspecializacao = nomeEspecializacao;
    }

    public Integer getIdEspecializacao() {
        return idEspecializacao;
    }

    public void setIdEspecializacao(Integer idEspecializacao) {
        this.idEspecializacao = idEspecializacao;
    }

    public String getNomeEspecializacao() {
        return nomeEspecializacao;
    }

    public void setNomeEspecializacao(String nomeEspecializacao) {
        this.nomeEspecializacao = nomeEspecializacao;
    }

    @XmlTransient
    public Collection<Profissionais> getProfissionaisCollection() {
        return profissionaisCollection;
    }

    public void setProfissionaisCollection(Collection<Profissionais> profissionaisCollection) {
        this.profissionaisCollection = profissionaisCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecializacao != null ? idEspecializacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especializacao)) {
            return false;
        }
        Especializacao other = (Especializacao) object;
        if ((this.idEspecializacao == null && other.idEspecializacao != null) || (this.idEspecializacao != null && !this.idEspecializacao.equals(other.idEspecializacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.linkedin.entities.Especializacao[ idEspecializacao=" + idEspecializacao + " ]";
    }
    
}
