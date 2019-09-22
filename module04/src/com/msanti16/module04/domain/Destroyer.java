package com.msanti16.module04.domain;

public class Destroyer extends Ship {
	private int numberofMissiles;
	
	public Destroyer() {
		super();
	}

	public int getNumberofMissiles() {
		return numberofMissiles;
	}

	public void setNumberofMissiles(int numberofMissiles) {
		this.numberofMissiles = numberofMissiles;
	}

	public void setNumberofMissiles(String numberofMissiles) {
		try{
			this.numberofMissiles = Integer.parseInt(numberofMissiles);
		}catch (NumberFormatException e){
			System.out.println("Error: unable to parse string into integer value for variable \'numberofMissiles\'.");
			this.numberofMissiles = 2;
		}
	}
	
	
}
