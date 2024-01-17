package com.model;


public class Training {
	
	private String  TrainingId;
	private String TrainingName;
	private String TrainingDescription;
	
	
	public Training() {}
	
	public Training(String trainingId, String trainingName, String trainingDescription) {
		
		TrainingId = trainingId;
		TrainingName = trainingName;
		TrainingDescription = trainingDescription;
	}

	public String getTrainingId() {
		return TrainingId;
	}

	public void setTrainingId(String trainingId) {
		TrainingId = trainingId;
	}

	public String getTrainingName() {
		return TrainingName;
	}

	public void setTrainingName(String trainingName) {
		TrainingName = trainingName;
	}

	public String getTrainingDescription() {
		return TrainingDescription;
	}

	public void setTrainingDescription(String trainingDescription) {
		TrainingDescription = trainingDescription;
	}

	}
