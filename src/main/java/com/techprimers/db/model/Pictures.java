package com.techprimers.db.model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pictures {

    @Id
    @GeneratedValue
    @Column(name = "id_slike")
    private Integer id_slike;

    @URL
    @Column(name = "slika")
    private String slika;


    public Pictures() {
    }

    public Integer getId_slike() {
        return id_slike;
    }

    public void setId_slike(Integer id_slike) {
        this.id_slike = id_slike;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }
}
