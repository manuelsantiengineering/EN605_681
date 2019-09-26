package com.msanti16.module04.domain;

public abstract class Ship implements Contact {	
	private int length = 0;
	private int speed = 0;
	private String name = "";
	private String type = "";
	
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
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Ship ship = (Ship) obj;
		if (this.getName() == ship.getName() 
				&& this.getLength() == ship.getLength() 
				&& this.getSpeed() == ship.getSpeed() 
				&& this.getType() == ship.getType()) {
			return true;
		}else {
			return false;
		}
	}	
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder
			.append("[Class: Ship, type: ").append(this.getType())
			.append(", speed: ").append(this.getSpeed())
			.append(", length: ").append(this.getLength())
			.append(", name: ").append(this.getName())
			.append(" ]");
		return strBuilder.toString();
	}	
	
}
