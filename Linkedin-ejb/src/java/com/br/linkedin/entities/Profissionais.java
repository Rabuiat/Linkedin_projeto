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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PROFISSIONAIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profissionais.findAll", query = "SELECT p FROM Profissionais p"),
    @NamedQuery(name = "Profissionais.findByIdProfissional", query = "SELECT p FROM Profissionais p WHERE p.idProfissional = :idProfissional"),
    @NamedQuery(name = "Profissionais.findByLinkedin", query = "SELECT p FROM Profissionais p WHERE p.linkedin = :linkedin")})
public class Profissionais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROFISSIONAL")
    private Integer idProfissional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "LINKEDIN")
    private String linkedin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProfissional")
    private Collection<Busca> buscaCollection;
    @JoinColumn(name = "COD_ESPECIALIZACAO", referencedColumnName = "ID_ESPECIALIZACAO")
    @ManyToOne(optional = false)
    private Especializacao codEspecializacao;

    public Profissionais() {
    }

    public Profissionais(Integer idProfissional) {
        this.idProfissional = idProfissional;
    }

    public Profissionais(Integer idProfissional, String linkedin) {
        this.idProfissional = idProfissional;
        this.linkedin = linkedin;
    }

    public Integer getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(Integer idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    @XmlTransient
    public Collection<Busca> getBuscaCollection() {
        return buscaCollection;
    }

    public void setBuscaCollection(Collection<Busca> buscaCollection) {
        this.buscaCollection = buscaCollection;
    }

    public Especializacao getCodEspecializacao() {
        return codEspecializacao;
    }

    public void setCodEspecializacao(Especializacao codEspecializacao) {
        this.codEspecializacao = codEspecializacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfissional != null ? idProfissional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profissionais)) {
            return false;
        }
        Profissionais other = (Profissionais) object;
        if ((this.idProfissional == null && other.idProfissional != null) || (this.idProfissional != null && !this.idProfissional.equals(other.idProfissional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.linkedin.entities.Profissionais[ idProfissional=" + idProfissional + " ]";
    }
    
}
