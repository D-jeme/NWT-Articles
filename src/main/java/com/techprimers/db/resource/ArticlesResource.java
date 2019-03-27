package com.techprimers.db.resource;

import com.techprimers.db.model.Articles;
import com.techprimers.db.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/articles")
public class ArticlesResource {

    @Autowired
    ArticlesRepository articlesRepository;

    @GetMapping(value = "/all")
    public List<Articles> getAll() {
        return articlesRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Articles> persist(@RequestBody final Articles articles) {
        articlesRepository.save(articles);
        return articlesRepository.findAll();
    }

}
