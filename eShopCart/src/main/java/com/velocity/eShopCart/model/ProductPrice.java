package com.velocity.eShopCart.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
	@Table(name = "productprice")
	public class ProductPrice {
	//priceid, productid, regularprice, sellprice, unit-(1 ltr,2 ltr,500 g), isdeleted-boolean,
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int priceId;
		private int productid;
		private double regularPrice;
		private double sellPrice;
		private String unit;
		private boolean isDeleted;
		
		@ManyToOne(cascade = CascadeType.ALL)
//////		@JoinColumn(name = "productid")
		private Product product;
//			
		
		
		public int getPriceId() {
			return priceId;
		}
		public void setPriceId(int priceId) {
			this.priceId = priceId;
		}
		public int getProductid() {
			return productid;
		}
		public void setProductid(int productid) {
			this.productid = productid;
		}
		public double getRegularPrice() {
			return regularPrice;
		}
		public void setRegularPrice(double regularPrice) {
			this.regularPrice = regularPrice;
		}
		public double getSellPrice() {
			return sellPrice;
		}
		public void setSellPrice(double sellPrice) {
			this.sellPrice = sellPrice;
		}
		public String getUnit() {
			return unit;
		}
		public void setUnit(String unit) {
			this.unit = unit;
		}
		public boolean isDeleted() {
			return isDeleted;
		}
		public void setDeleted(boolean isDeleted) {
			this.isDeleted = isDeleted;
		}
		@Override
		public String toString() {
			return "ProductPrice [priceId=" + priceId + ", productid=" + productid + ", regularPrice=" + regularPrice
					+ ", sellPrice=" + sellPrice + ", unit=" + unit + ", isDeleted=" + isDeleted + "]";
		}
		public ProductPrice(int priceId, int productid, double regularPrice, double sellPrice, String unit,
				boolean isDeleted) {
			super();
			this.priceId = priceId;
			this.productid = productid;
			this.regularPrice = regularPrice;
			this.sellPrice = sellPrice;
			this.unit = unit;
			this.isDeleted = isDeleted;
		}
		public ProductPrice() {
			super();
			// TODO Auto-generated constructor stub
		}
		

}
	