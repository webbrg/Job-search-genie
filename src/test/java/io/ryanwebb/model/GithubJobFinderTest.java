package io.ryanwebb.model;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GithubJobFinderTest {

	
	// Negative test - trying to break with passing empty string
	@Test
	public void testEmptyString_FindJobsByCity()
	{
		GithubJobFinder finder = new GithubJobFinder();
		try 
		{
			String retVal = finder.findjobsByCity("");
			List<GithubJobData> unfilteredJobs = new ObjectMapper().readValue(retVal, new TypeReference<List<GithubJobData>>(){});
			
			Set<String> locations = new HashSet<String>();
			for (GithubJobData data : unfilteredJobs)
			{
				locations.add(data.getLocation());
			}
			
			assertNotEquals(1, locations.size());
		} 
		catch (JsonParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (JsonMappingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Positive test - normal operation
	@Test
	public void test_FindJobsByCity() 
	{
		GithubJobFinder finder = new GithubJobFinder();
		try {
			String retVal = finder.findjobsByCity("new+york"); // based on github all spaces are converted to '+' symbol
			List<GithubJobData> unfilteredJobs = new ObjectMapper().readValue(retVal, new TypeReference<List<GithubJobData>>(){});
			
			List<String> locations = new ArrayList<String>();
			for (GithubJobData data : unfilteredJobs)
			{
				// It's unknown to me how Github returns non-new york cities,
				// we'll just weigh if the majority is new york (Manhattan, Jersey City, etc)
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
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
