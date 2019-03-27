package com.techprimers.db.resource;

import com.techprimers.db.model.PictureOfArticle;
import com.techprimers.db.repository.PictureOfArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pictures")
public class PictureOfArticleResource {

    @Autowired
    PictureOfArticleRepository pictureOfArticleRepository;

    @GetMapping(value = "/all")
    public List<PictureOfArticle> getAll() {
        return pictureOfArticleRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<PictureOfArticle> persist(@RequestBody final PictureOfArticle articles) {
        pictureOfArticleRepository.save(articles);
        return pictureOfArticleRepository.findAll();
    }

}
