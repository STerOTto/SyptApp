package com.example.entity;

public class CourseCategory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long categoryId;
	private String name;
	private String description;
	

	// Constructors

	/** default constructor */
	public CourseCategory() {
	}

	/** full constructor */
	public CourseCategory(String name, String description
			) {
		this.name = name;
		this.description = description;
		
	}

	// Property accessors

	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
