package com.msanti16.module04.domain;

public class Destroyer extends Ship {
	private int numberOfMissiles = 0;
	
	public Destroyer() {
		super.setType("Destroyer");
	}
	
	public Destroyer(String name, int length, int speed) {
		super.setType("Destroyer");
		super.setName(name);
		super.setLength(length);
		super.setSpeed(speed);
	}

	public int getNumberofMissiles() {
		return numberOfMissiles;
	}

	public void setNumberOfMissiles(int numberOfMissiles) {
		this.numberOfMissiles = numberOfMissiles;
	}

	public void setNumberOfMissiles(String numberOfMissiles) {
		try{
			this.numberOfMissiles = Integer.parseInt(numberOfMissiles);
		}catch (NumberFormatException e){
			System.out.println("Error: unable to parse string into integer value for variable \'numberofMissiles\'.");
			this.numberOfMissiles = 2;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Destroyer destroyer = (Destroyer) obj;
		if (super.equals(destroyer) 
				&& this.getNumberofMissiles() == destroyer.getNumberofMissiles() ) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder(super.toString());
		strBuilder.replace(strBuilder.lastIndexOf("]"), strBuilder.length(), "");
		strBuilder.append(", numberOfMissiles: ").append(this.getNumberofMissiles())
			.append(" ]");
		return strBuilder.toString();
	}		
}
