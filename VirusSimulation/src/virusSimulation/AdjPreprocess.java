package virusSimulation;
import java.util.*;
public class AdjPreprocess {
	private Set<People> peopleSet;
	private int totalPeopleNum;
	public AdjPreprocess() {
		peopleSet = new HashSet<>();
		totalPeopleNum = 0;
	}
//    public Map<String, Set<String>> adjPreprocess(List<String> s) {
//    	Map<String, Set<String>> adjList = new HashMap<>();
//		for(String each: s) {
//			String[] people = each.split("\\s+");
//			if (!adjList.containsKey(people[0])) {
//				adjList.put(people[0], new HashSet<>());
//			}
//			adjList.get(people[0]).add(people[1]);
//			peopleSet.add(people[0]);
//			peopleSet.add(people[1]);
//		}
//		totalPeopleNum = adjList.size();
//		return adjList;
//    }
    public List<People> adjPreprocess(List<String> s) {
    	List<People> adjList = new LinkedList<>();
		for(String each: s) {
			String[] people = each.split("\\s+");
			People firstPpl = new People(people[0]);
			People secondPpl = new People(people[1]);
			if (!adjList.contains(firstPpl)) {
				adjList.add(firstPpl);
			}
			if (!adjList.contains(secondPpl)) {
				adjList.add(secondPpl);
			}
			
			People toAdd = adjList.indexOf(firstPpl) == -1 ? secondPpl : adjList.get(adjList.indexOf(secondPpl));
			adjList.get(adjList.indexOf(firstPpl)).addPeople(toAdd);
			
			peopleSet.add(firstPpl);
			peopleSet.add(secondPpl);
		}
		
		totalPeopleNum = adjList.size();
		return adjList;
    }

	public int getTotalPeople() {
		// TODO Auto-generated method stub
		return totalPeopleNum;
	}
}
