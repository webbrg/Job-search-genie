package io.ryanwebb.utils;

public class GithubInputFormatter implements InputFormatter 
{

	/**
	 *  <h1>Satisfy Github API string format.</h1> 
	 *  After several testing on the github api, remove the leading and trailing spaces 
	 *  then the spaces in between words should be converted to plus symbols
	 */
	@Override
	public String formatCity(final String city) {
		String formattedCity = city.trim().replaceAll("\\s+", "+");
		return formattedCity;
	}

}
