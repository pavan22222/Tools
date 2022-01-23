package com.vrnda.test;

import java.util.Optional;

public class OptionalAPITest {

	public static void main(String[] args) {
		//static empty()  returns an empty Optional Object
		Optional<Object> op1=Optional .empty();
		System.out.println(op1);
		//of(Object obj) stores an Object inside Optional , if passes value is not null stores ,otherwise throws Exception
		op1=op1.of("Pavan");
		System.out.println(op1);
		//static ofNullable(Object obj) stores an Object inside Optional 
		Optional< String> op2=Optional.ofNullable("Pavan");
		System.out.println(op2);	
		//equals(Optional op) Compares current Optional value with another optional value , returns true is same otherwise returns false 
		System.out.println(op2.equals(op1));	
		//filter(Predicate p); If a value is present, and the value matches the given predicate,returns an Optional describing the value, otherwise returns an empty Optional.
		System.out.println(op2.filter(data->data.equals("Pavan1")));
		//get() return optional describile value if present , otherwise throws exception
		System.out.println(op2.get());	
		//hashcode() returns the hashcode of describing value
		String s="Pavan";
		System.out.println(s.hashCode());
		Optional<String> op3=Optional.ofNullable(s);
		System.out.println(op3.hashCode());
		/** ifPresent(Consumer<? super T> consumer) If a value is present, it invokes the specified consumer with the value, otherwise does nothing.
		we can use this method  if the value is present then if we want to call any method by passing optional describing value. */
		op3.ifPresent(value -> System.out.println(value));
		//isPresent() Returns true if there is a value present, otherwise false.
		System.out.println(op3.isPresent());
		//  map(Function<? super T,? extends U> mapper) If a value is present, applies the provided mapping function to it, and if the result is non-null, returns an Optional describing the result.
		op3=op3.map(data->data.concat(" Janapati"));
		System.out.println(op3);
		// orElse(T other) Returns the value if present, otherwise returns other.
		Optional<String> op5=Optional.ofNullable("Pavan");
		System.out.println(op5.orElse("Pavan J"));
		//isEmpty() return true if optional describing value is empty else return false
		Optional<String> op6=Optional.empty();
		System.out.println(op6.isEmpty());
		System.out.println(op5.isEmpty());
				
	}
}
