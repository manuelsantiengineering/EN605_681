package com.msanti16.module04.domain;

public abstract class Aircraft implements Contact {
	private int altitude = 0;
	private int length = 0;
	private int speed = 0;
	private String name = "";
	private String type = "";	
	
	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public int getLength() { 
		return this.length;
	}
	
	public void setLength(int length) {
		this.length = length;		
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setSpeed(String speed) {
		
	}

	public String getName() {		
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}	

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder
			.append("Class: Aircraft\tType: ").append(this.getType())
			.append("\n\t[Speed: ").append(this.getSpeed())
			.append(", length: ").append(this.getLength())
			.append(", altitude: ").append(this.getAltitude())
			.append(", name: ").append(this.getName())
			.append(" ]\n");
		return strBuilder.toString();
	}	
	
}
