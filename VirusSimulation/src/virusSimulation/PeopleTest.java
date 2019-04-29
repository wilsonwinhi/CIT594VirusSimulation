package virusSimulation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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

}
