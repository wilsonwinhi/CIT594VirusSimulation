package virusSimulation;

import java.util.*;


public class test {

	
	public int BFS1Round(Map<People,Set<People>> map, Queue<People> storage, double virusProb) {
		int count = 0;
		//Random random = new Random();
		int size = storage.size();
		for(int i = 0;i<size;i++) {
			People current = storage.poll();
			if(current instanceof HealthyPeople || 
					current instanceof TreatedPeople) {
				continue;
			}
			//List<People> netWork = ((UnhealthyPeople)current).socialNetwork;
			if(!map.containsKey(current)) {
				continue;
			}
			Set<People> netWork = map.get(current); 
			for(People each: netWork) {
				if(each instanceof UnhealthyPeople || each instanceof TreatedPeople) {
					continue;
				}
				//double eachResistance = ((HealthyPeople)each).resistence;
				//double overall = eachResistance*virusProb;
				//int randomNumber = random.nextInt(101);
				//if(randomNumber<overall*100) {
					count++;
					String eachName = ((HealthyPeople)each).getName();
					List<People> eachNetwork = ((HealthyPeople)each).getSocialNetwork();
					each = new UnhealthyPeople(eachName,0,eachNetwork);
					storage.offer(each);
				//}
				
			}
			
		}
		return count;
	}
}
