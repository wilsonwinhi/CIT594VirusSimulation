package virusSimulation;

import java.util.*;

public class Simulation {
	public static void main(String[] args) {
		FileReaderTxt myText = new FileReaderTxt("facebook_combined (1).txt");
		List<String> textList = myText.getAllLines();
		AdjPreprocess preprocessMachine = new AdjPreprocess();
		Map<String, Set<String>> adjList = preprocessMachine.adjPreprocess(textList);
	
	}
}
