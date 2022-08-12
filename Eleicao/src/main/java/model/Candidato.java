/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
 * @author TecLab
 */
@Entity
@Table(name = "candidato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c"),
    @NamedQuery(name = "Candidato.findByIdcan", query = "SELECT c FROM Candidato c WHERE c.idcan = :idcan"),
    @NamedQuery(name = "Candidato.findByNomecan", query = "SELECT c FROM Candidato c WHERE c.nomecan = :nomecan"),
    @NamedQuery(name = "Candidato.findByChapa", query = "SELECT c FROM Candidato c WHERE c.chapa = :chapa")})
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcan")
    private Integer idcan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nomecan")
    private String nomecan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "chapa")
    private String chapa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcan")
    private Collection<Voto> votoCollection;

    public Candidato() {
    }

    public Candidato(Integer idcan) {
        this.idcan = idcan;
    }

    public Candidato(Integer idcan, String nomecan, String chapa) {
        this.idcan = idcan;
        this.nomecan = nomecan;
        this.chapa = chapa;
    }

    public Integer getIdcan() {
        return idcan;
    }

    public void setIdcan(Integer idcan) {
        this.idcan = idcan;
    }

    public String getNomecan() {
        return nomecan;
    }

    public void setNomecan(String nomecan) {
        this.nomecan = nomecan;
    }

    public String getChapa() {
        return chapa;
    }

    public void setChapa(String chapa) {
        this.chapa = chapa;
    }

    @XmlTransient
    public Collection<Voto> getVotoCollection() {
        return votoCollection;
    }

    public void setVotoCollection(Collection<Voto> votoCollection) {
        this.votoCollection = votoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcan != null ? idcan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.idcan == null && other.idcan != null) || (this.idcan != null && !this.idcan.equals(other.idcan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Candidato[ idcan=" + idcan + " ]";
    }
    
}
