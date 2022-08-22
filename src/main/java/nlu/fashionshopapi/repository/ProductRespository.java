package nlu.fashionshopapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nlu.fashionshopapi.model.entity.Product;

public interface ProductRespository extends JpaRepository<Product, Integer>{

}
