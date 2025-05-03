package com.modernjava.latestfeatures.var;

import java.util.List;
import java.util.Map;

public class VarTypeExample {


    //var in the class properties are not allowed.
    //private var x = "abc";



    public static void main(String[] args) {

    	var list = List.of("adam", "dilip");
    	System.out.println("List : " + list);
    	
    	for (var name : list) {
    		System.out.println("Name : " + name);
    	}
    	
    	var map = Map.ofEntries(Map.entry("a", List.of("adam", "dilip")));
    	System.out.println("Map : " + map);
    	
    	map.forEach((s, strings) -> System.out.println("map key "  + s));
    	
    	var transformedName = transform("dilip");
    	System.out.println("Transformed name : " + transformedName);
    	
    	/**
    	 * Limitations
    	 */
    	
    	//var x = null;  NOT allowed
    	var x = "ABC";
    	///x = 5;  cannot change type
    	
    	//Can use var as a variable
    	var var = "Java";
    }

    static String transform(String name) { // var in the function argument is not allowed

        return name.toUpperCase();

    }


}
