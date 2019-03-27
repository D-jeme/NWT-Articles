package com.techprimers.db.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;

@Entity
@Table(name="picture_of_article")
public class PictureOfArticle {
    @Id
    @GeneratedValue
    @Column(name = "id_slike")
    private Integer id_slike;

    @OneToOne
    @MapsId
    private Articles articles;


    @Column(name = "slika")
    private String slika;

    public Integer getId_slike() {
        return id_slike;
    }

    /*public String getProizvod_id() {
        return proizvod_id;
    }

    public void setProizvod_id(String proizvod_id) {
        this.proizvod_id = proizvod_id;
    }
*/

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

}