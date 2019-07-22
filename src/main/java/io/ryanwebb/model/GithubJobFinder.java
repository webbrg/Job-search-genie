package io.ryanwebb.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServlet;

public class GithubJobFinder extends HttpServlet implements JobFinder
{
	
	private static final long serialVersionUID = 4198256829510181771L; // Keep the compiler happy!
	private String httpsURL = "https://jobs.github.com/positions.json";
    
	@Override
    public String findjobsByCity(final String city)
    {
		String retVal = null;
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
    		
    		retVal = sb.toString();
    		br.close();
		} 
    	catch (MalformedURLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return retVal;
    }

	/**
	 * Javadoc in the interface
	 * @link {@link #JobFinder#findJobsByJobDescription(String) findJobsByJobDescription} method.
	 */
	@Override
	public String findJobsByJobDescription(String jobDescription) 
	{
		throw new java.lang.UnsupportedOperationException("Not implemented!  For demonstration purposes only!");
	}

	/**
	 * Javadoc in the interface
	 * @link {@link #JobFinder#findJobsByJobDescriptionAndCity(String, String) findJobsByJobDescriptionAndCity} method.
	 */
	@Override
	public String findJobsByJobDescriptionAndCity(String jobDesc, String city) 
	{
		throw new java.lang.UnsupportedOperationException("Not implemented!  For demonstration purposes only!");
	}
	
//	public static void main(String[] args) throws Exception{
//		String retVal = new GithubJobFinder().findjobsByCity(null);
//		List<GithubJobData> unfilteredJobs = new ObjectMapper().readValue(retVal, new TypeReference<List<GithubJobData>>(){});
//		System.out.println("retVal : " + retVal);
//		System.out.println(unfilteredJobs.size());
//		for (GithubJobData data : unfilteredJobs)
//		{	
//			System.out.println("Title:" + data.getTitle());
//			System.out.println("Location:" + data.getLocation());
//			// just check the first one!
//			//break;
//		}
//	}
}