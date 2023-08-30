package com.velocity.eShopCart.service;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.velocity.eShopCart.model.ProductImages;

public interface ProductImagesService {

	public String saveImagesToDirectory(MultipartFile file) throws IOException;

	public List<String> updateImagesToDirectory(List<MultipartFile> files) throws IOException;

	public ProductImages getImageDataById(Integer imageId);

	public List<ProductImages> getAllImageData();

	public void deleteImageById(Integer imageId);

	List<String> saveMultipleImages(List<MultipartFile> files) throws IOException;
}
