package com.learnjavadefaults;

public class ClientMultipleInheritance implements Interface1, Interface2, Interface3 {

	public void methodA() {
		System.out.println("In Client Method A");
	}
	
	public static void main(String[] args) {
		ClientMultipleInheritance client = new ClientMultipleInheritance();
		client.methodA();  //resolves to the child implementation
		client.methodB();
		client.methodC();
		
		//1 -> class that implements the interface
		//2 -> the sub interface that extends the interface
		//3 -> parent interface

	}

}
