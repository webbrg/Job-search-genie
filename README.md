# Job-search-genie
Indorse coding exam

I tried to put as many documentation and notes on what I was thinking when writing the app.

###Design considerations:
1. Using REST API to query for Cities http://gd.geobytes.com/AutoCompleteCity?callback=?&q=manila (front-end operation)
	* Initially thought creating a database for this, but later changed my mind and use the online free API
1. Using REST API to query for Jobs https://jobs.github.com/positions.json?location=new+york (back-end operation)

###Some trouble encountered:
1. SSL - for calling the Github API
1. I know old way of doing Spring MVC (2.5 all using xml config) - just needed a quick refresher 
