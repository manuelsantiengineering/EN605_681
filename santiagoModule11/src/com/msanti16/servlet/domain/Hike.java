package com.msanti16.servlet.domain;

import java.io.Serializable;

import com.msanti16.servlet.constants.DBConnectionConstants;

@SuppressWarnings("serial")
public class Hike implements Serializable {
	private int 		id;
	private String 		name;
	private int[]		durations;
	private double		costPerDay;
	private double		costPerPremiumDay;
	private String		level;
	
	public Hike() {
		super();
	}
	
	public Hike(int id) {
		super();
		this.id = id;
		initHike();
	}

	public void initHike() {
		switch(this.id) {
		case 0:
			this.name = DBConnectionConstants.TOURS[0];
			this.durations = DBConnectionConstants.DURATION_GARDINER_LAKE;
			this.costPerDay = DBConnectionConstants.PRICE_GARDINER_LAKE;
			this.costPerPremiumDay = DBConnectionConstants.PREMIUM_GARDINER_LAKE;
			this.level = DBConnectionConstants.LEVEL_GARDINER_LAKE;
			break;
		case 1:
			this.name = DBConnectionConstants.TOURS[1];
			this.durations = DBConnectionConstants.DURATION_HELLROARING_PLATEAU;
			this.costPerDay = DBConnectionConstants.PRICE_HELLROARING_PLATEAU;
			this.costPerPremiumDay = DBConnectionConstants.PREMIUM_HELLROARING_PLATEAU;
			this.level = DBConnectionConstants.LEVEL_HELLROARING_PLATEAU;
			break;
		case 2:
			this.name = DBConnectionConstants.TOURS[2];
			this.durations = DBConnectionConstants.DURATION_BEATEN_PATH;
			this.costPerDay = DBConnectionConstants.PRICE_BEATEN_PATH;
			this.costPerPremiumDay = DBConnectionConstants.PREMIUM_BEATEN_PATH;
			this.level = DBConnectionConstants.LEVEL_BEATEN_PATH;
			break;
		}
	}
	
	public void initHike(int id) {
		this.id = id;
		
		switch(this.id) {
		case 0:
			this.name = DBConnectionConstants.TOURS[0];
			this.durations = DBConnectionConstants.DURATION_GARDINER_LAKE;
			this.costPerDay = DBConnectionConstants.PRICE_GARDINER_LAKE;
			this.costPerPremiumDay = DBConnectionConstants.PREMIUM_GARDINER_LAKE;
			this.level = DBConnectionConstants.LEVEL_GARDINER_LAKE;
			break;
		case 1:
			this.name = DBConnectionConstants.TOURS[1];
			this.durations = DBConnectionConstants.DURATION_HELLROARING_PLATEAU;
			this.costPerDay = DBConnectionConstants.PRICE_HELLROARING_PLATEAU;
			this.costPerPremiumDay = DBConnectionConstants.PREMIUM_HELLROARING_PLATEAU;
			this.level = DBConnectionConstants.LEVEL_HELLROARING_PLATEAU;
			break;
		case 2:
			this.name = DBConnectionConstants.TOURS[2];
			this.durations = DBConnectionConstants.DURATION_BEATEN_PATH;
			this.costPerDay = DBConnectionConstants.PRICE_BEATEN_PATH;
			this.costPerPremiumDay = DBConnectionConstants.PREMIUM_BEATEN_PATH;
			this.level = DBConnectionConstants.LEVEL_BEATEN_PATH;
			break;
		}
	}	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getDurations() {
		return durations;
	}

	public void setDurations(int[] durations) {
		this.durations = durations;
	}

	public double getCostPerDay() {
		return costPerDay;
	}

	public void setCostPerDay(double costPerDay) {
		this.costPerDay = costPerDay;
	}

	public double getCostPerPremiumDay() {
		return costPerPremiumDay;
	}

	public void setCostPerPremiumDay(double costPerPremiumDay) {
		this.costPerPremiumDay = costPerPremiumDay;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
		
}
