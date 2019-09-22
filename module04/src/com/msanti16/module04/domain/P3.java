package com.msanti16.module04.domain;

public class P3 extends Aircraft {
	private int numberOfEngines;

	public P3() {
		super.setType("P3");
	}
	
	public P3(String name, int length, int speed, int altitude) {
		super.setType("P3");
		super.setName(name);
		super.setLength(length);
		super.setSpeed(speed);
		super.setAltitude(altitude);
	}

	public int getNumberOfEngines() {
		return numberOfEngines;
	}

	public void setNumberOfEngines(int numberOfEngines) {
		this.numberOfEngines = numberOfEngines;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		P3 p3 = (P3) obj;
		if (super.equals(p3) 
				&& this.getNumberOfEngines() == p3.getNumberOfEngines() ) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder(super.toString());
		strBuilder.replace(strBuilder.lastIndexOf("]"), strBuilder.length(), "");
		strBuilder.append(", numberOfEngines: ").append(this.getNumberOfEngines())
			.append(" ]");
		return strBuilder.toString();
	}	
	
	

}
