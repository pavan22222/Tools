package com.nt.test;

import java.util.HashSet;

import com.nt.model.Employee;

public class Test {
	
	
	
	public static void main(String[] args) {
		Employee emp1=new Employee(1,"Pavan",2300f);
		Employee emp2=new Employee(1,"Pavan",2300f);
		
		HashSet<Employee> hashSet=new HashSet<Employee>();
		hashSet.add(emp2);
		hashSet.add(emp1);
		System.out.println(hashSet);
	}
}
