package io.ryanwebb.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServlet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.ryanwebb.exceptions.GitHubApiException;

public class GithubJobFinder extends HttpServlet implements JobFinder
{
	
	private static final long serialVersionUID = 4198256829510181771L; // Keep the compiler happy!
	private String httpsURL = "https://jobs.github.com/positions.json";
    
	@Override
    public List<GithubJobData> findjobsByCity(final String city)
    throws GitHubApiException
    {
		List<GithubJobData> retVal = null;
		httpsURL += "?location="+city;
    	try 
    	{
    		URL myUrl = new URL(this.httpsURL);
    		HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
    		InputStream is = conn.getInputStream();
    		InputStreamReader isr = new InputStreamReader(is);
    		BufferedReader br = new BufferedReader(isr);
  
    		String inputLine;
    		StringBuffer sb = new StringBuffer();
    		while ((inputLine = br.readLine()) != null) 
    		{
            	//System.out.println(inputLine);
    			sb.append(inputLine);
    		}
    		br.close();
    		// JSON string to POJO conversion
    		List<GithubJobData> jobs = new ObjectMapper().readValue(sb.toString(), new TypeReference<List<GithubJobData>>(){});
    		
    		if (jobs.size() == 0)
    		{
    			GithubJobData data = new GithubJobData();
    			data.setUrl("index.jsp");
    			data.setCompany("No job vacancies");
    			data.setDescription("");
    			jobs.add(data);
    		}
    		
    		retVal = jobs;
		} 
    	catch (MalformedURLException e) 
    	{
			e.printStackTrace();
		} 
    	catch (ProtocolException e) 
    	{
			e.printStackTrace();
		} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
			throw new GitHubApiException(e.getMessage());
		}
    	catch(Exception e)
    	{
    		throw new GitHubApiException(e.getMessage());
    	}
    	
    	return retVal;
    }

	/**
	 * Javadoc in the interface
	 * @link {@link #JobFinder#findJobsByJobDescription(String) findJobsByJobDescription} method.
	 */
	@Override
	public List<GithubJobData> findJobsByJobDescription(String jobDescription) 
	{
		throw new java.lang.UnsupportedOperationException("Not implemented!  For demonstration purposes only!");
	}

	/**
	 * Javadoc in the interface
	 * @link {@link #JobFinder#findJobsByJobDescriptionAndCity(String, String) findJobsByJobDescriptionAndCity} method.
	 */
	@Override
	public List<GithubJobData> findJobsByJobDescriptionAndCity(String jobDesc, String city) 
	{
		throw new java.lang.UnsupportedOperationException("Not implemented!  For demonstration purposes only!");
	}
	
}