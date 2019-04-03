package com.techprimers.db.resource;

import com.techprimers.db.model.Articles;
import com.techprimers.db.model.Users;
import com.techprimers.db.repository.ArticlesRepository;
import com.techprimers.db.repository.UsersRepository;
import com.techprimers.db.services.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import com.techprimers.db.exceptions.NotFoundException;
import java.util.Collection;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static jdk.nashorn.internal.objects.Global.undefined;
import static org.springframework.jdbc.support.JdbcUtils.isNumeric;


@RestController
@RequestMapping(value = "/articles")
public class ArticlesResource {

    @Autowired
    ArticlesRepository articlesRepository;
    ArticlesService articlesService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAll() {
        Collection<Articles> articles = this.articlesRepository.findAll();
        if(articles.isEmpty())
        {
            return new ResponseEntity<>("Nema artikala u bazi", HttpStatus.OK);
        }
        return new ResponseEntity<Collection<Articles>>(articles, HttpStatus.OK);
    }

    @GetMapping(value = "/getArticle/{id}")
    public ResponseEntity<?> getArtical(@PathVariable Integer id) {
        Articles article = this.articlesRepository.findOne(id);
        if(article==null)return new ResponseEntity<>("Ne postoji artikal sa id "+id, HttpStatus.OK);
        return new ResponseEntity<Articles>(article, HttpStatus.OK);
    }


    @PostMapping(value = "/post")
    public ResponseEntity<?> persist(@RequestBody final Articles articles) {
        Articles artikal=articlesRepository.findByNaziv(articles.getNaziv());
        if(artikal!=null)
            return new ResponseEntity<>("Vec postoji artikal sa nazivom "+articles.getNaziv(), HttpStatus.OK);

        if(articles.getCijena()==0) {
            return new ResponseEntity<>("Polje cijena mora biti vece do nule", HttpStatus.OK);
        }
        if(articles.getAktivan()==null)
            return new ResponseEntity<>("Polje aktivan mora biti popunjeno sa tru ili false", HttpStatus.OK);
        if(articles.getDugi_tekst()=="")
            return new ResponseEntity<>("Polje dugi_tekst mora biti popunjeno", HttpStatus.OK);
        if(articles.getKratki_tekst()=="")
            return new ResponseEntity<>("Polje kratki_tekst mora biti popunjeno", HttpStatus.OK);
        if(articles.getNaziv()=="")
            return new ResponseEntity<>("Polje naziv mora biti popunjeno", HttpStatus.OK);

        articlesRepository.save(articles);
        return new ResponseEntity<Collection<Articles>>(this.articlesRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Integer id){
        Articles article=articlesRepository.findOne(id);
        if(article==null)return new ResponseEntity<>("Ne postoji artikal u bazi sa id "+id, HttpStatus.OK);

        articlesRepository.delete(article);
         return new ResponseEntity<>("Uspjesno obrisan artikal "+id, HttpStatus.OK);
    }
    @PutMapping("/updateAktivan/{id}")
    public ResponseEntity<?>  izmijeniAktivan(@PathVariable Integer id,@RequestBody final Articles articles){
        Articles article=articlesRepository.findOne(id);
        if(article==null)return new ResponseEntity<>("Ne postoji artikal u bazi sa id "+id, HttpStatus.OK);
        article.setAktivan(articles.getAktivan());
        return new ResponseEntity<Articles>(articlesRepository.save(article), HttpStatus.OK);

    }

    @PutMapping("/updateCijena/{id}")
    public ResponseEntity<?>  izmijeniCijena(@PathVariable Integer id,@RequestBody final Articles articles){
        if(articles.getCijena()==null)
            return new ResponseEntity<>("Mora postojati poslje cijena", HttpStatus.OK);
        if(articles.getCijena()==0)
            return new ResponseEntity<>("Cijena mora biti veci", HttpStatus.OK);

        Articles article=articlesRepository.findOne(id);
        if(article==null)return new ResponseEntity<>("Ne postoji artikal u bazi sa id "+id, HttpStatus.OK);
        article.setCijena(articles.getCijena());
        return new ResponseEntity<Articles>(articlesRepository.save(article), HttpStatus.OK);
    }

    @PutMapping("/updatePopust/{id}")
    public ResponseEntity<?> izmijeniPopust(@PathVariable Integer id,@RequestBody final Articles articles){
        Articles article=articlesRepository.findOne(id);
        if(article==null)return new ResponseEntity<>("Ne postoji artikal u bazi sa id "+id, HttpStatus.OK);
        article.setPopust(articles.getPopust());
        return new ResponseEntity<Articles>(articlesRepository.save(article), HttpStatus.OK);
    }

    @PutMapping("/updateKolicina/{id}")
    public ResponseEntity<?> izmijeniKolicina (@PathVariable Integer id,@RequestBody final Articles articles){
        Articles article=articlesRepository.findOne(id);
        if(article==null)return new ResponseEntity<>("Ne postoji artikal u bazi sa id "+id, HttpStatus.OK);
        article.setKolicina(articles.getKolicina());

        return new ResponseEntity<Articles>(articlesRepository.save(article), HttpStatus.OK);
    }

}
