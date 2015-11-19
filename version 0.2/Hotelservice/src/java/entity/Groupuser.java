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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1
 */
@Entity
@Table(name = "groupuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupuser.findAll", query = "SELECT g FROM Groupuser g"),
    @NamedQuery(name = "Groupuser.findByName", query = "SELECT g FROM Groupuser g WHERE g.name = :name"),
    @NamedQuery(name = "Groupuser.findByUsersLogin", query = "SELECT g FROM Groupuser g WHERE g.usersLogin = :usersLogin")})
public class Groupuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "users_login")
    private String usersLogin;
    @JoinColumn(name = "users_login", referencedColumnName = "login", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users_1 users;

    public Groupuser() {
    }

    public Groupuser(String usersLogin) {
        this.usersLogin = usersLogin;
    }

    public Groupuser(String usersLogin, String name) {
        this.usersLogin = usersLogin;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsersLogin() {
        return usersLogin;
    }

    public void setUsersLogin(String usersLogin) {
        this.usersLogin = usersLogin;
    }

    public Users_1 getUsers() {
        return users;
    }

    public void setUsers(Users_1 users) {
        this.users = users;
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
        if (!(object instanceof Groupuser)) {
            return false;
        }
        Groupuser other = (Groupuser) object;
        if ((this.usersLogin == null && other.usersLogin != null) || (this.usersLogin != null && !this.usersLogin.equals(other.usersLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Groupuser[ usersLogin=" + usersLogin + " ]";
    }
    
}
