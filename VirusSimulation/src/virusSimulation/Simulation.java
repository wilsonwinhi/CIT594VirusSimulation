package virusSimulation;

import java.util.*;

public class Simulation {
	public static void main(String[] args) {
		int argc = args.length;
		FileReaderTxt myText = new FileReaderTxt("facebook_combined (1).txt");
		List<String> textList = myText.getAllLines();
		AdjPreprocess preprocessMachine = new AdjPreprocess();
		int totalPeople = preprocessMachine.getTotalPeople();
		/* preprocess to adjacency list */
		Map<String, Set<String>> adjList = preprocessMachine.adjPreprocess(textList);
		/* virus probability */
		double probability = Double.parseDouble(args[0]);
		/* seed */
		int seedNum = Integer.parseInt(args[1]);
		/* create seed into queue */
		Queue<String> q = new LinkedList<>();
		
		/* run bfs */
		// BFS1Round
	}
}
