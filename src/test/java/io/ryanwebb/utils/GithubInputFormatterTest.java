package io.ryanwebb.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GithubInputFormatterTest
{

	@Test
	public void test_formatCity()
	{
		String city = "Austin, TX, United States";
		GithubInputFormatter formatter = new GithubInputFormatter();
		assertEquals("Austin,+TX,+United+States", formatter.formatCity(city));
	}
	
	@Test
	public void testTrailingLeadingSpace_formatCity()
	{
		String city = " Austin, TX, United States   ";
		GithubInputFormatter formatter = new GithubInputFormatter();
		assertEquals("Austin,+TX,+United+States", formatter.formatCity(city));
	}
}
