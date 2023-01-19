package com.Model;

public class CoursePlan {
	private int planID;
	private int batchID;
	private int dayNumber;
	private String topic;
	private String status;
	
	public CoursePlan() {
		super();
	}

	public CoursePlan(int planID, int batchID, int dayNumber, String topic, String status) {
		super();
		this.planID = planID;
		this.batchID = batchID;
		this.dayNumber = dayNumber;
		this.topic = topic;
		this.status = status;
	}

	public int getPlanID() {
		return planID;
	}

	public void setPlanID(int planID) {
		this.planID = planID;
	}

	public int getBatchID() {
		return batchID;
	}

	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}

	public int getDayNumber() {
		return dayNumber;
	}

	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
