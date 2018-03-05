package com.eric.spring.model;

public class BasicModel {

	private Long pid;
	private String userName;
	private String avatarFileId;
	private String coverFileId;
	private String introduction;
	private String personalUri;
	private String avatarUrl;
	private String coverUrl;
	private Long createDate;
	private Long updateDate;
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAvatarFileId() {
		return avatarFileId;
	}
	public void setAvatarFileId(String avatarFileId) {
		this.avatarFileId = avatarFileId;
	}
	public String getCoverFileId() {
		return coverFileId;
	}
	public void setCoverFileId(String coverFileId) {
		this.coverFileId = coverFileId;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getPersonalUri() {
		return personalUri;
	}
	public void setPersonalUri(String personalUri) {
		this.personalUri = personalUri;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getCoverUrl() {
		return coverUrl;
	}
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	public Long getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}
	public Long getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Long updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
