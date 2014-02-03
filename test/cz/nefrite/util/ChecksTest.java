/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.nefrite.util;

import cz.nefrite.util.checking.CheckRules;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author drozd01
 */
public class ChecksTest {
	
	public ChecksTest() {
	}

	/**
	 * Test of setCheckRules method, of class Checks.
	 */
	@Test
	public void testSetCheckRules() {
		System.out.println("setCheckRules");
		CheckRules rules = null;
		Checks.setCheckRules(rules);
	}

	/**
	 * Test of isNotNull method, of class Checks.
	 */
	@Test
	public void testIsNotNull_Object() {
		System.out.println("isNotNull:");
		Object obj = null;
		boolean expResult = false;
		boolean result = Checks.isNotNull(obj);
		assertEquals(expResult, result);
		
		obj = new String();
		expResult = true;
		result = Checks.isNotNull(obj);
		assertEquals(expResult, result);
		System.out.println("");
	}

	/**
	 * Test of isNotNull method, of class Checks.
	 */
	@Test
	public void testIsNotNull_Object_String() {
		System.out.println("isNotNull:");
		Object obj = null;
		String msg = "Object is null";
		boolean expResult = false;
		boolean result = Checks.isNotNull(obj, msg);
		assertEquals(expResult, result);
		
		obj = new String();
		expResult = true;
		result = Checks.isNotNull(obj, msg);
		assertEquals(expResult, result);
		System.out.println("");
	}

	/**
	 * Test of nullFatal method, of class Checks.
	 */
	@Test
	public void testNullFatal_Object() {
		System.out.println("nullFatal:");
		Object obj = null;
		try {
			Checks.nullFatal(obj);
			fail("No Exception throwed!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		obj = new String();
		try {
			Checks.nullFatal(obj);			
		} catch (Exception e) {
			fail("Exception! " + e.getMessage());
		}
		
		System.out.println("");
	}

	/**
	 * Test of nullFatal method, of class Checks.
	 */
	@Test
	public void testNullFatal_Object_int() {
		System.out.println("nullFatal:");
		int errorID = 1516;
		Object obj = null;
		try {
			Checks.nullFatal(obj,errorID);
			fail("No Exception throwed!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		obj = new String();
		try {
			Checks.nullFatal(obj,errorID);			
		} catch (Exception e) {
			fail("Exception! " + e.getMessage());
		}
		
		System.out.println("");
	}

	/**
	 * Test of nullFatal method, of class Checks.
	 */
	@Test
	public void testNullFatal_Object_String() {
		System.out.println("nullFatal");
		Object obj = null;
		String msg = "";
		Checks.nullFatal(obj, msg);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of isNotEmpty method, of class Checks.
	 */
	@Test
	public void testIsNotEmpty_Collection() {
		System.out.println("isNotEmpty");
		Collection c = null;
		boolean expResult = false;
		boolean result = Checks.isNotEmpty(c);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of isNotEmpty method, of class Checks.
	 */
	@Test
	public void testIsNotEmpty_Collection_String() {
		System.out.println("isNotEmpty");
		Collection c = null;
		String msg = "";
		boolean expResult = false;
		boolean result = Checks.isNotEmpty(c, msg);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of emptyFatal method, of class Checks.
	 */
	@Test
	public void testEmptyFatal_Collection() {
		System.out.println("emptyFatal");
		Collection c = null;
		Checks.emptyFatal(c);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of emptyFatal method, of class Checks.
	 */
	@Test
	public void testEmptyFatal_Collection_int() {
		System.out.println("emptyFatal");
		Collection c = null;
		int errorID = 0;
		Checks.emptyFatal(c, errorID);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of emptyFatal method, of class Checks.
	 */
	@Test
	public void testEmptyFatal_Collection_String() {
		System.out.println("emptyFatal");
		Collection c = null;
		String msg = "";
		Checks.emptyFatal(c, msg);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}
