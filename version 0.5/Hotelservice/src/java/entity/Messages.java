/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1
 */
@Entity
@Table(name = "messages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m"),
    @NamedQuery(name = "Messages.findByUsersLogin", query = "SELECT m FROM Messages m WHERE m.usersLogin = :usersLogin"),
    @NamedQuery(name = "Messages.findByName", query = "SELECT m FROM Messages m WHERE m.name = :name"),
    @NamedQuery(name = "Messages.findBySurname", query = "SELECT m FROM Messages m WHERE m.surname = :surname"),
    @NamedQuery(name = "Messages.findByPhone", query = "SELECT m FROM Messages m WHERE m.phone = :phone"),
    @NamedQuery(name = "Messages.findByRoomtype", query = "SELECT m FROM Messages m WHERE m.roomtype = :roomtype"),
    @NamedQuery(name = "Messages.findBySeats", query = "SELECT m FROM Messages m WHERE m.seats = :seats"),
    @NamedQuery(name = "Messages.findByStartdate", query = "SELECT m FROM Messages m WHERE m.startdate = :startdate")})
public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "users_login")
    private String usersLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "surname")
    private String surname;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Недопустимый формат номера телефона/факса (должен иметь формат xxx-xxx-xxxx)")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "roomtype")
    private String roomtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "seats")
    private String seats;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "startdate")
    private String startdate;

    public Messages() {
    }

    public Messages(String usersLogin) {
        this.usersLogin = usersLogin;
    }

    public Messages(String usersLogin, String name, String surname, String phone, String roomtype, String seats, String startdate) {
        this.usersLogin = usersLogin;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.roomtype = roomtype;
        this.seats = seats;
        this.startdate = startdate;
    }

    public String getUsersLogin() {
        return usersLogin;
    }

    public void setUsersLogin(String usersLogin) {
        this.usersLogin = usersLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersLogin != null ? usersLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.usersLogin == null && other.usersLogin != null) || (this.usersLogin != null && !this.usersLogin.equals(other.usersLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Messages[ usersLogin=" + usersLogin + " ]";
    }
    
}
