package com.dummy;

class Simple1 {
}

class Test {
	public static void main(String args[]) {
		Simple1 s = new Simple1();

		Test t = new Test();
		t.printName(s);

		Class c2 = Test.class;
		System.out.println(c2.getName());
	}

	void printName(Object obj) {
		Class<? extends Object> c = obj.getClass();
		System.out.println(c.getName());
	}
}
