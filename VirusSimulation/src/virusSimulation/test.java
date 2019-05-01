package virusSimulation;

import java.util.*;

public class test {
	int infectedPeopleNum;
	Random random;
	List<Integer> resOfInfectedPpl;
	
	
	/**
	 * This is the constructor of the class test
	 */
	public test() {
		random = new Random();
		infectedPeopleNum = 0;
		resOfInfectedPpl = new ArrayList<>();
	}

	
	/**
	 * This function aims calculate the number of infected people after each iteration
	 * @param q: the queue of people 
	 * @param probability: probability of spread of virus
	 * @param days: the number of iterations of virus infection
	 * @param adjList: the list contains all People vertex 
	 * @return The list of number of infected people after each iteration 
	 */
	public List<Integer> BFS(Queue<People> q, double probability, int days, List<People> adjList) {
		for(int j = 0;j<days;j++) {
			int size = q.size();
			System.out.println("Size: " + size);
			for(int i = 0;i<size;i++) {
				People current = q.poll();
				//List<People> netWork = ((UnhealthyPeople)current).socialNetwork;
				List<People> netWork = current.getSocialNetwork();
				List<People> network = new ArrayList<>();
				for (People each : netWork) {
					System.out.println("nei "+each.getName());
					int val = netWork.indexOf(new People(each.getName()));
					People toPut = adjList.get(val);
					System.out.println("toput "+toPut.getName());
					network.add(toPut);
				}
				System.out.println("network-> " + netWork.size());
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
			}
			resOfInfectedPpl.add(infectedPeopleNum);
		}
		return resOfInfectedPpl;
	}
}