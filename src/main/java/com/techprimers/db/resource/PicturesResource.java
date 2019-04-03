package com.techprimers.db.resource;

import com.techprimers.db.model.Pictures;
import com.techprimers.db.model.Users;
import com.techprimers.db.repository.PicturesRepository;
import com.techprimers.db.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static org.springframework.core.io.support.ResourcePatternUtils.isUrl;

@RestController
@RequestMapping(value = "/pictures")
public class PicturesResource {

    @Autowired
    PicturesRepository picturesRepository;

    @GetMapping(value = "/getAll")
    public List<Pictures> getAll() {
        return picturesRepository.findAll();
    }

    @GetMapping(value = "/getPicture/{id}")
    public ResponseEntity<?> getArtical(@PathVariable Integer id) {
        Pictures pictures = this.picturesRepository.findOne(id);
        if(pictures==null)return new ResponseEntity<>("Ne postoji slika sa id "+id, HttpStatus.OK);
        return new ResponseEntity<Pictures>(pictures, HttpStatus.OK);
    }
    @PostMapping(value = "/post")
    public ResponseEntity<?> persist(@RequestBody final Pictures pictures) {

        if(pictures.getSlika()==""||pictures.getSlika()==null)
            return new ResponseEntity<>("Polje slika se mora popuniti", HttpStatus.OK);

        if(!isUrl(pictures.getSlika()))return new ResponseEntity<>("Polje slika se mora biti URL", HttpStatus.OK);


        picturesRepository.save(pictures);

        return new ResponseEntity<Collection<Pictures>>(this.picturesRepository.findAll(), HttpStatus.OK);

    }

}
