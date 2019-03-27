package com.techprimers.db.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;

@Entity
public class Articles {

    @Id
    @GeneratedValue
    @Column(name = "id_proizvoda")
    private String id_proizvoda;
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "kratki_tekst")
    private String kratki_tekst;
    @Column(name="dugi_tekst")
    private String dugi_tekst;
    @Column(name = "cijena")
    private Integer cijena;
    @Column(name = "aktivan")
    private boolean aktivan;
    @Column(name = "kolicina")
    private Integer kolicina;

    @OneToOne(mappedBy = "articles", cascade = CascadeType.ALL)
    private PictureOfArticle pictureOfArticle;


    @Column (name ="popust")
    private Integer popust;


    public Articles() {
    }

    public String getId_proizvoda() {
        return id_proizvoda;
    }

    public void setId_proizvoda(String id_proizvoda) {
        this.id_proizvoda = id_proizvoda;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKratki_tekst() {
        return kratki_tekst;
    }

    public void setKratki_tekst(String kratki_tekst) {
        this.kratki_tekst = kratki_tekst;
    }

    public String getDugi_tekst() {
        return dugi_tekst;
    }

    public void setDugi_tekst(String dugi_tekst) {
        this.dugi_tekst = dugi_tekst;
    }

    public Integer getCijena() {
        return cijena;
    }

    public void setCijena(Integer cijena) {
        this.cijena = cijena;
    }

    public Boolean getAktivan(){ return aktivan;}

    public void setAktivan(Boolean aktivan){ this.aktivan=aktivan;}

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }


    public Integer getPopust() {
        return popust;
    }

    public void setPopust(Integer popust) {
        this.popust = popust;
    }

}
