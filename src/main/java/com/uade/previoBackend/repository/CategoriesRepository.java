package com.uade.previoBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uade.previoBackend.entity.Category;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Long> {

}
