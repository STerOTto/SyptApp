package com.example.entity;

/**
 * CourseCollege entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class CourseCollege implements java.io.Serializable {

	// Fields

	private Long collegeId;
	private String name;
	private String description;

	// Constructors

	/** default constructor */
	public CourseCollege() {
	}

	/** full constructor */
	public CourseCollege(String name, String description) {
		this.name = name;
		this.description = description;
		
	}

	// Property accessors

	public Long getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(Long collegeId) {
		this.collegeId = collegeId;
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