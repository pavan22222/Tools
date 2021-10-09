package com.vrnda.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vrnda.dto.Employee;

public class StreamAPITest {

	public static void main(String[] args) {
		
		System.out.println("....................................................filter()...........................................................................................");
		
		ArrayList<Integer> alFilter = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			alFilter.add(i);
		}
		System.out.println("Before Filter,List is ::" + alFilter);
		List<Integer> filteredAl = alFilter.stream().filter(ele -> ele % 2 == 0).collect(Collectors.toList());
		System.out.println("Before Filter,List is ::" + filteredAl);

		ArrayList<Employee> emps = new ArrayList<Employee>();
		for (int i = 1; i < 11; i++) {
			emps.add(new Employee(i, "Pavan"));
		}
		System.out.println("Before Filter,List is ::" + emps);
		List<Employee> filteredEmps = emps.stream().filter(ele -> ele.getId() % 2 == 0).collect(Collectors.toList());
		System.out.println("Before Filter,List is ::" + filteredEmps);
		 
		System.out.println("....................................................map()...........................................................................................");

		ArrayList<Integer> alMap = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			alMap.add(i);
		}
		System.out.println("Before map(),List is ::" + alMap);
		List<Integer> mappedAl = alMap.stream().map(ele -> ele+10).collect(Collectors.toList());
		System.out.println("After map(),List is ::" + mappedAl);
		
		
		ArrayList<Employee> empList = new ArrayList<Employee>();
		for (int i = 1; i < 11; i++) {
			empList.add(new Employee(i, "Pavan"));
		}
		System.out.println("Before map(),List is ::" + empList);
		List<Employee> updatedempList = empList.stream().map(emp -> {
			emp.setId(emp.getId()+100);
			return emp;
		}
		).collect(Collectors.toList());
		System.out.println("After map(),List is ::" + updatedempList);
		
		System.out.println("....................................................count()...........................................................................................");
	
		ArrayList<Integer> countList = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			countList.add(i);
		}
		Long count = countList.stream().count();
		System.out.println("Count of List is :: " + count);
		
		System.out.println("....................................................sorted()...........................................................................................");
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 10; i > 0; i--) {
			list.add(i);
		}
		System.out.println("Before sorted(),List is ::" + list);
		//List<Integer> sortedList= list.stream().sorted().collect(Collectors.toList());
		List<Integer> sortedList= list.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());
		System.out.println("After sorted(),List is ::" + sortedList);
		
		System.out.println("....................................................sorted(Comparator)...........................................................................................");
		
		ArrayList<Integer> alList = new ArrayList<Integer>();
		for (int i = 1; i < 11; i++) {
			alList.add(i);
		}
		System.out.println("Before sorted(Comparator),List is ::" + alList);
		List<Integer> sortedCompList= alList.stream().sorted((a,b)->(a<b)?1:(a>b)?-1:0).collect(Collectors.toList());
		System.out.println("After sorted(Comparator),List is ::" + sortedCompList);
		
		System.out.println("....................................................sorted(Comparator) for Employee...........................................................................................");
		
		ArrayList<Employee> empsList = new ArrayList<Employee>();
		for (int i = 1; i < 11; i++) {
			empsList.add(new Employee(i,"Pavan"));
		}
		System.out.println("Before sorted(Comparator),List is ::" + empsList);
		List<Employee> sortedEmpsList= empsList.stream().sorted((a,b)->(a.getId()<b.getId())?1:(a.getId()>b.getId())?-1:0).collect(Collectors.toList());
		System.out.println("After sorted(Comparator),List is ::" + sortedEmpsList);
		
		System.out.println("....................................................min(Comparator)...........................................................................................");
		
		
		Employee minEmp= empsList.stream().min((a,b)->(a.getId()<b.getId())?1:(a.getId()>b.getId())?-1:0).get();
		System.out.println("MIn Employee Is ::" + minEmp);
		Employee maxEmp= empsList.stream().max((a,b)->a.getId().compareTo(b.getId())).get();
		System.out.println("Max Employee Is ::" + maxEmp);
		
		System.out.println("....................................................forEach(Consumer)...........................................................................................");
		
		ArrayList<Employee> forEachList = new ArrayList<Employee>();
		for (int i = 1; i < 11; i++) {
			forEachList.add(new Employee(i,"Pavan"));
		}
		forEachList.stream().forEach(emp->emp.setName("PJ"));
		System.out.println(forEachList);
		
		Employee[] empArray=forEachList.stream().toArray(Employee[]::new);
		System.out.println(Arrays.deepToString(empArray));
		
		System.out.println("....................................................of(T)...........................................................................................");
		Stream<Integer> s=Stream.of(1,11,111,1111);
		System.out.println(Arrays.deepToString(s.toArray(Integer[]::new )));
		
	}

}
