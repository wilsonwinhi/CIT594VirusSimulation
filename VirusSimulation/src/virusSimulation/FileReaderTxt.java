package virusSimulation;
import java.util.*;
import java.io.*;

public class FileReaderTxt {

	private String nameOfFile;

	/**
	 * This is the constructor
	 * @param nameOfFile: file of name 
	 */
	public FileReaderTxt(String nameOfFile) {
		this.nameOfFile = nameOfFile;
	}

	/**
	 * This method helps get the words list through reading the txt file
	 * @return the words arrayList
	 */
	public List<String> getAllLines() {
		List<String> lines = new ArrayList<String>();
		try {
			File wordsFile = new File(nameOfFile);
			Scanner scanner = new Scanner(wordsFile);
			// loop will close if there is no lines left
			while (scanner.hasNextLine()) {
				String word = scanner.nextLine();
				word = word.trim();
				// add each lines to the arrayList
				lines.add(word);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
