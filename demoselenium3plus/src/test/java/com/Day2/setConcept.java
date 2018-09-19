package com.Day2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class setConcept {

	public static void main(String[] args) {
		// TODO Auto-generatObjecthod stub

		Set<Object> s= new HashSet<Object>();
		/*s.add("a");
		s.add("A");
		s.add("64");
		//s.add("A");
		s.add(null);*/
		
		s.add("Tom");
	s.add("Mary");
		s.add("Peter");
		s.add("Alice");
		s.add(null);
		System.out.println(s.size());
		Iterator<Object> it=s.iterator();
		while(it.hasNext()) {
		System.out.println(it.next());
	} 
	}
	

}
