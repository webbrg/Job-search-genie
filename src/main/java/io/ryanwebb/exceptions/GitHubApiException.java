package io.ryanwebb.exceptions;

public class GitHubApiException extends RuntimeException {

	private static final long serialVersionUID = 4807316022502345229L; // Keep the compiler happy

	public GitHubApiException(String errMsg)
	{
		super(errMsg);
	}
}
