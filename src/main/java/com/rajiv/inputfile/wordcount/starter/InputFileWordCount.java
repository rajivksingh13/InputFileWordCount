/**
 * 
 */
package com.rajiv.inputfile.wordcount.starter;

import java.io.InputStream;
import org.apache.log4j.Logger;
import com.rajiv.inputfile.wordcount.constants.WordCountConstants;

/**
 * @author Rajiv
 * 
 *         This Class is the Starter for the Word Count Functionalities for the
 *         Application
 */
public class InputFileWordCount {

	/**
	 * @param args main() method will take the text file name as input argument i.e.
	 *             input.txt
	 */
	private static Logger logger = Logger.getLogger(InputFileWordCount.class);

	public static void main(String[] args) {

		if (logger.isDebugEnabled())
			logger.info(WordCountConstants.LOGGER_CLASS_MESSAGE_START + InputFileWordCount.class.getName());

		InputStream input = InputFileWordCount.class.getResourceAsStream(WordCountConstants.PROPERTY_FILE_PATH);

		PrintWordCount.getInputFile(input, args[0]);

		logger.info(WordCountConstants.LOGGER_CLASS_MESSAGE_END + InputFileWordCount.class.getName());

	}

}
