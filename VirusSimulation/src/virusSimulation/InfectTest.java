package virusSimulation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class InfectTest {
	
	Infect test = new Infect();
	Virus virus = new unmutableVirus(1,"flu");
	Virus virus2 = new unmutableVirus(0,"flu");

	@Test
	public void testInfect() {
		assertEquals(test.resOfInfectedPpl.size(),0);
	}

	@Test
	public void testBFS() {
		Queue<People> storage = new LinkedList<>();
		People node1 = new People("1");
		People node2 = new People("2");
		People node3 = new People("3");
		People node4 = new People("4");
		People node5 = new People("5");
		People node6 = new People("6");
		People node7 = new People("7");
		People node8 = new People("8");
		List<People> node1Adj = node1.getSocialNetwork();
		node1Adj.add(node2);
		node1Adj.add(node3);
		node1Adj.add(node4);
		List<People> node2Adj = node2.getSocialNetwork();
		node2Adj.add(node7);
		List<People> node3Adj = node3.getSocialNetwork();
		node3Adj.add(node8);
		List<People> node4Adj = node4.getSocialNetwork();
		node4Adj.add(node5);
		List<People> node5Adj = node5.getSocialNetwork();
		node5Adj.add(node1);
		List<People> node6Adj = node6.getSocialNetwork();
		node6Adj.add(node2);
		List<People> node7Adj = node7.getSocialNetwork();
		node7Adj.add(node6);
		node1.gotInfected();
		storage.add(node1);
		List<People> adjList = new ArrayList<>();
		adjList.add(node1);
		adjList.add(node2);
		adjList.add(node3);
		adjList.add(node4);
		adjList.add(node5);
		adjList.add(node6);
		adjList.add(node7);
		adjList.add(node8);
		List<Integer> a1 = test.BFS(storage,virus,4,adjList);
		int first = a1.get(0);
		assertEquals(first,4);
		int second = a1.get(1);
		assertEquals(second,7);
		int third = a1.get(2);
		assertEquals(third,8);
		int fourth = a1.get(3);
		assertEquals(fourth,8);
	}
	
	
	@Test
	public void testBFS2() {
		Queue<People> storage = new LinkedList<>();
		People node1 = new People("1");
		People node2 = new People("2");
		People node3 = new People("3");
		People node4 = new People("4");
		People node5 = new People("5");
		People node6 = new People("6");
		People node7 = new People("7");
		People node8 = new People("8");
		List<People> node1Adj = node1.getSocialNetwork();
		node1Adj.add(node2);
		node1Adj.add(node3);
		node1Adj.add(node4);
		List<People> node2Adj = node2.getSocialNetwork();
		node2Adj.add(node7);
		List<People> node3Adj = node3.getSocialNetwork();
		node3Adj.add(node8);
		List<People> node4Adj = node4.getSocialNetwork();
		node4Adj.add(node5);
		List<People> node5Adj = node5.getSocialNetwork();
		node5Adj.add(node1);
		List<People> node6Adj = node6.getSocialNetwork();
		node6Adj.add(node2);
		List<People> node7Adj = node7.getSocialNetwork();
		node7Adj.add(node6);
		node1.gotInfected();
		storage.add(node1);
		List<People> adjList = new ArrayList<>();
		adjList.add(node1);
		adjList.add(node2);
		adjList.add(node3);
		adjList.add(node4);
		adjList.add(node5);
		adjList.add(node6);
		adjList.add(node7);
		adjList.add(node8);
		List<Integer> a1 = test.BFS(storage,virus2,4,adjList);
		int first = a1.get(0);
		assertEquals(first,1);
		int second = a1.get(1);
		assertEquals(second,1);
		int third = a1.get(2);
		assertEquals(third,1);
		int fourth = a1.get(3);
		assertEquals(fourth,1);
	}

	@Test
	public void testBFSwithTreatment1() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindTopKSocialPeople() {
		People node1 = new People("1");
		People node2 = new People("2");
		People node3 = new People("3");
		People node4 = new People("4");
		People node5 = new People("5");
		People node6 = new People("6");
		People node7 = new People("7");
		People node8 = new People("8");
		List<People> node1Adj = node1.getSocialNetwork();
		node1Adj.add(node2);
		node1Adj.add(node3);
		node1Adj.add(node4);
		List<People> node2Adj = node2.getSocialNetwork();
		node2Adj.add(node7);
		List<People> node3Adj = node3.getSocialNetwork();
		node3Adj.add(node8);
		List<People> node4Adj = node4.getSocialNetwork();
		node4Adj.add(node5);
		List<People> node5Adj = node5.getSocialNetwork();
		node5Adj.add(node1);
		List<People> node6Adj = node6.getSocialNetwork();
		node6Adj.add(node2);
		List<People> node7Adj = node7.getSocialNetwork();
		node7Adj.add(node6);
		List<People> adjList = new ArrayList<>();
		adjList.add(node1);
		adjList.add(node2);
		adjList.add(node3);
		adjList.add(node4);
		adjList.add(node5);
		adjList.add(node6);
		adjList.add(node7);
		adjList.add(node8);
		List<People> answer = test.findTopKSocialPeople(adjList, 1);
		assertEquals(answer.size(),1);
		assertEquals(answer.get(0),node1);
	}

	@Test
	public void testGiveTreatMent() {
		People node1 = new People("1");
		List<People> adjList = new ArrayList<>();
		adjList.add(node1);
		test.giveTreatMent(adjList);
		assertEquals(node1.isHealthy,true);
		assertEquals(node1.isTreated,true);
	}

	@Test
	public void testBFSwithTreatment2() {
		fail("Not yet implemented");
	}

}
