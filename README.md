# Job-search-genie
Indorse coding exam

I tried to put as many documentation and notes on what I was thinking when writing the app and as honestly as I can.

## Design considerations:
1. Using REST API to query for Cities http://gd.geobytes.com/AutoCompleteCity?callback=?&q=manila (front-end operation)
	* Initially thought creating a database for this, but later changed my mind and use the online free API
1. Using REST API to query for Jobs https://jobs.github.com/positions.json?location=new+york (back-end operation)

## Some trouble encountered during development:
1. SSL - for calling the Github API
1. I know old way of doing Spring MVC (2.5 all using xml config) - just needed a quick refresher 
1. UI stuff won't display what I wanted.

# Required dependencies
I tried to minimize dependecies to make the app as small as possible.
1. Maven
1. Junit
1. Mockito
1. Spring (mvc/dependency injection)
1. Servlet API
1. JSTL
1. Jackson for JSON parsing
 
# To set up locally
1. mvn clean compile package - creates .war file in the target/ folder
1. copy the .war file to $TOMCAT_HOME/webapps/
1. http://localhost:8080

# Word document with screenshots shared in dropbox (no dropbox account required?)
https://www.dropbox.com/s/sp4nedldef75m5h/Job%20Seach%20Genie%20screenshots.docx?dl=0
