package com.example.entity;

public class Course implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long courseId;
	private CourseCategory courseCategory;
	private CourseCollege courseCollege;
	private String name;
	private String description;
	private String courseType;
	private String courseState;
	private String updateDate;
	private String createDate;
	private String endDate;
	private String contentId;
	private String shareable;
	// Constructors

	public String getShareable() {
		return shareable;
	}

	public void setShareable(String shareable) {
		this.shareable = shareable;
	}

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(CourseCategory courseCategory, CourseCollege courseCollege,
			String name, String description, String courseType,
			String courseState, String updateDate, String createDate,
			String endDate, String contentId){
			/*, Set queTypeCategories,
			Set moduleitems, Set testModuleItems,
			Set teacherGroups, Set courseTeachers, Set studentCourses,
			Set examModuleItems) {*/
		this.courseCategory = courseCategory;
		this.courseCollege = courseCollege;
		this.name = name;
		this.description = description;
		this.courseType = courseType;
		this.courseState = courseState;
		this.updateDate = updateDate;
		this.createDate = createDate;
		this.endDate = endDate;
		this.contentId = contentId;
		/*this.queTypeCategories = queTypeCategories;
		this.moduleitems = moduleitems;
		this.testModuleItems = testModuleItems;
		this.teacherGroups = teacherGroups;
		this.courseTeachers = courseTeachers;
		this.studentCourses = studentCourses;
		this.examModuleItems = examModuleItems;*/
	}

	// Property accessors

	public Long getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public CourseCategory getCourseCategory() {
		return this.courseCategory;
	}

	public void setCourseCategory(CourseCategory courseCategory) {
		this.courseCategory = courseCategory;
	}

	public CourseCollege getCourseCollege() {
		return this.courseCollege;
	}

	public void setCourseCollege(CourseCollege courseCollege) {
		this.courseCollege = courseCollege;
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

	public String getCourseType() {
		return this.courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCourseState() {
		return this.courseState;
	}

	public void setCourseState(String courseState) {
		this.courseState = courseState;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getContentId() {
		return this.contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
}
