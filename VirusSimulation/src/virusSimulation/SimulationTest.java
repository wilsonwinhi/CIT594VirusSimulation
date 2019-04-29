package virusSimulation;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SimulationTest {

	@Test
	public void testSimulation() {
		Simulation test = new Simulation();
		assertEquals(test.storage.size(),0);
	}

	@Test
	public void testBfs1Round() {
		Simulation test = new Simulation();
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
		test.storage.add(node1);
		assertEquals(test.bfs1Round(1),3);
		assertEquals(test.bfs1Round(1),3);
		assertEquals(test.bfs1Round(1),1);
		assertEquals(test.bfs1Round(1),0);	
	}
	
	@Test
	public void testBfs1Round2() {
		Simulation test = new Simulation();
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
		test.storage.add(node1);
		assertEquals(test.bfs1Round(0),0);
		assertEquals(test.bfs1Round(0),0);
		assertEquals(test.bfs1Round(0),0);
		assertEquals(test.bfs1Round(0),0);	
	}
	
	@Test
	public void testBfs1Round3() {
		Simulation test = new Simulation();
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
		test.storage.add(node1);
		assertEquals(test.bfs1Round(1),3);
		node1.isTreated = true;
		assertEquals(test.bfs1Round(1),3);
		assertEquals(test.bfs1Round(1),1);
		assertEquals(test.bfs1Round(1),0);
	}

}
