package com.polymorphism.overriding;

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
}

class Child2 extends Parent{
}

public class OverridingTest{
	public static void main(String[] args) {
		Child c = new Child();//Child클래스는 hi 메소드를 오버라이딩 함
		c.hi();
		Child2 c2 = new Child2(); //오버라이딩 하지 않
		c2.hi();
	}
}