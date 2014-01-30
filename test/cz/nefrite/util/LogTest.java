/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.nefrite.util;

import cz.nefrite.util.logging.LogLevel;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test logovacího systému
 * @author Jirka Drozd
 */
public class LogTest {

	public LogTest() {
		Log.setLogLevel(Log.DEBUG);
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of debug method, of class Log.
	 */
	@Test
	public void testDebug() {
	}

	/**
	 * Test of debug method, of class Log.
	 */
	@Test
	public void testDebug_String() {
		String msg = "Debug message logged";
		Log.debug(msg);
	}

	/**
	 * Test of debug method, of class Log.
	 */
	@Test
	public void testDebug_Object() {
		Object o = new Object();
		Log.debug(o);
	}

	/**
	 * Test of info method, of class Log.
	 */
	@Test
	public void testInfo() {
		String msg = "Info message logged";
		Log.info(msg);
	}

	/**
	 * Test of warn method, of class Log.
	 */
	@Test
	public void testWarn_String() {
		String msg = "Warning logged";
		Log.warn(msg);
	}

	/**
	 * Test of warn method, of class Log.
	 */
	@Test
	public void testWarn_String_Exception() {
		String msg = "Error logged";
		Exception e = new IllegalStateException("Warning Exception!");
		Log.warn(msg, e);
	}

	/**
	 * Test of error method, of class Log.
	 */
	@Test
	public void testError_String() {
		String msg = "Error logged";
		Log.error(msg);
	}

	/**
	 * Test of error method, of class Log.
	 */
	@Test
	public void testError_Exception() {
		Exception e = new Exception("Error Exception!");
		Log.error(e);
	}

	/**
	 * Test of error method, of class Log.
	 */
	@Test
	public void testError_String_Exception() {
		String msg = "Error logged";
		Exception e = new Exception("Error Exception!");
		Log.error(msg, e);
	}

	/**
	 * Test of setLogSystem method, of class Log.
	 */
	@Test
	public void testSetLogSystem() {
		try {
			Log.setLogSystem(null);
			fail("Should throw IllegalArgumentException!");
		} catch (IllegalArgumentException e) {
			assert true;
		}
	}

	/**
	 * Test of setLogLevel method, of class Log.
	 */
	@Test
	public void testSetLogLevel_LogLevel() {
		try {
			// Log.setLogLevel(null); // - nepovoli prekladac :)
			LogLevel o = null;
			Log.setLogLevel(o);
			fail("Should throw IllegalArgumentException!");
		} catch (IllegalArgumentException e) {
			assert true;
		}
	}

	/**
	 * Test of setLogLevel method, of class Log.
	 */
	@Test
	public void testSetLogLevel_String() {
		System.out.println("setLogLevel(String):");
		try {
			Log.setLogLevel("X");	// Ocekava se nastaveni levelu WARNINGS
			Log.debug("DEBUG");
			Log.info("INFO");
			Log.warn("WARNING");
			Log.error("ERROR");
		} catch (Exception e) {
			fail("Unexpected Exception!");
		}
		assert true;
		System.out.println("");
	}
}
