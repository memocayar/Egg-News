package com.eggnews.eggnews.repository;

import com.eggnews.eggnews.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
    /*@Query("SELECT n FROM new WHERE n.title = :title")
    public NewEntity findByTitle(@Param("title") String title);*/
}
