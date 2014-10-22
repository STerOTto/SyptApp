package com.sytp.entity;
/**
 * Notice entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Notice implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long noticeId;
	private Worker worker;
	private Course course;
	private String title;
	private String content;
	private String popUp;
	private String endTime;
	private String publishTime;
	private String modifyTime;
	private String attachmentList;
	private String readStatus;
	private String contentPlainText;
	private String toKind;
	private Long count;

	// Constructors

	public String getToKind() {
		return toKind;
	}

	public void setToKind(String toKind) {
		this.toKind = toKind;
	}

	/** default constructor */
	public Notice() {
	}

	/** minimal constructor */
	public Notice(Worker worker, String title, String content,
			String publishTime) {
		this.worker = worker;
		this.title = title;
		this.content = content;
		this.publishTime = publishTime;
	}

	/** full constructor */
	public Notice(Worker worker, Course course, String title, String content,
			String popUp, String endTime, String publishTime,
			String modifyTime, String attachmentList,String contentPlainText) {
		this.worker = worker;
		this.course = course;
		this.title = title;
		this.content = content;
		this.popUp = popUp;
		this.endTime = endTime;
		this.publishTime = publishTime;
		this.modifyTime = modifyTime;
		this.attachmentList = attachmentList;
		this.contentPlainText = contentPlainText;
	}

	// Property accessors

	public Long getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPopUp() {
		return this.popUp;
	}

	public void setPopUp(String popUp) {
		this.popUp = popUp;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getAttachmentList() {
		return this.attachmentList;
	}

	public void setAttachmentList(String attachmentList) {
		this.attachmentList = attachmentList;
	}

	public String getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}

	public String getContentPlainText() {
		return contentPlainText;
	}

	public void setContentPlainText(String contentPlainText) {
		this.contentPlainText = contentPlainText;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}


}