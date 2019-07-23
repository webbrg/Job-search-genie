package io.ryanwebb.utils;

/**
 * Base for formatter, depending on the programmer on how to implement.
 */
public interface InputFormatter 
{

	/**
	 * Format city string before sending to the API
	 * @param city
	 * @return formatted string result
	 */
	public String formatCity(final String city);

}
