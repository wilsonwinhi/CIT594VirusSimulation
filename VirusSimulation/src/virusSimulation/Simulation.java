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
		
		
//		for (People p : adjList) {
//				System.out.println("name: " + p.getName());
//				System.out.println("size of social network: " + p.getSocialNetwork().size());
//		}
		
		/* process user input */
		/* virus probability */
		double probability = Double.parseDouble(args[0]);
		/* seed */
		int seedNum = Integer.parseInt(args[1]);
		/* how many days? */
		int days = Integer.parseInt(args[2]);
		Random random = new Random();
		
		/* create seed into queue */
		Queue<People> q = new LinkedList<>();
		
		
		boolean[] used = new boolean[totalPeople];
		while (q.size() < seedNum) {
			int val = random.nextInt(totalPeople);
			if (!used[val]) {
				People toPut = adjList.get(val);
				toPut.gotInfected();
				q.offer(toPut);
			}
			used[val] = true;
		}
		
		int infectedPeopleNum = 0 + seedNum;
		test bfs = new test();
//		System.out.println("total people: " + totalPeople);
//		/* run bfs */
//		for (int i = 0; i < days; i++) {
//			infectedPeopleNum += bfs.BFS1Round(q, probability);
//			System.out.println(infectedPeopleNum);
//		}
		
		// BFS1Round
		for(int i = 0;i<days;i++) {
			People current = q.poll();
			if(current.isHealthy==true || 
					current.isTreated==true) {
				continue;
			}
			//List<People> netWork = ((UnhealthyPeople)current).socialNetwork;
			List<People> netWork = current.getSocialNetwork(); 
//			System.out.println(netWork);
			for(People each: netWork) {
				if(each.isTreated==true || each.isHealthy==false) {
					continue;
				}
				// double eachResistance = each.getResistence();
				double overall = probability;
				
				int randomNumber = random.nextInt(100);
				if(randomNumber<=overall*100) {
					infectedPeopleNum++;
					each.gotInfected();
					q.offer(each);
				}
				
			}
//			System.out.println("current size is "+storage.size());
			System.out.println(infectedPeopleNum);
		}
	}
}
