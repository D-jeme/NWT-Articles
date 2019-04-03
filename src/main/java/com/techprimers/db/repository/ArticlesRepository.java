package com.techprimers.db.repository;

import com.techprimers.db.model.Articles;
import com.techprimers.db.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;import java.util.Collection;


public interface ArticlesRepository extends JpaRepository<Articles, Integer> {

    Articles findByNaziv(String naziv);
}
