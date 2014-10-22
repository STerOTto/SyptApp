package com.sytp.entity;

import java.util.ArrayList;
import java.util.List;

public class UserControl implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String  userId;
	private String password;
	private String message;
	private Long courseTeacherId;
	private Long studentCourseId;
	private int type;
	private Long flag;
	private List<CourseTeacher> ct = new ArrayList<CourseTeacher>();
	private List<StudentCourse> sc = new ArrayList<StudentCourse>();
	private List<CourseTeacher> demo=new ArrayList<CourseTeacher>();
	
	public UserControl() {
		super();
		//this.message="5";
	}
	
	public Long getFlag() {
		return flag;
	}

	public void setFlag(Long flag) {
		this.flag = flag;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getCourseTeacherId() {
		return courseTeacherId;
	}
	public void setCourseTeacherId(Long courseTeacherId) {
		this.courseTeacherId = courseTeacherId;
	}
	public Long getStudentCourseId() {
		return studentCourseId;
	}
	public void setStudentCourseId(Long studentCourseId) {
		this.studentCourseId = studentCourseId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<CourseTeacher> getCt() {
		return ct;
	}
	public void setCt(List<CourseTeacher> ct) {
		this.ct = ct;
	}
	public List<StudentCourse> getSc() {
		return sc;
	}
	public void setSc(List<StudentCourse> sc) {
		this.sc = sc;
	}
	public List<CourseTeacher> getDemo() {
		return demo;
	}
	public void setDemo(List<CourseTeacher> demo) {
		this.demo = demo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
