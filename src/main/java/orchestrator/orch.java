package orchestrator;

import java.util.ArrayList;

import phrase.phraseOrch;
import question.quesOrch;
import question.questionAnnotation;
import tokenAnnotation.token;
import init.initializer;

public class orch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//intialize the initializer
		initializer init = new initializer();
//		String question = "Give me all cosmonauts.";
		ArrayList<String> questionList = new ArrayList<String>();
		questionList.add("Give me all cosmonauts.");
		questionList.add("To which countries does the Himalayan mountain system extend?");
		questionList.add("Who was the father of Queen Elizabeth II?");
		
		for(String question: questionList){
			quesOrch question_orch = new quesOrch();
			//Now pass it to phrase merger module
			phraseOrch phrase = new phraseOrch();
			questionAnnotation ques_annotation = question_orch.questionOrchestrator(question);
			
			
			phrase.phraseMergerOrchestrator(ques_annotation);
		}
		
		
		
//		System.out.println(question_orch.questionOrchestrator(question));

	}

}
