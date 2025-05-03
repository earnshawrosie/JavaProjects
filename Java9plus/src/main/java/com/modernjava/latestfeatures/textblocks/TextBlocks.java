package com.modernjava.latestfeatures.textblocks;

public class TextBlocks {


    public static String multiLineString() {

        var multiLine = "This is a\n" +
                "    multiline string\n" +
                "with newlines inside";

        return  multiLine;
    }
    
    public static String multiLineStringV2() {

        var multiLine = """
        				This is a
                   			multiline string
                   				with newlines inside
                   		 """;

        return  multiLine;
    }
    
    public static String multiLineStringV3(String name) {

        var multiLine = """
        				Hello %s!
        					This is a
                   				multiline string
                   					with newlines inside
                   		 """.formatted(name);

        return  multiLine;
    }
    
    public static String sql() {

        var multiLine = """
        		Select * from employee
        		where first_name = 'Rosie'
        		and last_name = 'Earnshaw'
                """;
        
        return  multiLine;
    }

    public static String json() {

        var multiLine = """
        		{
        		"order_id" : 12346,
        		"status" : "DELIVERED,
        		"final_charge" : 99.99
                """;
        
        return  multiLine;
    }


    public static void main(String[] args) {

        System.out.println("multiLineString = " + multiLineString());
        System.out.println("multiLineStringV2 = " + multiLineStringV2());
        System.out.println("multiLineStringV3 = " + multiLineStringV3("Rosie"));
        System.out.println("sql = " + sql());
        System.out.println("json = " + json());
    }
}

