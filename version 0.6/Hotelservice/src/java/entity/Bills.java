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
@Table(name = "bills")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bills.findAll", query = "SELECT b FROM Bills b"),
    @NamedQuery(name = "Bills.findByUsersLogin", query = "SELECT b FROM Bills b WHERE b.usersLogin = :usersLogin"),
    @NamedQuery(name = "Bills.findByName", query = "SELECT b FROM Bills b WHERE b.name = :name"),
    @NamedQuery(name = "Bills.findBySurname", query = "SELECT b FROM Bills b WHERE b.surname = :surname"),
    @NamedQuery(name = "Bills.findByPhone", query = "SELECT b FROM Bills b WHERE b.phone = :phone"),
    @NamedQuery(name = "Bills.findByRoomtype", query = "SELECT b FROM Bills b WHERE b.roomtype = :roomtype"),
    @NamedQuery(name = "Bills.findByNumber", query = "SELECT b FROM Bills b WHERE b.number = :number"),
    @NamedQuery(name = "Bills.findByStartdate", query = "SELECT b FROM Bills b WHERE b.startdate = :startdate"),
    @NamedQuery(name = "Bills.findByCount", query = "SELECT b FROM Bills b WHERE b.count = :count"),
    @NamedQuery(name = "Bills.findByInfo", query = "SELECT b FROM Bills b WHERE b.info = :info")})
public class Bills implements Serializable {

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
    @Size(min = 1, max = 30)
    @Column(name = "roomtype")
    private String roomtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "number")
    private String number;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "startdate")
    private String startdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "count")
    private String count;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "info")
    private String info;

    public Bills() {
    }

    public Bills(String usersLogin) {
        this.usersLogin = usersLogin;
    }

    public Bills(String usersLogin, String name, String surname, String phone, String roomtype, String number, String startdate, String count, String info) {
        this.usersLogin = usersLogin;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.roomtype = roomtype;
        this.number = number;
        this.startdate = startdate;
        this.count = count;
        this.info = info;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
        if (!(object instanceof Bills)) {
            return false;
        }
        Bills other = (Bills) object;
        if ((this.usersLogin == null && other.usersLogin != null) || (this.usersLogin != null && !this.usersLogin.equals(other.usersLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bills[ usersLogin=" + usersLogin + " ]";
    }
    
}
