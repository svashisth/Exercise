package com.prob;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.AssertionFailedError;

import org.junit.Test;

import com.prob.ProbOne.Pair;

public class ProbOneTest {

	@Test
	public void testPrintPairs() {
		Map actual = ProbOne.printPairs(new int[] {});
		Map expected = new HashMap<Integer, List<Pair>>();
		assertEquals(expected, actual);
		
		actual = ProbOne.printPairs(new int[] {3,7,1,2,9});
		expected = new HashMap<Integer, List<Pair>>();
		List list = new ArrayList<Pair>();
		list.add(new Pair(0,1));
		list.add(new Pair(2,4));
		expected.put(10, list);
		if(! actual.containsKey(10))
			throw new AssertionFailedError();
		if(! (actual.get(10) instanceof List))
			throw new AssertionFailedError();
		assertEquals(expected.get(10), actual.get(10));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetIntegerArr() {
		ProbOne.getIntegerArr(new String[] {});
	}
	
	@Test(expected=NumberFormatException.class)
	public void testGetIntegerArr1() {
		ProbOne.getIntegerArr(new String[] {"4","23","12","9","4q","8"});
	}
	
	@Test
	public void testGetIntegerArr2() {
		int[] integerArr = ProbOne.getIntegerArr(new String[] {"4","23","12","9","4","8"});
		assertArrayEquals(new int[] {4,23,12,9,4,8}, integerArr);
	}

}
