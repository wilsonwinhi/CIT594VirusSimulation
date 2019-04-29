package virusSimulation;

import java.util.*;

public class test {
	int infectedPeopleNum;
	Random random;
	List<Integer> resOfInfectedPpl;
	public test() {
		random = new Random();
		infectedPeopleNum = 0;
		resOfInfectedPpl = new ArrayList<>();
	}
	public List<Integer> BFS1Round(Queue<People> q, double probability, int days, List<People> adjList) {
		for(int j = 0;j<days;j++) {
			int size = q.size();
			System.out.println("Size: " + size);
			for(int i = 0;i<size;i++) {
				People current = q.poll();
				//List<People> netWork = ((UnhealthyPeople)current).socialNetwork;
				List<People> netWork = current.getSocialNetwork();
				List<People> network = new ArrayList<>();
				for (People each : netWork) {
					int val = netWork.indexOf(new People(each.getName()));
					People toPut = adjList.get(val);
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
