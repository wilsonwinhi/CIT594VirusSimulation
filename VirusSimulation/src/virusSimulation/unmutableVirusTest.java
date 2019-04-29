package virusSimulation;

import static org.junit.Assert.*;

import org.junit.Test;

public class unmutableVirusTest {

	unmutableVirus test;
	
	@Test
	public void testUnmutableVirus() {
		test = new unmutableVirus(1,"flu");
		assertEquals(test.getProbability(),1,0.000);
	}

	@Test
	public void testSetProbability() {
		test = new unmutableVirus(1,"flu");
		test.setProbability(0.5);
		assertEquals(test.getProbability(),0.5,0.000);
	}

	@Test
	public void testGetProbability() {
		test = new unmutableVirus(1,"flu");
		assertEquals(test.getProbability(),1,0.000);
	}

	@Test
	public void testSetVirusName() {
		test = new unmutableVirus(1,"flu");
		test.setVirusName("fluA");
		assertTrue(test.name.equals("fluA"));
	}

}
