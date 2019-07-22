package io.ryanwebb.model;

/**
 * Abstraction for finding jobs to easily switch depending on the API used.
 */
public interface JobFinder
{
	// Returns the string representaion of the API being called.
	// This of course depends on the API implementation being called,
	// either XML or JSON are most common.  This leaves open to the developer
	// how to implement this.
    public String findjobsByCity(String city);
    
    // Below methods are unimplemented as not required but this shows a bit of flexibility.
    public String findJobsByJobDescription(String jobDescription);
    
    public String findJobsByJobDescriptionAndCity(String jobDesc, String city);
}