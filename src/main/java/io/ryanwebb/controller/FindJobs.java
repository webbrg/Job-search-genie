package io.ryanwebb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.ryanwebb.model.GithubJobFinder;
import io.ryanwebb.model.JobFinder;
import io.ryanwebb.utils.InputFormatter;
import io.ryanwebb.utils.GithubInputFormatter;

@Controller
public class FindJobs
{
	/**
	 * Go to the landing page
	 * @return <b>java.lang.String</b> the JSP view
	 */
	@RequestMapping("/searchpage")
	public String jobsForm()
	{
		return "jobsquery";
	}
	
	@RequestMapping(value="/findjobsbycityquery", method=RequestMethod.POST)
	public String doPost(@RequestParam("f_elem_city") String city, Model model)
	{	
		return findJobsByCity(city, model);
	}
	
	/**
	 * Just a HTTP GET Method support
	 * @param city
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/findjobsbycityquery")
	public String doGet(@RequestParam("f_elem_city") String city, Model model)
	{	
		return findJobsByCity(city, model);
	}
	
	/**
	 * Call the github finder class to make actual call to the API
	 * 
	 * @param city
	 * @param model
	 * @return <b>java.lang.String</b> the JSP view
	 */
	public String findJobsByCity(@RequestParam("f_elem_city") String city, Model model)
	{	
		InputFormatter formatter = new GithubInputFormatter();
		
		JobFinder jFinder;
		try {
			jFinder = new GithubJobFinder();
			model.addAttribute("jobs", jFinder.findjobsByCity(formatter.formatCity(city)));
		} catch (Exception e) {
			String errMsg = "Oops!  Something went wrong with github API.  Please try again? \n" + e.getMessage();
			model.addAttribute("error", errMsg);
		}
		
		return "jobsquery";
	}
}
