package me.yoerger.geoff.edu.progClass.assignments.ten;

import java.io.IOException;

import junit.framework.TestCase;
import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.main.AssesmentGetter;
import me.yoerger.geoff.edu.progClass.mod10.FileHandler;

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
	public void testForAssignments() {
		for(int i = 6; i <= 10; i++) {
			for(int j = 1; j <= 7; j++ ) {
				try {
					assertNotNull("Assesment Getter returns assignment: " + i + " " + j, AssesmentGetter.getAssignment(i, j));
				} catch (ClassNotFoundException e) {
					fail("Assignment " +  i + " " + j + " does not exist formally");
				}
			}
		}
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAssesmentGetterArgs01() throws ClassNotFoundException {
		AssesmentGetter.getAssignment(5, 1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAssesmentGetterArgs10() throws ClassNotFoundException {
		AssesmentGetter.getAssignment(6, 0);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAssesmentGetterArgs00() throws ClassNotFoundException {
		AssesmentGetter.getAssignment(11, 1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAssesmentGetterArgs() throws ClassNotFoundException {
		AssesmentGetter.getAssignment(6, 8);
	}
	
	@Test
	public void testAssignmentsConditions() throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		for(int i = 6; i <= 10; i++) {
			for(int j = 1; j <= 7; j++ ) {
				Class<?> assignment = AssesmentGetter.getAssignment(i, j);
				assignment.getMethod("main", String[].class);
				assignment.getMethod("printQuestions", Printer.class);
			}
		}
	}
	
	@Test(expected = IOException.class) 
	public void testFileHandlerWNull() throws IOException {
		new FileHandler(null).readFile();
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
