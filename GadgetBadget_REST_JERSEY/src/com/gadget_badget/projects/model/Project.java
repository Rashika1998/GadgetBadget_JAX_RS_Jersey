package com.gadget_badget.projects.model;

public class Project {
	
	private int projectID;
	private String projectName;
	private String projectCategory;
	private String projectDESC;
	private String projectPrice;
	private String projectDevBy;
	
	
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectCategory() {
		return projectCategory;
	}
	public void setProjectCategory(String projectCategory) {
		this.projectCategory = projectCategory;
	}
	public String getProjectDESC() {
		return projectDESC;
	}
	public void setProjectDESC(String projectDESC) {
		this.projectDESC = projectDESC;
	}
	public String getProjectPrice() {
		return projectPrice;
	}
	public void setProjectPrice(String projectPrice) {
		this.projectPrice = projectPrice;
	}
	public String getProjectDevBy() {
		return projectDevBy;
	}
	public void setProjectDevBy(String projectDevBy) {
		this.projectDevBy = projectDevBy;
	}
	
	@Override
	public String toString() {
		return "Project [projectID=" + projectID + ", projectName=" + projectName + ", projectCategory="
				+ projectCategory + ", projectDESC=" + projectDESC + ", projectPrice=" + projectPrice
				+ ", projectDevBy=" + projectDevBy + "]";
	}
	
	
	
}
