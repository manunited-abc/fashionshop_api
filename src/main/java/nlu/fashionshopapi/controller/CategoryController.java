package nlu.fashionshopapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nlu.fashionshopapi.model.entity.Category;
import nlu.fashionshopapi.payload.response.PagedResponse;
import nlu.fashionshopapi.service.CategoryService;
import nlu.fashionshopapi.utils.AppConstants;


@RestController
@RequestMapping(value="api/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@GetMapping
	public ResponseEntity<?> getAllCategories(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size,
			@RequestParam(name = "depth", required = false, defaultValue = "0") int depth) {
		PagedResponse<Category> categories = categoryService.getAllCategories(page, size,depth);
		return ResponseEntity.ok(categories);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategory(@PathVariable(name = "id") int id) {
		return ResponseEntity.ok(categoryService.getCategory(id));
	}
}
