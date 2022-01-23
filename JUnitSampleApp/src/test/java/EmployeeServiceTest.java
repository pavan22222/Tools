import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.nt.service.EmplolyeeService;


@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class EmployeeServiceTest {
	
	private static EmplolyeeService service;
	
	
	//@BeforeEach
	@BeforeAll
	public static void setUp() {
		service=EmplolyeeService.getInstance();
	}
	
	@Test
	@DisplayName("testgetName")
	@Order(2)
	@Tag("dev")
	public void testgetName() {
		System.out.println("EmployeeServiceTest.testgetName()");
		//Assertions.assertEquals("Pavan12", service.getName(12));
		Assertions.assertNotEquals("Pavan12", service.getName(12));
	}
	
	@Test
	@Order(4)
	@DisplayName("testgetNameDoesNotThrowError")
	@Tag("prod")
	public void testgetNameDoesNotThrowError() {
		System.out.println("EmployeeServiceTest.testgetNameDoesNotThrowError()");
		Assertions.assertDoesNotThrow(()->service.getName(12),"May be it is not throwing any exception");
	}
	
	@Test
	@Order(1)
	@Tag("uat")
	public void testIsExistsById() {
		System.out.println("testIsExistsById");
		Assertions.assertTimeout(Duration.ofMillis(1),()->service.existsById(12));
	}
	
	
	@Test
	@Order(-1)
	@Tag("test")
	@RepeatedTest(value=3,name = "testGetMaxSalary")
	public void testGetMaxSalary() {
		System.out.println("EmployeeServiceTest.testGetMaxSalary()");
		Assertions.assertThrows(Exception.class, ()->service.getMaxSalary(),"It May throwing othet exception");
	}
	
	
	@ParameterizedTest
	@ValueSource(ints= {2,12,4,16,6})
	public void testCheckEvenOrNot(Integer value) {
		System.out.println("EmployeeServiceTest.testCheckEvenOrNot()");
		Assertions.assertTrue(service.checkEvenOrNot(value));
	}
	
	@Test
	@Order(23)
	public void checkTwoReferences() {
		EmplolyeeService service1=EmplolyeeService.getInstance();
		EmplolyeeService service2=EmplolyeeService.getInstance();
		//Assertions.assertNull(service2);
		//Assertions.assertNotNull(service1);
		Assertions.assertSame(service1, service2);
	}
	
	
	
	//@AfterEach
	@AfterAll
	public static void close() {
		service=null;
	}
	
	
	
}
