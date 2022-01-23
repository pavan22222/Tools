package com.nt.service;

public class EmplolyeeService {
	
	private static EmplolyeeService service;
	
	
	static {
		 service=new EmplolyeeService();
	}
	private EmplolyeeService() {
		
	}
	
	public static EmplolyeeService getInstance() {
		return service;
	}
	
	public String getName(Integer id) {
		return "Pavan";
	}
	
	
	public Boolean existsById(Integer id) {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return id>10?true:false;
	}
	
	public Float getMaxSalary() {
		if(true)
			throw new NullPointerException();
		return 100000f;
	}
	
	public Boolean checkEvenOrNot(Integer value) {
		return value%2 == 0 ? true:false;
	}
	
}
