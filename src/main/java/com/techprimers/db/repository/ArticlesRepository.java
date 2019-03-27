package com.techprimers.db.repository;

import com.techprimers.db.model.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<Articles, Integer> {
}
