package com.velocity.eShopCart.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "categoryname")
	private String categoryname;

	@Column(name = "description")
	private String description;

	@Column(name = "createdby")
	private String createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createddate", nullable = true)
	private Date createddate;

	@PrePersist
	private void onCreate() {
		createddate = new Date();

	}

	@Column(length = 50, nullable = true, name = "imageName")
	private String imageName;

//	@OneToMany(targetEntity = SubCategory.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "id", referencedColumnName = "id")
//	private List<SubCategory> subCategoryList;

	public Category() {

	}

//	public List<SubCategory> getSubCategoryList() {
//		return subCategoryList;
//	}
//
//	public void setSubCategoryList(List<SubCategory> subCategoryList) {
//		this.subCategoryList = subCategoryList;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Category(int id, String categoryname, String description, String createdBy, Date createddate,
			String imageName) {
		super();
		this.id = id;
		this.categoryname = categoryname;
		this.description = description;
		this.createdBy = createdBy;
		this.createddate = createddate;
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryname=" + categoryname + ", description=" + description + ", createdBy="
				+ createdBy + ", createddate=" + createddate + ", imageName=" + imageName + "]";
	}

}
