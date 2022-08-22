package nlu.fashionshopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nlu.fashionshopapi.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
