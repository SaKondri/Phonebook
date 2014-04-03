/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sakondri.model;

import com.sakondri.model.baseentity.BaseEntity;
import javafx.beans.property.SimpleStringProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author sakondri
 */     
@Entity
@Table
@NamedQueries(
        @NamedQuery(name = "Person.selectById" , query = "select p from Person p where p.loginId=:id")
)
public class Person extends BaseEntity{
     @Column(name = "FIRSTNAME")
     private String fName;
     @Column(name = "LASTNAME")
     private String lName;
     @Column(name = "EMAIL")
     private String pEmail;
     @JoinColumn(name = "loginId")
     private Long loginId;
     @Transient
      private  SimpleStringProperty fn;
      @Transient
      private  SimpleStringProperty ln;
      @Transient
      private  SimpleStringProperty em;

    public Person() {
      //  setFirstName(getfName());
       // setLastName(getlName());
       // setEmail(getpEmail());
    }
           
        public  Person(String fName, String lName, String email) {
            this.fn = new SimpleStringProperty(fName);
            this.ln = new SimpleStringProperty(lName);
            this.em = new SimpleStringProperty(email);
        }
 
        public String getFirstName() {
            return fn.get();
        }
 
        public void setFirstName(String fName) {
            fn.set(fName);
        }
 
        public String getLastName() {
            return ln.get();
        }
 
        public void setLastName(String fName) {
            ln.set(fName);
        }
 
        public String getEmail() {
            return em.get();
        }
 
        public void setEmail(String fName) {
            em.set(fName);
        }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

  
        
    }


