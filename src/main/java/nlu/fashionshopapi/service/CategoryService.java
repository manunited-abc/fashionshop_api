package nlu.fashionshopapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nlu.fashionshopapi.model.entity.Category;
import nlu.fashionshopapi.payload.response.PagedResponse;


@Service
public interface CategoryService {
	PagedResponse<Category> getAllCategories(int page, int size, int depth);

	Category getCategory(int id);



}
