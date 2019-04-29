package virusSimulation;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class testTest {
	
	test test = new test();
	
	
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
		List<Integer> a1 = test.BFS(storage,1.0,4,adjList);
		int first = a1.get(0);
		assertEquals(first,3);
		int second = a1.get(1);
		assertEquals(second,6);
		int third = a1.get(2);
		assertEquals(third,7);
		int fourth = a1.get(3);
		assertEquals(fourth,7);
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
		List<Integer> a1 = test.BFS(storage,0.0,4,adjList);
		int first = a1.get(0);
		assertEquals(first,0);
		int second = a1.get(1);
		assertEquals(second,0);
		int third = a1.get(2);
		assertEquals(third,0);
		int fourth = a1.get(3);
		assertEquals(fourth,0);
	}

	@Test
	public void testBFS3() {
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
		node1.isTreated = true;
		List<Integer> a1 = test.BFS(storage,0.0,4,adjList);
		int first = a1.get(0);
		assertEquals(first,0);
		int second = a1.get(1);
		assertEquals(second,0);
		int third = a1.get(2);
		assertEquals(third,0);
		int fourth = a1.get(3);
		assertEquals(fourth,0);
	}

	
}
