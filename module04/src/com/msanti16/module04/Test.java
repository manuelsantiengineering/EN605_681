package com.msanti16.module04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.msanti16.module04.domain.Contact;
import com.msanti16.module04.domain.Destroyer;
import com.msanti16.module04.domain.Submarine;
import com.msanti16.module04.domain.P3;
import com.msanti16.module04.domain.Ship;

public class Test {

	//TODO Make a collection of Destroyers (you select the type of Collection)
	//TODO Make a collection of Submarines (you select the type)
	//TODO Make a collection that holds all Ships
	//TODO Make a collection that holds all Contacts
	//TODO You get to pick the names and values for the classes above.
	//TODO Print out the list of Contacts.
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
		
		Ship[] ships = {destroyer01, destroyer02, submarine01, submarine02};
		Contact[] contacts = {destroyer01, destroyer02, submarine01, submarine02, p301, p302};
		
		List list = new ArrayList();
		list.add(destroyer01);
		list.add(destroyer02);
		
		Set set = new TreeSet();
		set.add(submarine01);
		set.add(submarine02);
		
	}

}
