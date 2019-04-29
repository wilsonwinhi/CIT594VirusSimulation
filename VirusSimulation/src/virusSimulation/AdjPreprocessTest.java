package virusSimulation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

public class AdjPreprocessTest {

	AdjPreprocess test = new AdjPreprocess();
	
	@Test
	public void testAdjPreprocess() {
		List<String> edges = new ArrayList<>();
		edges.add("1 2");
		edges.add("1  3");
		edges.add("2   3");
		edges.add("2    4");
		List<People> answer = test.adjPreprocess(edges);
		assertEquals(answer.size(),4);
		assertTrue(answer.get(0).getName().equals("1"));
		assertTrue(answer.get(1).getName().equals("2"));
		assertEquals(answer.get(1).getSocialNetwork().size(),2);
		String a1 = answer.get(1).getSocialNetwork().get(0).getName();
		assertTrue(a1.equals("3"));
		String a2 = answer.get(1).getSocialNetwork().get(1).getName();
		assertTrue(a2.equals("4"));
	}


	@Test
	public void testGetTotalPeople() {
		List<String> edges = new ArrayList<>();
		edges.add("1 2");
		edges.add("1  3");
		List<People> answer = test.adjPreprocess(edges);
		assertEquals(test.getTotalPeople(),3);
		assertTrue(answer.get(0).getName().equals("1"));
	}

}
