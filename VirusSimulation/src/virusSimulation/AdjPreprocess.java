package virusSimulation;
import java.util.*;
public class AdjPreprocess {
	private Set<String> peopleSet;
	private int totalPeopleNum;
	public AdjPreprocess() {
		peopleSet = new HashSet<>();
		totalPeopleNum = 0;
	}
    public Map<String, Set<String>> adjPreprocess(List<String> s) {
    	Map<String, Set<String>> adjList = new HashMap<>();
		for(String each: s) {
			String[] people = each.split("\\s+");
			if (!adjList.containsKey(people[0])) {
				adjList.put(people[0], new HashSet<>());
			}
			adjList.get(people[0]).add(people[1]);
			peopleSet.add(people[0]);
			peopleSet.add(people[1]);
		}
		totalPeopleNum = adjList.size();
		return adjList;
    }

	public int getTotalPeople() {
		// TODO Auto-generated method stub
		return totalPeopleNum;
	}
}
