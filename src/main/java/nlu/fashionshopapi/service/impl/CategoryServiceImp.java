package nlu.fashionshopapi.service.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import nlu.fashionshopapi.exception.NotFoundException;
import nlu.fashionshopapi.model.entity.Category;
import nlu.fashionshopapi.payload.response.PagedResponse;
import nlu.fashionshopapi.repository.CategoryRepository;
import nlu.fashionshopapi.service.CategoryService;
import nlu.fashionshopapi.utils.AppUtils;

@Component
public class CategoryServiceImp implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public PagedResponse<Category> getAllCategories(int page, int size, int depth) {
		AppUtils.validatePageNumberAndSize(page, size);

		Pageable pageable = PageRequest.of(page, size);

		Page<Category> categories = categoryRepository.findAll(pageable);

		List<Category> content = categories.getNumberOfElements() == 0 ? Collections.emptyList()
				: categories.getContent();
		if (depth == 0) {
			content.forEach(category -> {
				category.setProducts(Collections.emptyList());
			});
		}
		return new PagedResponse<>(content, categories.getNumber(), categories.getSize(), categories.getTotalElements(),
				categories.getTotalPages(), categories.isLast());
	}

	@Override
	public Category getCategory(int id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Not found category by id: " + id));
		category.setProducts(Collections.emptyList());
		return category;
	}

}
