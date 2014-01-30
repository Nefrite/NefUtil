/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.nefrite.util;

import org.junit.Test;
import static org.junit.Assert.*;
import static java.lang.Math.*;

/**
 *
 * @author Jirka Drozd
 */
public class MathsTest {
	
	public MathsTest() {
	}

	/**
	 * Test of angleToBasicRange method, of class Maths.
	 */
	@Test
	public void testAngleToBasicRange() {
		System.out.println("angleToBasicRange:");
		double testSet[] = {-2*PI, 0, 1, PI, 2*PI, 3*PI, 10*PI};
		double expRes[] = {0, 0, 1, PI, 0, 1*PI, 0};
		
		for (int i = 0; i < testSet.length; i++) {
			double angle = testSet[i];
			double expResult = expRes[i];
			double result = Maths.angleToBasicRange(angle);
			System.out.printf("%.3f -> %.3f (%.3f)\n", angle, result, expResult);
			assertEquals(expResult, result, 0.0);
		}
		
		System.out.println("");
	}
	
	@Test
	public void testGetOppositeAngle() {
		System.out.println("getOppositeAngle:");
		double testSet[] = {-2*PI, 0, 1, PI, 2*PI, 3*PI, 10*PI};
		double expRes[] = {PI, PI, PI+1, 0, PI, 0, PI};
		
		for (int i = 0; i < testSet.length; i++) {
			double angle = testSet[i];
			double expResult = expRes[i];
			double result = Maths.getOppositeAngle(angle);
			System.out.printf("%.3f -> %.3f (%.3f)\n", angle, result, expResult);
			assertEquals(expResult, result, 0.0);
		}
		
		System.out.println("");
	}
}