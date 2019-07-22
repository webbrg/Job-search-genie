package io.ryanwebb.model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import io.ryanwebb.exceptions.GitHubApiException;

public class GithubJobFinderTest
{

	/* I was originally planning to mock the json returned by the github API, so I won't have to 
	 * wait for a long time.  But after testing it wasn't that bad every time I test.
	 * I later decided to test with real data returned from the github API.
	 */
	
	// Negative test - trying to break with passing empty string
	@Test
	public void testEmptyString_FindJobsByCity()
	{
		GithubJobFinder finder = new GithubJobFinder();
		List<GithubJobData> unfilteredJobs = finder.findjobsByCity("");
		
		Set<String> locations = new HashSet<String>();
		for (GithubJobData data : unfilteredJobs)
		{
			locations.add(data.getLocation());
		}
		
		assertNotEquals(1, locations.size());
		
	}
	
	@Test(expected = GitHubApiException.class)
	public void testException_FindJobsByCity()
	{
		GithubJobFinder finder = mock(GithubJobFinder.class);
		when(finder.findjobsByCity("asdfa"))
			.thenThrow(new GitHubApiException("503 exception occured"));
		
		finder.findjobsByCity("asdfa");
	}
	
	// Positive test - normal operation
	@Test
	public void test_FindJobsByCity() 
	{
		GithubJobFinder finder = new GithubJobFinder();
		List<GithubJobData> unfilteredJobs = finder.findjobsByCity("new+york"); // based on github all spaces are converted to '+' symbol
		
		List<String> locations = new ArrayList<String>();
		for (GithubJobData data : unfilteredJobs)
		{
			// It's unknown to me how Github returns non-new york cities,
			// we'll just weigh if the majority is of location is in New York (Manhattan, Jersey City, etc)
			locations.add(data.getLocation());
		}
		
		int locationCount = 0;
		for (String location : locations)
		{
			if (location.contains("New York") || location.contains("NY") || location.contains("Jersey"))
			{
				locationCount += 1;
			}
		}
		
		assertTrue(locationCount > (locations.size() - locationCount));
			
	}
	
	// Positive test - normal operation
	@Test
	public void testNoResults_FindJobsByCity() 
	{
		GithubJobFinder finder = new GithubJobFinder();
		List<GithubJobData> unfilteredJobs = finder.findjobsByCity("asdfasdf"); // based on github all spaces are converted to '+' symbol
		
		assertEquals("No job vacancies", unfilteredJobs.get(0).getCompany());
	}

}
