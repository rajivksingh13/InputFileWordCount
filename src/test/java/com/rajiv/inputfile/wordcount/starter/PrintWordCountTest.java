/**
 * 
 */
package com.rajiv.inputfile.wordcount.starter;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.rajiv.inputfile.wordcount.constants.WordCountConstants;

/**
 * @author Rajiv
 *
 */
public class PrintWordCountTest {

	/**
	 * Test method for
	 * {@link com.rajiv.inputfile.wordcount.starter.PrintWordCount#printOutput(java.lang.String)}.
	 */
	@Rule
	public ExpectedException exception = ExpectedException.none();

	private BufferedReader in = null;
	StringBuilder sb = new StringBuilder();
	PrintWordCount pwc;
	WordCountConstants wcc;

	@Before
	public void setup() throws IOException {
		in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/input.txt")));

		pwc = new PrintWordCount();
	}

	@After
	public void teardown() throws IOException {
		if (in != null) {
			in.close();
		}

		in = null;
	}

	@SuppressWarnings("static-access")
	@Test
	public void testPrintOutput() throws IOException {
		String line = null;
		line = in.readLine();
		sb.append(line);
		sb.append(System.lineSeparator());
		assert (line.length() > 0);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testgetInputFile() throws IOException {
		InputStream input = InputFileWordCount.class.getResourceAsStream(wcc.PROPERTY_FILE_PATH);
		//exception.expect(IOException.class);
		//exception.expectMessage("Empty File Name Not Allowed");
		String fileName = "input.txt";
		pwc.getInputFile(input, fileName);

	}

	@Test
	public void testWordCountConstant() throws IOException {
		assert ("PERSON".equals(wcc.CATOGARY_ONE));
		assert ("PLACE".equals(wcc.CATOGARY_TWO));
		assert ("ANIMAL".equals(wcc.CATOGARY_THREE));
		assert ("COMPUTER".equals(wcc.CATOGARY_FOUR));
		assert ("OTHER".equals(wcc.CATOGARY_OTHER));
	}

}
