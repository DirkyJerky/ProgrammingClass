package me.yoerger.geoff.edu.progClass.assignments.ten;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;
import me.yoerger.geoff.edu.progClass.assignments.Analysis;
import me.yoerger.geoff.edu.progClass.assignments.Printer;
import me.yoerger.geoff.edu.progClass.main.AssesmentGetter;
import me.yoerger.geoff.edu.progClass.mod10.FileHandler;
import me.yoerger.geoff.edu.progClass.mod10.JukeBox;
import me.yoerger.geoff.edu.progClass.mod10.MusicScore;
import me.yoerger.geoff.edu.progClass.mod10.Note;
import me.yoerger.geoff.edu.progClass.mod10.NoteDur;

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
				assignment.getMethod("printQuestions", Printer.class);
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
