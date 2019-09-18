package com.msanti16.module04.domain;

public abstract class Aircraft implements Contact {
	private int altitude;
	private int length;
	private int speed;
	private String name;
	private String type;	
	
	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	@Override
	public int getLength() { 
		return this.length;
	}

	@Override
	public void setLength(int length) {
		this.length = length;		
	}

	@Override
	public int getSpeed() {
		return this.speed;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void setSpeed(String speed) {
		
	}

	@Override
	public String getName() {		
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}	

}
