package com.msanti16.servlet.constants;

public interface ReservationConstants {
    /* Tour Names  */
    final String[] 	TOURS                            	= {"Gardiner Lake", "Hellroaring Plateau", "The Beaten Path"};

    /* Duration Constants  */
    final int[]   	DURATION_GARDINER_LAKE 						= {3, 5};
    final int[]   	DURATION_HELLROARING_PLATEAU  		= {2, 3, 4};
    final int[]   	DURATION_BEATEN_PATH             	= {5, 7};
    
    /* Price per day Constants  */
    final double	PRICE_GARDINER_LAKE 								= 40.00;
    final double	PRICE_HELLROARING_PLATEAU						= 35.00;
    final double	PRICE_BEATEN_PATH										= 45.00;
    
    /* Price per premium days Constants  */
    final double	PREMIUM_GARDINER_LAKE 							= 60.00;
    final double	PREMIUM_HELLROARING_PLATEAU					= 52.50;
    final double	PREMIUM_BEATEN_PATH									= 67.50;
    
    /* Level Constants  */
    final String	LEVEL_GARDINER_LAKE 								= "Intermediate";
    final String	LEVEL_HELLROARING_PLATEAU						= "Easy";
    final String	LEVEL_BEATEN_PATH										= "Difficult";
}
