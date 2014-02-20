package mod8;

import java.util.HashMap;
import java.util.Map;

import javax.crypto.IllegalBlockSizeException;

import mod7.Range;

import com.google.common.base.Preconditions;

public class Analysis implements Printable {
	private Map<Integer, String> questions;
	private Map<Integer, String> answers;
	
	private int numOfQuestions;
	
	
	public Analysis(int numberOfQuestions) {
		this.questions = new HashMap<>();
		this.answers = new HashMap<>();
		this.numOfQuestions = numberOfQuestions;
	}
	
	public void addQuestion(String s) {
		questions.put(questions.size(), s);
	}
	
	public void addQuestion(int questionNum, String s) {
		questions.put(questionNum, s);
	}
	
	public void answer(int questionNum, String s) {
		Preconditions.checkArgument(questionNum < numOfQuestions);
		Preconditions.checkArgument(!answers.containsKey(questionNum));
		Preconditions.checkArgument(questions.containsKey(questionNum));
	}
	
	public void print() throws Exception {
		if (questions.size() != numOfQuestions) {
			throw new IllegalBlockSizeException("Wrong number of questions");
		} else if (answers.size() != numOfQuestions) {
			throw new IllegalBlockSizeException("Wrong number of answers");
		}
		
		for(int i : new Range(0, numOfQuestions).range()) {
			if (questions.get(i).endsWith("?")) {
				System.out.println(questions.get(i));
			} else {
				System.out.println(questions.get(i) + "?");
			}
			System.out.println(answers.get(i));
		}
	}
	
}
