package me.yoerger.geoff.edu.progClass.assignments.ten;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import junit.framework.TestCase;
import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.assignments.SysOutPrinter;
import me.yoerger.geoff.edu.progClass.bookClasses.ImageFormatException;
import me.yoerger.geoff.edu.progClass.main.AssesmentGetter;
import me.yoerger.geoff.edu.progClass.mod10.FileHandler;
import me.yoerger.geoff.edu.progClass.mod10.JukeBox;
import me.yoerger.geoff.edu.progClass.mod10.MusicScore;
import me.yoerger.geoff.edu.progClass.mod10.Note;
import me.yoerger.geoff.edu.progClass.mod10.NoteDur;
import me.yoerger.geoff.edu.progClass.mod6.AdultContactInfo;
import me.yoerger.geoff.edu.progClass.mod6.BigIdea;
import me.yoerger.geoff.edu.progClass.mod6.ContactInfo;
import me.yoerger.geoff.edu.progClass.mod6.MovieTicket;
import me.yoerger.geoff.edu.progClass.mod6.MovieUser;
import me.yoerger.geoff.edu.progClass.mod6.UsedCar;
import me.yoerger.geoff.edu.progClass.mod7.CoordPair;
import me.yoerger.geoff.edu.progClass.mod7.RandomColor;
import me.yoerger.geoff.edu.progClass.mod7.Range;
import me.yoerger.geoff.edu.progClass.mod8.Grayscale;
import me.yoerger.geoff.edu.progClass.mod9.Drawer;

import org.javatuples.Pair;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Project for module 10
 *
 */
