/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1
 */
@Entity
@Table(name = "hotelrooms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotelrooms.findAll", query = "SELECT h FROM Hotelrooms h"),
    @NamedQuery(name = "Hotelrooms.findById", query = "SELECT h FROM Hotelrooms h WHERE h.id = :id"),
    @NamedQuery(name = "Hotelrooms.findByType", query = "SELECT h FROM Hotelrooms h WHERE h.type = :type"),
    @NamedQuery(name = "Hotelrooms.findByNumber", query = "SELECT h FROM Hotelrooms h WHERE h.number = :number"),
    @NamedQuery(name = "Hotelrooms.findByEnddate", query = "SELECT h FROM Hotelrooms h WHERE h.enddate = :enddate")})
public class Hotelrooms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "number")
    private int number;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Lob
    @Size(max = 65535)
    @Column(name = "rdesc")
    private String rdesc;

    public Hotelrooms() {
    }

    public Hotelrooms(Integer id) {
        this.id = id;
    }

    public Hotelrooms(Integer id, String type, int number, Date enddate) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.enddate = enddate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotelrooms)) {
            return false;
        }
        Hotelrooms other = (Hotelrooms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Hotelrooms[ id=" + id + " ]";
    }
    
}
