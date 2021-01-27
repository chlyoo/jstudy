package com.polymorphism;

class TypePolymorphism{
	public static void main(String[] args) {
		Parent p1 = new Parent();
		Parent p2 = new Child();
		Parent p3 = new GrandChild();
		Child c1 = new Child();

		p1.hi();
		p2.hi();
		p3.hi();
		c1.amChild();
		//p2.amChild();//	The method amChild() is undefined for the type Parent
	}
}