package me.yoerger.geoff.edu.progClass.assignments.ten;

import junit.framework.TestCase;
import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Project for module 10
 *
 */
public class tenProject extends TestCase implements Analysis{


//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Before
//	protected void setUp() throws Exception {
//		super.setUp();
//	}
//
//	@After
//	protected void tearDown() throws Exception {
//		super.tearDown();
//	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	
	

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(tenProject.class);
		if(result.wasSuccessful()) {
			System.out.println("Everything ran correctly!");
		}
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	}
	@Override
	public void printQuestions(Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");
		
		
	}
}