@RunWith(value=BlockJUnit4ClassRunner.class)
public class tenProject extends TestCase implements Analysis{
	private static final Random random = new Random(System.currentTimeMillis());

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
				assignment.getMethod("printQuestions", SysOutPrinter.class);
			}
		}
	}
	
	@Test(expected = IOException.class) 
	public void testFileHandlerWNull() throws IOException {
		new FileHandler(null).readFile();
	}
	
	@Test(expected = NullPointerException.class)
	public void testJukeBox() {
		JukeBox jukebox = new JukeBox(null, null);
		jukebox.playSong(0);
	}
	@Test
	public void testMusicScore() {
		MusicScore score = new MusicScore();
		List<Pair<NoteDur, Note>> notes = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
		notes.add(new Pair<NoteDur, Note>
			(NoteDur.values()[random.nextInt(NoteDur.values().length)], 
					Note.values()[random.nextInt(Note.values().length)]));
		}
		score.addAll(notes);
		assertEquals("Music Score returns all notes correctly", notes, score.getNotes());
	}
	@Test
	public void testNotes() {
		for(char i = 'C'; i <= 'G'; i++) {
			assertEquals(Note.valueOf(new String(new char[] {i     })).num + 12, 
						 Note.valueOf(new String(new char[] {i, 'h'})).num);
		}
		assertEquals(NoteDur.Half.time * 2, NoteDur.Whole.time);
		assertEquals(NoteDur.Quarter.time * 2, NoteDur.Half.time);
		assertEquals(NoteDur.Eigth.time * 2, NoteDur.Quarter.time);
		assertEquals(NoteDur.Sixteenth.time * 2, NoteDur.Eigth.time);
		assertEquals(NoteDur.Quarter.time * 1.5, NoteDur.QuarterDotted.time);
		assertEquals(NoteDur.Half.time * 1.5, NoteDur.HalfDotted.time);
		assertEquals(NoteDur.Eigth.time * 1.5, NoteDur.EigthDotted.time);
		
	}
	
	@Test
	public void testContactInfo() {
		String name = "Geoff";
		long homePhone = random.nextLong();
		long workPhone = random.nextLong();
		long cellPhone = random.nextLong();
		AdultContactInfo aInfo = new AdultContactInfo(name, homePhone, cellPhone, workPhone);
		ContactInfo cInfo = new ContactInfo(name, homePhone, cellPhone);
		assertTrue(cInfo.toString().contains(String.valueOf(cellPhone)));		
		assertTrue(cInfo.toString().contains(String.valueOf(homePhone)));		
		assertTrue(cInfo.toString().contains(name));		
		assertTrue(aInfo.toString().contains(String.valueOf(cellPhone)));		
		assertTrue(aInfo.toString().contains(String.valueOf(homePhone)));		
		assertTrue(aInfo.toString().contains(String.valueOf(workPhone)));		
		assertTrue(aInfo.toString().contains(name));		
	}

	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testBigIdeaException1() {
		BigIdea idea = new BigIdea(5, null);
	}
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void testBigIdeaException2() {
		BigIdea idea = new BigIdea(11, null);
	}
	@Test
	public void testBigIdea() {
		int modNum = random.nextInt(5) + 6;
		BigIdea idea = new BigIdea(modNum, " Test2 ");
		idea.setNewDesc(" Test2 ");
		assertTrue(idea.toString().contains(String.valueOf(modNum)));
		assertTrue(idea.toString().contains(" Test1 "));
		assertTrue(idea.toString().contains(" Test2 "));
	}

	@Test
	public void testCar() {
		int year = random.nextInt();
		int mpm = random.nextInt();
		float mpg = random.nextFloat();
		
		UsedCar car = new UsedCar(" Test1 ", " Test2 ", year, mpg, mpm);
		assertTrue(car.toString(true, true).contains(String.valueOf(year)));
		assertTrue(car.toString(true, true).contains(String.valueOf(mpm)));
		assertTrue(car.toString(true, true).contains(String.valueOf(mpg)));
		assertTrue(car.toString(true, true).contains(" Test1 "));
		assertTrue(car.toString(true, true).contains(" Test2 "));
		assertTrue(car.toString(false, false).contains(String.valueOf(year)));
		assertFalse(car.toString(false, false).contains(String.valueOf(mpm)));
		assertFalse(car.toString(false, false).contains(String.valueOf(mpg)));
		assertTrue(car.toString(false, false).contains(" Test1 "));
		assertTrue(car.toString(false, false).contains(" Test2 "));
	}
	@Test
	public void testMovieTicket() {
		MovieUser user = new MovieUser(" TestName ", 12345, 0);
		MovieTicket ticket = new MovieTicket(user, " Test2 ", 676);
		String reciept = ticket.reciept();
		assertTrue("Reciept contains name", reciept.contains(" TestName "));
		assertTrue("Reciept contains num admissions", reciept.contains(676 + ""));
		assertTrue("Reciept contains movie name", reciept.contains(" Test2 "));
		assertTrue("Recipet contains greeting", reciept.toLowerCase().contains("enjoy"));
	}
	
	@Test
	public void testCoordPair() {
		CoordPair pair = new CoordPair(676, 989);
		assertTrue("toString contains values", pair.toString().contains("676") && pair.toString().contains("989"));
		assertTrue("X value returned correctly", pair.getX() == 676);
		assertTrue("Y value returned correctly", pair.getY() == 989);
		Set<Integer> hashCodeSet = new HashSet<>();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				hashCodeSet.add(new CoordPair(i, j).hashCode());
			}
		}
		assertTrue("CoordPair [0-10][0-10] hash codes are unique", hashCodeSet.size() == 100);
	} 
	
	@Test
	public void testRandomColor() {
		Color color1 = RandomColor.make();
		Color color2 = RandomColor.make();
		int i = 0;
		while(!color1.equals(color2) && i < 100) {
			color2 = RandomColor.make();
		}
		assertTrue("RandomColor returns atleast 2 different values", color1.equals(color2));
		
	}
	
	@Test
	public void testRange() {
		int min = random.nextInt(100);
		int max = min + random.nextInt(100);
		Range range = new Range(max);
		assertTrue("1 arg constructor contains 1", range.range().contains(1));
		assertTrue("1 arg constructor contains max", range.range().contains(max));
		range = new Range(min, max);
		assertTrue("2 arg constructor does not contain min", !range.range().contains(min));
		assertTrue("2 arg constructor contains min + 1", range.range().contains(min + 1));
		assertTrue("2 arg constructor contains max", range.range().contains(max));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGrayScaleExceptions1() throws ImageFormatException {
		Grayscale.grayscale(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGrayScaleExceptions2() throws ImageFormatException {
		Grayscale.grayscale("jpg");
	}
	@Test(expected = ImageFormatException.class)
	public void testGrayScaleExceptions3() throws ImageFormatException {
		Grayscale.grayscale("null/null/null.jpeg");
	}
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void testDrawerException() {
		Drawer drawer = new Drawer(null);
	}
	

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(tenProject.class);
		System.out.println("After " + result.getRunCount() + " runs over " + result.getRunTime() / 1000.0 + " seconds:");
		
		if(result.wasSuccessful()) {
			System.out.println("Everything ran correctly!");
		} else {
			System.out.println("The following tests failed: ");
		}
		
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.getTrace());
		}
	}
	@Override
	public void printQuestions(Printer printer) {
		printer.print("TODO");
		printer.printAnswer("TODO");
		
		
	}
}
