package virusSimulation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class PeopleTest {
	
	People test;

	@Test
	public void testPeople() {
		test = new People("ericsson");
		assertTrue(test.getName().equals("ericsson"));
	}

	@Test
	public void testGotInfected() {
		test = new People("ericsson");
		test.gotInfected();
		assertEquals(test.isHealthy,false);
	}

	@Test
	public void testGetName() {
		test = new People("ericsson");
		assertTrue(test.getName().equals("ericsson"));
	}

	@Test
	public void testGetResistence() {
		test = new People("ericsson");
		test.setResistence(0.5);
		assertEquals(test.getResistence(),0.5,0.00);
	}

	@Test
	public void testGetSocialNetwork() {
		test = new People("ericsson");
	    assertEquals(test.getSocialNetwork().size(),0);
	}

	@Test
	public void testSetResistence() {
		test = new People("ericsson");
		test.setResistence(0.5);
		assertEquals(test.getResistence(),0.5,0.00);
	}

	@Test
	public void testSetNetwork() {
		test = new People("ericsson");
		List<People> nei = new ArrayList<>();
		nei.add(new People("2"));
		test.setNetwork(nei);
		assertEquals(test.getSocialNetwork().size(),1);
	}

	@Test
	public void testAddPeople() {
		test = new People("ericsson");
		test.addPeople(new People("2"));
		assertEquals(test.getSocialNetwork().size(),1);
		
	}

	@Test
	public void testEqualsObject() {
		People a = new People("a");
		People b = new People("a");
		assertTrue(a.equals(b));
		People c = new People("c");
		assertFalse(a.equals(c));
		assertFalse(a.equals("a"));
		assertTrue(a.equals(a));
	}
	
	
	
	@Test
	
	public void testCompareTo() {
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
		
		
		assertTrue(node1.compareTo(node2) > 0);
		
		assertTrue(node1.compareTo((Object)node2) > 0);
	}

}
