package nlu.fashionshopapi.utils;

import org.springframework.http.HttpStatus;

import nlu.fashionshopapi.exception.NotFoundException;



public class AppUtils {
	public static void validatePageNumberAndSize(int page, int size) {
		if (page < 0) {
			throw new NotFoundException("Page number cannot be less than zero.");
		}

		if (size < 0) {
			throw new NotFoundException("Size number cannot be less than zero.");
		}

		if (size > AppConstants.MAX_PAGE_SIZE) {
			throw new NotFoundException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
		}
	}
}
