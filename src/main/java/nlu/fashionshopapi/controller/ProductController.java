package nlu.fashionshopapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nlu.fashionshopapi.model.entity.Category;
import nlu.fashionshopapi.model.entity.Product;
import nlu.fashionshopapi.payload.response.PagedResponse;
import nlu.fashionshopapi.payload.response.ProductResponse;
import nlu.fashionshopapi.service.ProductService;
import nlu.fashionshopapi.utils.AppConstants;

@RestController
@RequestMapping("api/products")
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping
	public ResponseEntity<?> getAllProducts(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size
			){
			PagedResponse<ProductResponse> products = productService.getAllProducts(page, size);
			return ResponseEntity.ok(products);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getProduct(@PathVariable(name = "id") int id) {
		return ResponseEntity.ok(productService.getProduct(id));
	}
}
