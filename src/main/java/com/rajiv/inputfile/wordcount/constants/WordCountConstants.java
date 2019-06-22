/**
 * 
 */
package com.rajiv.inputfile.wordcount.constants;

import java.io.InputStream;

/**
 * @author Rajiv
 * 
 *         This is the Constant File
 *
 */
public interface WordCountConstants {

	final String PROPERTY_FILE_PATH = "/application.properties";

	final String FILE_PATH = "Input_File_Path";

	final String CATOGARY_ONE = "PERSON";
	final String CATOGARY_TWO = "PLACE";
	final String CATOGARY_THREE = "ANIMAL";
	final String CATOGARY_FOUR = "COMPUTER";
	final String CATOGARY_OTHER = "OTHER";

	final String LOGGER_CLASS_MESSAGE_START = "Start of main() method in Class::";
	final String LOGGER_CLASS_MESSAGE_END = "End of main() method in Class ::";
	final String LOGGER_IO_EXCEPTION_MESSAGE = "Give Input File is Not Corect :: Please Provide the Valid Input File ::";

	final String LOGGER_METHOD_MESSAGE_START = "Start of printOutput() method in Class::";
	final String LOGGER_METHOD_MESSAGE_END = "Ends of printOutput() method in Class::";
	
	final String LOGGER_INPUT_METHOD_MESSAGE_START = "Start of getInputFile(InputStream input, String args) method in Class::";
	final String LOGGER_INPUT_METHOD_MESSAGE_END = "Ends of getInputFile(InputStream input, String args) method in Class::";


	final String CATOGARY = "Category";
	final String TAB_SYMBOL = "\t";
	final String COUNT = "Count";

	final String NEW_LINE = "\n";
	final String SPACE_CHAR = "   ";

	final String LOGGER_FILENOTFOUND_EXCEPTION_MESSAGE = "Please Provide the Correct input text file Name ::";

}
