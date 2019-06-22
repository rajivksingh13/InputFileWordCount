/**
 * 
 */
package com.rajiv.inputfile.wordcount.starter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.rajiv.inputfile.wordcount.constants.WordCountConstants;
import com.rajiv.inputfile.wordcount.starter.model.Category;

/**
 * @author Rajiv
 * 
 *         This class will print the word count based from the Input text file
 */
public class PrintWordCount {

	private static Logger logger = Logger.getLogger(PrintWordCount.class);
	static Properties prop = new Properties();

	public static void getInputFile(InputStream input, String args) {
		
		logger.info(WordCountConstants.LOGGER_INPUT_METHOD_MESSAGE_START+ PrintWordCount.class.getName());

		try {
			prop.load(input);
			String inputFilePth;
			inputFilePth = prop.getProperty(WordCountConstants.FILE_PATH);
			Path path = Paths.get(inputFilePth + args);
			String fileName = path.toString();

			PrintWordCount.printOutput(fileName);

		} catch (IOException ioe) {

			ioe.printStackTrace();
			logger.error(WordCountConstants.LOGGER_IO_EXCEPTION_MESSAGE + ioe.getMessage());
		}
		logger.info(WordCountConstants.LOGGER_INPUT_METHOD_MESSAGE_END + PrintWordCount.class.getName());
	}

	public static void printOutput(String fileName) {

		logger.info(WordCountConstants.LOGGER_METHOD_MESSAGE_START + PrintWordCount.class.getName());
		String category = null;
		// Created a String Array of Legal Categories
		String[] legalCategory = { WordCountConstants.CATOGARY_ONE, WordCountConstants.CATOGARY_TWO,
				WordCountConstants.CATOGARY_THREE, WordCountConstants.CATOGARY_FOUR,
				WordCountConstants.CATOGARY_OTHER };
		List<Category> categoryList = new ArrayList<>();
		boolean keyFound = false;

		// Reading of input text file using BufferedReader object
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			StringBuilder sb = new StringBuilder();
			String line = null;

			line = br.readLine();
			sb.append(line);
			sb.append(System.lineSeparator());

			// Null Check for BufferedReader line
			while (line != null) {
				StringTokenizer st = new StringTokenizer(line);
				keyFound = false;
				for (Category indCategory : categoryList) {
					if (indCategory.getCategoryKey().equalsIgnoreCase(line))
						keyFound = true;
				}
				// Check for Legal Categories and Sub-Categories
				while (st.hasMoreElements()) {
					category = st.nextToken();
					for (String element : legalCategory) {
						if (category.equalsIgnoreCase(element)) {
							if (!keyFound) {
								categoryList.add(
										new Category(line, category, line.substring(category.length(), line.length())));
								break;
							}
						}
					}

				}
				line = br.readLine();
			}

			int occurrences = 0;
			System.out.println(WordCountConstants.CATOGARY + WordCountConstants.TAB_SYMBOL + WordCountConstants.COUNT);
			logger.info(WordCountConstants.CATOGARY + WordCountConstants.TAB_SYMBOL + WordCountConstants.COUNT);

			// Calculate and Print the Occurrences of Legal Categories
			for (String categoryItem : legalCategory) {
				occurrences = 0;
				for (Category indCategory : categoryList) {
					if (categoryItem.equalsIgnoreCase(indCategory.getCategoryItem()))
						occurrences += 1;
				}
				System.out.println(categoryItem + WordCountConstants.TAB_SYMBOL + occurrences);
				logger.info(categoryItem + WordCountConstants.TAB_SYMBOL + occurrences);
			}

			System.out.println(WordCountConstants.NEW_LINE);
			logger.info(WordCountConstants.NEW_LINE);

			// Print the Categories and Sub Categories
			for (Category indCategory : categoryList) {
				System.out.println(indCategory.getCategoryItem() + WordCountConstants.SPACE_CHAR
						+ indCategory.getCategorySubItem());
				logger.info(indCategory.getCategoryItem() + WordCountConstants.SPACE_CHAR
						+ indCategory.getCategorySubItem());
			}

		} catch (FileNotFoundException fnex) {
			fnex.printStackTrace();
			logger.error(WordCountConstants.LOGGER_FILENOTFOUND_EXCEPTION_MESSAGE + fnex.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		logger.info(WordCountConstants.LOGGER_METHOD_MESSAGE_END + PrintWordCount.class.getName());
	}
}
