package com.velocity.eShopCart.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductImages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imageId;

	private List<String> imagePath;

	@ManyToOne(targetEntity = Product.class)
	private Product productId;

	private boolean defaultImageFlag;

	public ProductImages() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductImages(int imageId, List<String> imagePath, Product productId, boolean defaultImageFlag) {
		super();
		this.imageId = imageId;
		this.imagePath = imagePath;
		this.productId = productId;
		this.defaultImageFlag = defaultImageFlag;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public List<String> getImagePath() {
		return imagePath;
	}

	public void setImagePath(List<String> imagePath) {
		this.imagePath = imagePath;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public boolean isDefaultImageFlag() {
		return defaultImageFlag;
	}

	public void setDefaultImageFlag(boolean defaultImageFlag) {
		this.defaultImageFlag = defaultImageFlag;
	}

	@Override
	public String toString() {
		return "ProductImages [imageId=" + imageId + ", imagePath=" + imagePath + ", productId=" + productId
				+ ", defaultImageFlag=" + defaultImageFlag + "]";
	}

}
