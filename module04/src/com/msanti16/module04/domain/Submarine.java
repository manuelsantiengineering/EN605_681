package com.msanti16.module04.domain;

public class Submarine extends Ship {
	private int numberOfTorpedos = 0;
	
	public Submarine() {
		super.setType("Submarine");
	}

	public Submarine(String name, int length, int speed) {
		super.setType("Submarine");
		super.setName(name);
		super.setLength(length);
		super.setSpeed(speed);
	}
	
	public int getNumberOfTorpedos() {
		return numberOfTorpedos;
	}

	public void setNumberOfTorpedos(int numberOfTorpedos) {
		this.numberOfTorpedos = numberOfTorpedos;
	}
	
	public void setNumberOfTorpedos(String numberOfTorpedos) {
		try{
			this.numberOfTorpedos = Integer.parseInt(numberOfTorpedos);
		}catch (NumberFormatException e){
			System.out.println("Error: unable to parse string into integer value for variable \'numberOfTorpedos\'.");			
			this.numberOfTorpedos = 2;
		}
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder(super.toString());
		strBuilder.replace(strBuilder.lastIndexOf("]"), strBuilder.length(), "");
		strBuilder.append(", numberOfTorpedos: ").append(this.getNumberOfTorpedos())
			.append(" ]\n");
		return strBuilder.toString();
	}		
	
}
