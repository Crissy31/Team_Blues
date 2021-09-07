package fr.ldnr.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.ldnr.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Page<Category> findByNameContains(String name, Pageable pageable);
}