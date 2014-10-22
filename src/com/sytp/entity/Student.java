package com.sytp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Student implements java.io.Serializable {

	// Fields

	private String studentId;
	private CourseCollege courseCollege;
	private String name;
	private String password;
	private String email;
	private String nccollegename;
	private String mobile;
	private String address;
	private String postcode;
	private String age;
	private String ncclassname;
	private String familyProvince;
	private String sex;
	private Integer loginCount;
	private String lastLoginTime;
	private String image;
	private String certName;
	private String certId;
	private String education;
	private String telH;
	private String company;
	private String position;
	private String telO;
	private String certSoFar;
	private String regTime;
	private String regTime1;
	private String examRegState;
	private String memo;
	private String isNcne;
	@SuppressWarnings("rawtypes")
	private Set examRandPapers = new HashSet(0);
	@SuppressWarnings("rawtypes")
	private Set studentTests = new HashSet(0);
	@SuppressWarnings("rawtypes")
	private Set noticeReads = new HashSet(0);
	@SuppressWarnings("rawtypes")
	private Set studentCourses = new HashSet(0);
	@SuppressWarnings("rawtypes")
	private Set studentExams = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String name, String password) {
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	@SuppressWarnings("rawtypes")
	public Student(CourseCollege courseCollege, String name, String password,
			String email, String nccollegeName, String mobile, String address,
			String postcode, String age, String ncclassName,
			String familyProvince, String sex, Integer loginCount,
			String lastLoginTime, String image, String certName, String certId,
			String education, String telH, String company, String position,
			String telO, String certSoFar, String regTime, String regTime1,
			String examRegState, String memo, String isNcne,
			Set examRandPapers, Set studentTests, Set noticeReads,
			Set studentCourses, Set studentExams) {
		this.courseCollege = courseCollege;
		this.name = name;
		this.password = password;
		this.email = email;
		this.nccollegename = nccollegeName;
		this.mobile = mobile;
		this.address = address;
		this.postcode = postcode;
		this.age = age;
		this.ncclassname = ncclassName;
		this.familyProvince = familyProvince;
		this.sex = sex;
		this.loginCount = loginCount;
		this.lastLoginTime = lastLoginTime;
		this.image = image;
		this.certName = certName;
		this.certId = certId;
		this.education = education;
		this.telH = telH;
		this.company = company;
		this.position = position;
		this.telO = telO;
		this.certSoFar = certSoFar;
		this.regTime = regTime;
		this.regTime1 = regTime1;
		this.examRegState = examRegState;
		this.memo = memo;
		this.isNcne = isNcne;
		this.examRandPapers = examRandPapers;
		this.studentTests = studentTests;
		this.noticeReads = noticeReads;
		this.studentCourses = studentCourses;
		this.studentExams = studentExams;
	}

	// Property accessors

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}


	public String getFamilyProvince() {
		return this.familyProvince;
	}

	public void setFamilyProvince(String familyProvince) {
		this.familyProvince = familyProvince;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public String getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCertName() {
		return this.certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public String getCertId() {
		return this.certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getTelH() {
		return this.telH;
	}

	public void setTelH(String telH) {
		this.telH = telH;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTelO() {
		return this.telO;
	}

	public void setTelO(String telO) {
		this.telO = telO;
	}

	public String getCertSoFar() {
		return this.certSoFar;
	}

	public void setCertSoFar(String certSoFar) {
		this.certSoFar = certSoFar;
	}

	public String getRegTime() {
		return this.regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getRegTime1() {
		return this.regTime1;
	}

	public void setRegTime1(String regTime1) {
		this.regTime1 = regTime1;
	}

	public String getExamRegState() {
		return this.examRegState;
	}

	public void setExamRegState(String examRegState) {
		this.examRegState = examRegState;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getIsNcne() {
		return this.isNcne;
	}

	public void setIsNcne(String isNcne) {
		this.isNcne = isNcne;
	}

	@SuppressWarnings("rawtypes")
	public Set getExamRandPapers() {
		return this.examRandPapers;
	}

	@SuppressWarnings("rawtypes")
	public void setExamRandPapers(Set examRandPapers) {
		this.examRandPapers = examRandPapers;
	}

	@SuppressWarnings("rawtypes")
	public Set getStudentTests() {
		return this.studentTests;
	}

	@SuppressWarnings("rawtypes")
	public void setStudentTests(Set studentTests) {
		this.studentTests = studentTests;
	}

	@SuppressWarnings("rawtypes")
	public Set getNoticeReads() {
		return this.noticeReads;
	}

	@SuppressWarnings("rawtypes")
	public void setNoticeReads(Set noticeReads) {
		this.noticeReads = noticeReads;
	}

	@SuppressWarnings("rawtypes")
	public Set getStudentCourses() {
		return this.studentCourses;
	}

	@SuppressWarnings("rawtypes")
	public void setStudentCourses(Set studentCourses) {
		this.studentCourses = studentCourses;
	}

	@SuppressWarnings("rawtypes")
	public Set getStudentExams() {
		return this.studentExams;
	}

	@SuppressWarnings("rawtypes")
	public void setStudentExams(Set studentExams) {
		this.studentExams = studentExams;
	}

	public String getNccollegename() {
		return nccollegename;
	}

	public void setNccollegename(String nccollegename) {
		this.nccollegename = nccollegename;
	}

	public String getNcclassname() {
		return ncclassname;
	}

	public void setNcclassname(String ncclassname) {
		this.ncclassname = ncclassname;
	}

}