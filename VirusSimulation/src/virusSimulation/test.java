package virusSimulation;

import java.util.*;

public class test {
	public int BFS1Round(Map<String,Set<String>> map, Queue<String> storage, double virusProb) {
		int count = 0;
		Random random = new Random();
		int size = storage.size();
		for(int i = 0; i<size;i++) {
			String current = storage.poll();
			//if(current instanceof HealthyPeople || 
					//current instanceof TreatedPeople) {
				//continue;
			//}
			//List<People> netWork = ((UnhealthyPeople)current).socialNetwork;
			Set<String> netWork = map.get(current); 
			if (netWork == null) return count;
			for(String each: netWork) {
				//if(each instanceof UnhealthyPeople || each instanceof TreatedPeople) {
					//continue;
				//}
				//double eachResistance = ((HealthyPeople)each).resistence;
				//double overall = eachResistance*virusProb;
				//int randomNumber = random.nextInt(101);
				//if(randomNumber<overall*100) {
					count++;
					//String eachName = ((HealthyPeople)each).getName();
					//List<People> eachNetwork = ((HealthyPeople)each).getSocialNetwork();
					//each = new UnhealthyPeople(eachName,eachResistance,eachNetwork);
					storage.offer(each);
				//}
				
			}
			
		}
		return count;
	}
}
