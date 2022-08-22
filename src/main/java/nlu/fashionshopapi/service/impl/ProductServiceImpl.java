package nlu.fashionshopapi.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import nlu.fashionshopapi.exception.NotFoundException;
import nlu.fashionshopapi.model.entity.Product;
import nlu.fashionshopapi.payload.response.PagedResponse;
import nlu.fashionshopapi.payload.response.ProductResponse;
import nlu.fashionshopapi.repository.ProductRespository;
import nlu.fashionshopapi.service.ProductService;
import nlu.fashionshopapi.utils.AppUtils;
import nlu.fashionshopapi.utils.ConverObject;

@Component
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRespository productRespository;
	@Override
	public PagedResponse<ProductResponse> getAllProducts(int page, int size) {
		AppUtils.validatePageNumberAndSize(page, size);

		Pageable pageable = PageRequest.of(page, size);

		Page<Product> products = productRespository.findAll(pageable);
		List<ProductResponse> productResponses = new ArrayList<ProductResponse>();
		products.getContent().forEach(product ->{
			productResponses.add(ConverObject.convertTo(product));
		});
		List<ProductResponse> content = products.getNumberOfElements() == 0 ? Collections.emptyList()
				: productResponses;

		return new PagedResponse<>(content, products.getNumber(), products.getSize(), products.getTotalElements(),
				products.getTotalPages(), products.isLast());
	}

	@Override
	public ProductResponse getProduct(int id) {
		Product product = productRespository.findById(id).orElseThrow(()-> new NotFoundException("Not found product by id: "+id));	
		return ConverObject.convertTo(product); 
	}

}
