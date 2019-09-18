package com.msanti16.module04.domain;

public abstract class Ship implements Contact {	
	private int length;
	private int speed;
	private String name;
	private String type;
	
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
