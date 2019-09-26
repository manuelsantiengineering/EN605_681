package com.msanti16.module04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.msanti16.module04.domain.Contact;
import com.msanti16.module04.domain.Destroyer;
import com.msanti16.module04.domain.Submarine;
import com.msanti16.module04.domain.P3;
import com.msanti16.module04.domain.Ship;

public class Test {

	//TODO In your test class, you should exercise your Exception handling case for the submarine 
	// by setting the number of torpedoes in one of your submarine classes to the string "Foo".
	//TODO Zip up the source code and the Java classes and a screen shot of 
	// Step 8 and post them to the Blackboard Assignments
	
	public static void main(String[] args) {
		System.out.println("EN 605.681 Principles of Enterprise Web Development");
		System.out.println("Manuel E. Santiago Laboy - Module04: Homework for Java OO Programming");
		
		P3 p301 = new P3("P301", 40, 70, 95);
		P3 p302 = new P3();
		p302.setName("P301");
		p302.setLength(30);
		p302.setSpeed(80);
		p302.setAltitude(100);
		Destroyer destroyer01 = new Destroyer("Destroyer01", 90, 20);
		Destroyer destroyer02 = new Destroyer();
		destroyer02.setName("Destroyer02");
		destroyer02.setLength(80);
		destroyer02.setSpeed(25);
		Submarine submarine01 = new Submarine("Submarine01", 70, 30);
		Submarine submarine02 = new Submarine();
		destroyer02.setName("Submarine02");
		destroyer02.setLength(60);
		destroyer02.setSpeed(35);
		
		List<Destroyer> list = new ArrayList<Destroyer>();
		list.add(destroyer01);
		list.add(destroyer02);
		
//		Set<Submarine> set = new TreeSet<Submarine>();
//		set.add(submarine01);
//		set.add(submarine02);

		
		Ship[] ships = {destroyer01, destroyer02, submarine01, submarine02};
		Contact[] contacts = {destroyer01, destroyer02, submarine01, submarine02, p301, p302};
		
		System.out.println("Assignment Instructions: ");
		System.out.println("\t1. Create 2 Destroyers");
		System.out.println("\t\t" + destroyer01);
		System.out.println("\t\t" + destroyer02);
		
		System.out.println("\t2. Create 2 Submarines");
		System.out.println("\t\t" + submarine01);
		System.out.println("\t\t" + submarine02);
		
		System.out.println("\t3. Create 2 P3s");
		System.out.println("\t\t" + p301);
		System.out.println("\t\t" + p302);
		
		System.out.println("\t4. Make a collection of Destroyers (you select the type of Collection)");
		for(int i = 0; i < list.size(); i++) {			
			System.out.println("\t\t" + list.get(i));
		}
		
		System.out.println("\t5. Make a collection of Submarines (you select the type)");		
//		Iterator<Submarine> iter = set.iterator();
//		while(iter.hasNext()) {			
//			System.out.println("\t" + iter.next());
//		}
		
		System.out.println("\t6. Make a collection that holds all Ships");	
		for(int i = 0; i < ships.length; i++) {			
			System.out.println("\t\t" + ships[i]);
		}
		
		System.out.println("\t7. Make a collection that holds all Contacts");	
		for(int i = 0; i < contacts.length; i++) {			
			System.out.println("\t\t" + contacts[i]);
		}
		
		System.out.println("\t8. Extras - Does ");
		System.out.println("\t\t" + destroyer02);
		System.out.println("\t\tEquals \n\t\t" + ships[0]);
		System.out.println("\t\tResult: " + destroyer02.equals(ships[0]));
		
		System.out.println("\t9. Extras - Does ");
		System.out.println("\t\t" + destroyer01);
		System.out.println("\t\tEquals \n\t\t" + ships[0]);
		System.out.println("\t\tResult: " + destroyer01.equals(ships[0]));
		
		System.out.println("\t10. Extras - Does ");
		System.out.println("\t\t" + submarine01);
		System.out.println("\t\tEquals \n\t\t" + contacts[2]);
		System.out.println("\t\tResult: " + submarine01.equals(contacts[2]));
		
		System.out.println("\t11. Extras - Does ");
		System.out.println("\t\t" + p301);
		System.out.println("\t\tEquals \n\t\t" + contacts[4]);
		System.out.println("\t\tResult: " + p301.equals(contacts[4]));
		
		System.out.println("\t11. Extras - Does ");
		System.out.println("\t\t" + p301);
		System.out.println("\t\tEquals \n\t\t" + contacts[5]);
		System.out.println("\t\tResult: " + p301.equals(contacts[5]));
		
		System.out.println("\t12. Exception Handling - Set numberOfTorpedos = \"Foo\" ");
		submarine01.setNumberOfTorpedos("Foo");
		System.out.println("\t\t" + submarine01);
		
		
	}

}
