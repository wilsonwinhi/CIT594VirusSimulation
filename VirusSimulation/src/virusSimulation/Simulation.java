package virusSimulation;

import java.util.*;

public class Simulation {
	public static void main(String[] args) {
		int argc = args.length;
		FileReaderTxt myText = new FileReaderTxt("facebook_combined (1).txt");
		List<String> textList = myText.getAllLines();
		AdjPreprocess preprocessMachine = new AdjPreprocess();
		
		/* preprocess to adjacency list */
		List<People> adjList = preprocessMachine.adjPreprocess(textList);
		int totalPeople = preprocessMachine.getTotalPeople();
		
		/* process user input */
		/* virus probability */
		double probability = Double.parseDouble(args[0]);
		/* seed */
		int seedNum = Integer.parseInt(args[1]);
		/* how many days? */
		int days = Integer.parseInt(args[2]);
		
		/* create seed into queue */
		Queue<People> q = new LinkedList<>();
		
		
		
		int infectedPeopleNum = 0 + seedNum;
		test bfs = new test();
//		System.out.println("total people: " + totalPeople);
//		/* run bfs */
//		for (int i = 0; i < days; i++) {
//			infectedPeopleNum += bfs.BFS1Round(adjList, q, probability);
//			System.out.println(infectedPeopleNum);
//		}
		
		// BFS1Round
	}
}
