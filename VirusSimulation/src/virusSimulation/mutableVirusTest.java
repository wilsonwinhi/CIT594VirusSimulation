package virusSimulation;

import static org.junit.Assert.*;

import org.junit.Test;

public class mutableVirusTest {
	mutableVirus test;
	

	@Test
	public void testMutableVirus() {
		test = new mutableVirus(1,"flu");
		assertEquals(test.getProbability(),1,0.000);
	}

	@Test
	public void testSetProbability() {
		test = new mutableVirus(1,"flu");
		test.setProbability(0.5);
		assertEquals(test.getProbability(),0.5,0.000);
	}

	@Test
	public void testGetProbability() {
		test = new mutableVirus(1,"flu");
		assertEquals(test.getProbability(),1,0.000);
	}

	@Test
	public void testSetVirusName() {
		test = new mutableVirus(1,"flu");
		test.setVirusName("fluA");
		assertTrue(test.name.equals("fluA"));
	}

	@Test
	public void testMutateToStrong() {
		test = new mutableVirus(1,"flu");
		test.mutateToStrong();
		assertEquals(test.getProbability(),1,0.000);
		test.setProbability(0.4);
		test.mutateToStrong();
		assertEquals(test.getProbability(),0.9,0.000);
		
		
	}

	@Test
	public void testMutateToWeak() {
		test = new mutableVirus(1,"flu");
		test.mutateToWeak();
		assertEquals(test.getProbability(),0.5,0.000);
		test.setProbability(0.4);
		test.mutateToWeak();
		assertEquals(test.getProbability(),0,0.000);
	}

}
