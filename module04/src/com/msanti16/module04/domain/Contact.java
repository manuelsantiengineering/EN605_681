package com.msanti16.module04.domain;

public interface Contact {
	int getLength();
	
	void setLength (int length);
	
	int getSpeed();
	
	void setSpeed (int speed);
	
	void setSpeed(String speed);
	
	String getName();
	
	void setName (String name);
	
	String getType();
	
	void setType (String type);
	
}