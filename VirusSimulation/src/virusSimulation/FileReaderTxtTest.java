package hangman;

import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class FileReaderTxtTest {

	@Test
	public void testFileReaderTxt() {
		FileReaderTxt testFileReader = new FileReaderTxt("short_list.txt");
		ArrayList<String> lines = testFileReader.getAllLines();
		String[] testLines = lines.toArray(new String[lines.size()]);
		String expected = "coil";
		String actual = testLines[0];
		assertEquals("first element should be 'coil'", expected, actual);
	}

	@Test
	public void testGetAllLines() {
		FileReaderTxt testFile = new FileReaderTxt("short_list.txt");
		ArrayList<String> lines = testFile.getAllLines();
		String[] testLines = lines.toArray(new String[lines.size()]);
		String expected = "coil";
		String actual = testLines[0];
		assertEquals("first element should be 'coil'", expected, actual);
		String expected2 = "record";
		String actual2 = testLines[testLines.length - 1];
		assertEquals("last element should be 'record'", expected2, actual2);
		String expected3 = "inexpensive";
		String actual3 = testLines[1];
		assertEquals("second element should be 'jump'", expected3, actual3);
	}

}
