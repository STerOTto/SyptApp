package com.sytp.entity;


/**
 * StudentCourse entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class StudentCourse implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long studentCourseId;
	private Student student;
	private CourseTeacher courseTeacher;
	//private Set studentClasses = new HashSet(0);

	// Constructors

	/** default constructor */
	public StudentCourse() {
	}

	/** full constructor */
	public StudentCourse(Student student, CourseTeacher courseTeacher) {
		this.student = student;
		this.courseTeacher = courseTeacher;
		//this.studentClasses = studentClasses;
	}

	// Property accessors

	public Long getStudentCourseId() {
		return this.studentCourseId;
	}

	public void setStudentCourseId(Long studentCourseId) {
		this.studentCourseId = studentCourseId;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	/*public Set getStudentClasses() {
		return this.studentClasses;
	}

	public void setStudentClasses(Set studentClasses) {
		this.studentClasses = studentClasses;
	}*/

	public CourseTeacher getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(CourseTeacher courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

}