package hangman;
import java.util.*;
import java.io.*;
import java.util.*;

public class FileReaderTxt {

	private String nameOfFile;

	/**
	 * This is the constructor
	 * @param nameOfFile
	 */
	public FileReaderTxt(String nameOfFile) {
		this.nameOfFile = nameOfFile;
	}

	/**
	 * This method helps get the words list through reading the txt file
	 * @return the words arrayList
	 */
	public ArrayList<String> getAllLines() {
		ArrayList<String> lines = new ArrayList<String>();
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
	
//	public static void main(String[] args) {
//		FileReaderTxt test = new FileReaderTxt("Document.txt");
//		ArrayList<String> answer = test.getAllLines();
//		for(String each: answer) {
//			String[] array = each.split("\\s+");
//			System.out.println(array[0]);
//		}
//	}
}
