package com.msanti16.module04.domain;

public class Submarine extends Ship {
	private int numberofTorpedos;
	
	public Submarine() {
		super();
	}

	public int getNumberofTorpedos() {
		return numberofTorpedos;
	}

	public void setNumberofTorpedos(int numberofTorpedos) {
		this.numberofTorpedos = numberofTorpedos;
	}
	
	public void setNumberofTorpedos(String numberofTorpedos) {
		try{
			this.numberofTorpedos = Integer.parseInt(numberofTorpedos);
		}catch (NumberFormatException e){
			System.out.println("Error: unable to parse string into integer value for variable \'numberofTorpedos\'.");			
			this.numberofTorpedos = 2;
		}
	}

	@Override
	public String toString() {
		return "Submarine [numberofTorpedos=" + numberofTorpedos + "]";
	}	

	
	
}