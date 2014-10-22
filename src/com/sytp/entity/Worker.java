package com.sytp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Worker entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Worker implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String workerId;
	private NcPointinfo ncPointinfo;
	private String name;
	private String password;
	private String email;
	private String fixPhone;
	private String mobile;
	private String address;
	private String postcode;
	private String age;
	private String identityCardNumber;
	private String familyProvince;
	private String sex;
	private String office;
	private Integer loginCount;
	private String lastLoginTime;
	private String image;
	private String telO;
	private String telH;
	private String accessionState;
	private String memo;
	private String certId;
	private String duty;
	private String fax;
	private String isNcne;
	private Set parentmessages = new HashSet(0);
	private Set helpteachermaps = new HashSet(0);
	private Set courseAttachments = new HashSet(0);
	private Set workerRoles = new HashSet(0);
	private Set courseTeachers = new HashSet(0);
	private Set notices = new HashSet(0);
	private Set resources = new HashSet(0);
	private Set noticeReads = new HashSet(0);

	// Constructors

	/** default constructor */
	public Worker() {
	}

	/** full constructor */
	public Worker(NcPointinfo ncPointinfo, String name, String password,
			String email, String fixPhone, String mobile, String address,
			String postcode, String age, String identityCardNumber,
			String familyProvince, String sex, String office,
			Integer loginCount, String lastLoginTime, String image,
			String telO, String telH, String accessionState, String memo,
			String certId, String duty, String fax, String isNcne,
			Set parentmessages, Set helpteachermaps, Set courseAttachments,
			Set workerRoles, Set courseTeachers, Set notices, Set resources,
			Set noticeReads) {
		this.ncPointinfo = ncPointinfo;
		this.name = name;
		this.password = password;
		this.email = email;
		this.fixPhone = fixPhone;
		this.mobile = mobile;
		this.address = address;
		this.postcode = postcode;
		this.age = age;
		this.identityCardNumber = identityCardNumber;
		this.familyProvince = familyProvince;
		this.sex = sex;
		this.office = office;
		this.loginCount = loginCount;
		this.lastLoginTime = lastLoginTime;
		this.image = image;
		this.telO = telO;
		this.telH = telH;
		this.accessionState = accessionState;
		this.memo = memo;
		this.certId = certId;
		this.duty = duty;
		this.fax = fax;
		this.isNcne = isNcne;
		this.parentmessages = parentmessages;
		this.helpteachermaps = helpteachermaps;
		this.courseAttachments = courseAttachments;
		this.workerRoles = workerRoles;
		this.courseTeachers = courseTeachers;
		this.notices = notices;
		this.resources = resources;
		this.noticeReads = noticeReads;
	}

	// Property accessors

	public String getWorkerId() {
		return this.workerId;
	}

	public void setWorkerId(String workerId) {
		this.workerId = workerId;
	}

	public NcPointinfo getNcPointinfo() {
		return this.ncPointinfo;
	}

	public void setNcPointinfo(NcPointinfo ncPointinfo) {
		this.ncPointinfo = ncPointinfo;
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

	public String getFixPhone() {
		return this.fixPhone;
	}

	public void setFixPhone(String fixPhone) {
		this.fixPhone = fixPhone;
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

	public String getIdentityCardNumber() {
		return this.identityCardNumber;
	}

	public void setIdentityCardNumber(String identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
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

	public String getOffice() {
		return this.office;
	}

	public void setOffice(String office) {
		this.office = office;
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

	public String getTelO() {
		return this.telO;
	}

	public void setTelO(String telO) {
		this.telO = telO;
	}

	public String getTelH() {
		return this.telH;
	}

	public void setTelH(String telH) {
		this.telH = telH;
	}

	public String getAccessionState() {
		return this.accessionState;
	}

	public void setAccessionState(String accessionState) {
		this.accessionState = accessionState;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCertId() {
		return this.certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getIsNcne() {
		return this.isNcne;
	}

	public void setIsNcne(String isNcne) {
		this.isNcne = isNcne;
	}

	public Set getParentmessages() {
		return this.parentmessages;
	}

	public void setParentmessages(Set parentmessages) {
		this.parentmessages = parentmessages;
	}

	public Set getHelpteachermaps() {
		return this.helpteachermaps;
	}

	public void setHelpteachermaps(Set helpteachermaps) {
		this.helpteachermaps = helpteachermaps;
	}

	public Set getCourseAttachments() {
		return this.courseAttachments;
	}

	public void setCourseAttachments(Set courseAttachments) {
		this.courseAttachments = courseAttachments;
	}

	public Set getWorkerRoles() {
		return this.workerRoles;
	}

	public void setWorkerRoles(Set workerRoles) {
		this.workerRoles = workerRoles;
	}

	public Set getCourseTeachers() {
		return this.courseTeachers;
	}

	public void setCourseTeachers(Set courseTeachers) {
		this.courseTeachers = courseTeachers;
	}

	public Set getNotices() {
		return this.notices;
	}

	public void setNotices(Set notices) {
		this.notices = notices;
	}

	public Set getResources() {
		return this.resources;
	}

	public void setResources(Set resources) {
		this.resources = resources;
	}

	public Set getNoticeReads() {
		return this.noticeReads;
	}

	public void setNoticeReads(Set noticeReads) {
		this.noticeReads = noticeReads;
	}

}
