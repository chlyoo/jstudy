package com.polymorphism;

class Parent{

	String firstname = "Lyoo";

	void hi(){
		System.out.println("Parent: Hi");
	}
}

class Child extends Parent{

	void hi(){ //오버라이딩
		System.out.println("Child: Hi");
	}

	void hi(String who){ //오버로딩
		System.out.println("Child: Hi "+who);
	}

	void amChild(){
		System.out.println("I am child");
	}
}

class GrandChild extends Child{

	void hi(){
		System.out.println("GrandChild: Hi");
	}
}