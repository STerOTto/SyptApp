package com.example.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * NcPointinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class NcPointinfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pointId;
	private String ptNameCn;
	private String ptNameEn;
	private String orgKind;
	private String orgPostcode;
	private String orgAddress;
	private String trafficDirect;
	private String consultTel;
	private String orgFax;
	private String apName;
	private String auditingOrNot;
	private String memo;
	private String areacode;
	private String lmName;
	private String lmIdcard;
	private String lmTel;
	private String lmFax;
	private String lmAddress;
	private String lmPostcode;
	private String auditingBegin;
	private String auditingEnd;
	private String lmEmail;
	private String area;
	private String city;
	private String qdbFlag;
	private String regTime;
	private String pointPubKey;
	private Set ncStdexams = new HashSet(0);
	private Set ncWorkers = new HashSet(0);
	private Set workers = new HashSet(0);

	// Constructors

	/** default constructor */
	public NcPointinfo() {
	}

	/** minimal constructor */
	public NcPointinfo(String ptNameCn, String orgKind, String orgPostcode,
			String apName) {
		this.ptNameCn = ptNameCn;
		this.orgKind = orgKind;
		this.orgPostcode = orgPostcode;
		this.apName = apName;
	}

	/** full constructor */
	public NcPointinfo(String pointId, String ptNameCn, String ptNameEn, String orgKind,
			String orgPostcode, String orgAddress, String trafficDirect,
			String consultTel, String orgFax, String apName,
			String auditingOrNot, String memo, String areacode, String lmName,
			String lmIdcard, String lmTel, String lmFax, String lmAddress,
			String lmPostcode, String auditingBegin, String auditingEnd,
			String lmEmail, String area, String city, String qdbFlag,
			String regTime, String pointPubKey, Set ncStdexams, Set ncWorkers,
			Set workers) {
		this.pointId=pointId;
		this.ptNameCn = ptNameCn;
		this.ptNameEn = ptNameEn;
		this.orgKind = orgKind;
		this.orgPostcode = orgPostcode;
		this.orgAddress = orgAddress;
		this.trafficDirect = trafficDirect;
		this.consultTel = consultTel;
		this.orgFax = orgFax;
		this.apName = apName;
		this.auditingOrNot = auditingOrNot;
		this.memo = memo;
		this.areacode = areacode;
		this.lmName = lmName;
		this.lmIdcard = lmIdcard;
		this.lmTel = lmTel;
		this.lmFax = lmFax;
		this.lmAddress = lmAddress;
		this.lmPostcode = lmPostcode;
		this.auditingBegin = auditingBegin;
		this.auditingEnd = auditingEnd;
		this.lmEmail = lmEmail;
		this.area = area;
		this.city = city;
		this.qdbFlag = qdbFlag;
		this.regTime = regTime;
		this.pointPubKey = pointPubKey;
		this.ncStdexams = ncStdexams;
		this.ncWorkers = ncWorkers;
		this.workers = workers;
	}

	// Property accessors

	public String getPointId() {
		return this.pointId;
	}

	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	public String getPtNameCn() {
		return this.ptNameCn;
	}

	public void setPtNameCn(String ptNameCn) {
		this.ptNameCn = ptNameCn;
	}

	public String getPtNameEn() {
		return this.ptNameEn;
	}

	public void setPtNameEn(String ptNameEn) {
		this.ptNameEn = ptNameEn;
	}

	public String getOrgKind() {
		return this.orgKind;
	}

	public void setOrgKind(String orgKind) {
		this.orgKind = orgKind;
	}

	public String getOrgPostcode() {
		return this.orgPostcode;
	}

	public void setOrgPostcode(String orgPostcode) {
		this.orgPostcode = orgPostcode;
	}

	public String getOrgAddress() {
		return this.orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public String getTrafficDirect() {
		return this.trafficDirect;
	}

	public void setTrafficDirect(String trafficDirect) {
		this.trafficDirect = trafficDirect;
	}

	public String getConsultTel() {
		return this.consultTel;
	}

	public void setConsultTel(String consultTel) {
		this.consultTel = consultTel;
	}

	public String getOrgFax() {
		return this.orgFax;
	}

	public void setOrgFax(String orgFax) {
		this.orgFax = orgFax;
	}

	public String getApName() {
		return this.apName;
	}

	public void setApName(String apName) {
		this.apName = apName;
	}

	public String getAuditingOrNot() {
		return this.auditingOrNot;
	}

	public void setAuditingOrNot(String auditingOrNot) {
		this.auditingOrNot = auditingOrNot;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getLmName() {
		return this.lmName;
	}

	public void setLmName(String lmName) {
		this.lmName = lmName;
	}

	public String getLmIdcard() {
		return this.lmIdcard;
	}

	public void setLmIdcard(String lmIdcard) {
		this.lmIdcard = lmIdcard;
	}

	public String getLmTel() {
		return this.lmTel;
	}

	public void setLmTel(String lmTel) {
		this.lmTel = lmTel;
	}

	public String getLmFax() {
		return this.lmFax;
	}

	public void setLmFax(String lmFax) {
		this.lmFax = lmFax;
	}

	public String getLmAddress() {
		return this.lmAddress;
	}

	public void setLmAddress(String lmAddress) {
		this.lmAddress = lmAddress;
	}

	public String getLmPostcode() {
		return this.lmPostcode;
	}

	public void setLmPostcode(String lmPostcode) {
		this.lmPostcode = lmPostcode;
	}

	public String getAuditingBegin() {
		return this.auditingBegin;
	}

	public void setAuditingBegin(String auditingBegin) {
		this.auditingBegin = auditingBegin;
	}

	public String getAuditingEnd() {
		return this.auditingEnd;
	}

	public void setAuditingEnd(String auditingEnd) {
		this.auditingEnd = auditingEnd;
	}

	public String getLmEmail() {
		return this.lmEmail;
	}

	public void setLmEmail(String lmEmail) {
		this.lmEmail = lmEmail;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getQdbFlag() {
		return this.qdbFlag;
	}

	public void setQdbFlag(String qdbFlag) {
		this.qdbFlag = qdbFlag;
	}

	public String getRegTime() {
		return this.regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getPointPubKey() {
		return this.pointPubKey;
	}

	public void setPointPubKey(String pointPubKey) {
		this.pointPubKey = pointPubKey;
	}

	public Set getNcStdexams() {
		return this.ncStdexams;
	}

	public void setNcStdexams(Set ncStdexams) {
		this.ncStdexams = ncStdexams;
	}

	public Set getNcWorkers() {
		return this.ncWorkers;
	}

	public void setNcWorkers(Set ncWorkers) {
		this.ncWorkers = ncWorkers;
	}

	public Set getWorkers() {
		return this.workers;
	}

	public void setWorkers(Set workers) {
		this.workers = workers;
	}

}