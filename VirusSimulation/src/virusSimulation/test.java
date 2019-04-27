package virusSimulation;

import java.util.*;


public class test {

	
	public int BFS1Round(Queue<People> storage, double virusProb) {
		int count = 0;
		//Random random = new Random();
		int size = storage.size();
		for(int i = 0;i<size;i++) {
			People current = storage.poll();
			if(current.isHealthy==true || 
					current.isTreated==true) {
				continue;
			}
			//List<People> netWork = ((UnhealthyPeople)current).socialNetwork;
			List<People> netWork = current.getSocialNetwork(); 
			for(People each: netWork) {
				if(each.isTreated==true || each.isHealthy==false) {
					continue;
				}
				//double eachResistance = ((HealthyPeople)each).resistence;
				//double overall = eachResistance*virusProb;
				//int randomNumber = random.nextInt(101);
				//if(randomNumber<overall*100) {
					count++;
					each.isHealthy = false;
					storage.offer(each);
				//}
				
			}
			
		}
		return count;
	}
}
