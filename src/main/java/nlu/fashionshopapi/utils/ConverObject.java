package nlu.fashionshopapi.utils;

import nlu.fashionshopapi.model.entity.Product;
import nlu.fashionshopapi.payload.response.ProductResponse;

public class ConverObject {
	public static ProductResponse convertTo(Product product) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setId(product.getId());
		productResponse.setDescription(product.getDescription());
		productResponse.setImages(product.getImages());
		productResponse.setPrice(product.getPrice());
		productResponse.setName(product.getName());
		productResponse.setNameCategory(product.getCategory().getName());
		return productResponse;
	}
}
