package com.example.entity;


public class CourseTeacher implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long courseTeacherId;
	private Worker worker;
	private Course course;
	private String classIdAndNum;
	private Integer noCorrectTaskNum;
	private Integer noreplyPosts;
	private Integer unreadNoticeFromAdmin;
	private Integer lastestResources;
	
	//add by wqq
	private String unitedCourseTeacherIds;
	private String unitType;
	private String unitFlag;
	private String questionShareGrade;
	private String resourceShareGrade;
	private String showName;

	// Constructors

	public String getUnitedCourseTeacherIds() {
		return unitedCourseTeacherIds;
	}

	public void setUnitedCourseTeacherIds(String unitedCourseTeacherIds) {
		this.unitedCourseTeacherIds = unitedCourseTeacherIds;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public String getUnitFlag() {
		return unitFlag;
	}

	public void setUnitFlag(String unitFlag) {
		this.unitFlag = unitFlag;
	}

	public String getQuestionShareGrade() {
		return questionShareGrade;
	}

	public void setQuestionShareGrade(String questionShareGrade) {
		this.questionShareGrade = questionShareGrade;
	}

	public String getResourceShareGrade() {
		return resourceShareGrade;
	}

	public void setResourceShareGrade(String resourceShareGrade) {
		this.resourceShareGrade = resourceShareGrade;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	/** default constructor */
	public CourseTeacher() {
	}

	/** full constructor */
	public CourseTeacher(Worker worker, Course course, String classIdAndNum,
			Integer noCorrectTaskNum, Integer noreplyPosts,
			Integer unreadNoticeFromAdmin, Integer lastestResources){
			/*,
			Set teacherGroups, Set studenttasks, Set dbClasses,
			Set examModules, Set testModules, Set tasks, Set queTypeCategories,
			Set modules, Set moduleitems) {*/
		this.worker = worker;
		this.course = course;
		this.classIdAndNum = classIdAndNum;
		this.noCorrectTaskNum = noCorrectTaskNum;
		this.noreplyPosts = noreplyPosts;
		this.unreadNoticeFromAdmin = unreadNoticeFromAdmin;
		this.lastestResources = lastestResources;
		//this.teacherGroups = teacherGroups;
		/*this.studenttasks = studenttasks;
		this.dbClasses = dbClasses;
		this.examModules = examModules;
		this.testModules = testModules;
		this.tasks = tasks;
		this.queTypeCategories = queTypeCategories;
		this.modules = modules;
		this.moduleitems = moduleitems;*/
	}

	// Property accessors

	public Long getCourseTeacherId() {
		return this.courseTeacherId;
	}

	public void setCourseTeacherId(Long courseTeacherId) {
		this.courseTeacherId = courseTeacherId;
	}

	public Worker getWorker() {
		return this.worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getClassIdAndNum() {
		return this.classIdAndNum;
	}

	public void setClassIdAndNum(String classIdAndNum) {
		this.classIdAndNum = classIdAndNum;
	}

	public Integer getNoCorrectTaskNum() {
		return this.noCorrectTaskNum;
	}

	public void setNoCorrectTaskNum(Integer noCorrectTaskNum) {
		this.noCorrectTaskNum = noCorrectTaskNum;
	}

	public Integer getNoreplyPosts() {
		return this.noreplyPosts;
	}

	public void setNoreplyPosts(Integer noreplyPosts) {
		this.noreplyPosts = noreplyPosts;
	}

	public Integer getUnreadNoticeFromAdmin() {
		return this.unreadNoticeFromAdmin;
	}

	public void setUnreadNoticeFromAdmin(Integer unreadNoticeFromAdmin) {
		this.unreadNoticeFromAdmin = unreadNoticeFromAdmin;
	}

	public Integer getLastestResources() {
		return this.lastestResources;
	}

	public void setLastestResources(Integer lastestResources) {
		this.lastestResources = lastestResources;
	}

	/*public Set getTeacherGroups() {
		return this.teacherGroups;
	}

	public void setTeacherGroups(Set teacherGroups) {
		this.teacherGroups = teacherGroups;
	}

public Set getStudenttasks() {
		return this.studenttasks;
	}

	public void setStudenttasks(Set studenttasks) {
		this.studenttasks = studenttasks;
	}

	public Set getDbClasses() {
		return this.dbClasses;
	}

	public void setDbClasses(Set dbClasses) {
		this.dbClasses = dbClasses;
	}

	public Set getExamModules() {
		return this.examModules;
	}

	public void setExamModules(Set examModules) {
		this.examModules = examModules;
	}

	public Set getTestModules() {
		return this.testModules;
	}

	public void setTestModules(Set testModules) {
		this.testModules = testModules;
	}

	public Set getTasks() {
		return this.tasks;
	}

	public void setTasks(Set tasks) {
		this.tasks = tasks;
	}

	public Set getQueTypeCategories() {
		return this.queTypeCategories;
	}

	public void setQueTypeCategories(Set queTypeCategories) {
		this.queTypeCategories = queTypeCategories;
	}

	public Set getModules() {
		return this.modules;
	}

	public void setModules(Set modules) {
		this.modules = modules;
	}

	public Set getModuleitems() {
		return this.moduleitems;
	}

	public void setModuleitems(Set moduleitems) {
		this.moduleitems = moduleitems;
	}
*/
}
