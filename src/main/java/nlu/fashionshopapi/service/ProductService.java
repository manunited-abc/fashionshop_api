package nlu.fashionshopapi.service;

import org.springframework.stereotype.Service;


import nlu.fashionshopapi.payload.response.PagedResponse;
import nlu.fashionshopapi.payload.response.ProductResponse;




@Service
public interface ProductService {
	PagedResponse<ProductResponse> getAllProducts(int page, int size);
	ProductResponse getProduct(int id);
}
