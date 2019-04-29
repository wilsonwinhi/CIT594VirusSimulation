package virusSimulation;
import java.util.*;
public class AdjPreprocess {
	private Set<People> peopleSet;
	private int totalPeopleNum;
	public AdjPreprocess() {
		peopleSet = new HashSet<>();
		totalPeopleNum = 0;
	}
	/*
	 * convert list of strings to adjacency list of the graph
	 * each people has builtin neighbors
	 * @return List of People
	 */
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

    /*
     * @return total number of people in the graph
     */
	public int getTotalPeople() {
		// TODO Auto-generated method stub
		return totalPeopleNum;
	}
}
