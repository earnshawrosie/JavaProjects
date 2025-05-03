package com.learnjavadefaults;

public class Client14 implements Interface1, Interface4 {

	public static void main(String[] args) {
		Client14 client14 = new Client14();
		client14.methodA();
	}

	@Override
	public void methodA() {
		System.out.println("In Client Method A");
	}
}
