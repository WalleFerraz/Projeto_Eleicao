/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TecLab
 */
@Entity
@Table(name = "voto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Voto.findAll", query = "SELECT v FROM Voto v"),
    @NamedQuery(name = "Voto.findByIdvoto", query = "SELECT v FROM Voto v WHERE v.idvoto = :idvoto"),
    @NamedQuery(name = "Voto.findByDatavoto", query = "SELECT v FROM Voto v WHERE v.datavoto = :datavoto")})
public class Voto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvoto")
    private Integer idvoto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datavoto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datavoto;
    @JoinColumn(name = "idus", referencedColumnName = "idus")
    @ManyToOne(optional = false)
    private Usuario idus;
    @JoinColumn(name = "idcan", referencedColumnName = "idcan")
    @ManyToOne(optional = false)
    private Candidato idcan;

    public Voto() {
    }

    public Voto(Integer idvoto) {
        this.idvoto = idvoto;
    }

    public Voto(Integer idvoto, Date datavoto) {
        this.idvoto = idvoto;
        this.datavoto = datavoto;
    }

    public Integer getIdvoto() {
        return idvoto;
    }

    public void setIdvoto(Integer idvoto) {
        this.idvoto = idvoto;
    }

    public Date getDatavoto() {
        return datavoto;
    }

    public void setDatavoto(Date datavoto) {
        this.datavoto = datavoto;
    }

    public Usuario getIdus() {
        return idus;
    }

    public void setIdus(Usuario idus) {
        this.idus = idus;
    }

    public Candidato getIdcan() {
        return idcan;
    }

    public void setIdcan(Candidato idcan) {
        this.idcan = idcan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvoto != null ? idvoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Voto)) {
            return false;
        }
        Voto other = (Voto) object;
        if ((this.idvoto == null && other.idvoto != null) || (this.idvoto != null && !this.idvoto.equals(other.idvoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Voto[ idvoto=" + idvoto + " ]";
    }
    
}
