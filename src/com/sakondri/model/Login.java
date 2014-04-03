package com.sakondri.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.sakondri.model.baseentity.BaseEntity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity
@Table(name = "LOGIN")
@NamedQueries({
        @NamedQuery(name = "Login.findByUsernamePassword", query = "select l from Login l where l.usernamePassword.username = :username and l.usernamePassword.password = :password")
})
    

public class Login extends BaseEntity{
	@OneToOne(cascade = CascadeType.ALL , fetch=FetchType.EAGER)
	private User user;
	@OneToOne(cascade = CascadeType.ALL , fetch=FetchType.EAGER)
	private UsernamePassword usernamePassword;
	public User getUser() {
            return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UsernamePassword getUsernamePassword() {
            return usernamePassword;
	}
	public void setUsernamePassword(UsernamePassword usernamePassword) {
		this.usernamePassword = usernamePassword;
	}
}
