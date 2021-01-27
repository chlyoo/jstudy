package com.polymorphism.overloading;

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

public class OverloadingTest{
	public static void main(String[] args) {
		Child c = new Child();
		c.hi(); // 파라미터가 없는 hi 메소드(오버라이딩 메소드)
		c.hi("clazitive"); //String을 파라미터로 받는 hi 메소드(오버로딩 메소드)        
	}
}