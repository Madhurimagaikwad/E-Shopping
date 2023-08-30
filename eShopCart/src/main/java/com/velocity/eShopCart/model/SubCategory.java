package com.velocity.eShopCart.model;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "subCategory")
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subCategoryId")
	private int subCategoryId;

	@Column(name = "subCategoryName")
	private String subCategoryName;

	@Column(name = "description")
	private String description;

	@Column(name = "createddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createddate;

	@Column(name = "createdBy")
	private String createdBy;

	@ManyToOne(targetEntity = com.velocity.eShopCart.model.Category.class, cascade = CascadeType.ALL)
	private Category category;

	public SubCategory(int subCategoryId, String subCategoryName, String description, Date createddate,
			String createdBy, Category category) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.description = description;
		this.createddate = createddate;
		this.createdBy = createdBy;
		this.category = category;
	}

	 @PrePersist
	    protected void onCreate() {
		 createddate = new Date();
	    }
	 
	public SubCategory() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getCreayedBy() {
		return createdBy;
	}

	public void setcreatedBy(String creayedBy) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		this.createdBy = authentication.getName();
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SubCategory [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", description="
				+ description + ", createddate=" + createddate + ", creayedBy=" + createdBy + ", category="
				+ category + "]";
	}

}
