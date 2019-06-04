# Locations
Demo Project to explore Fouresquare palces API

In this project created a REST End point </br>
<pre>http://localhost:8080/api/searchVenues?near=Pune india&intent=browse&radius=10000&limit=10&query=KFC</pre>
and consumed bwlow two APIs to Search a Venue and it's related information<br/>
https://developer.foursquare.com/docs/api/venues/search </br>
https://developer.foursquare.com/docs/api/venues/details

# Spring Boot
Created this project using Spring Boot 2.1.5 https://spring.io/projects/spring-boot. </br>
Spring Boot Reference Guide https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/reference/htmlsingle/

# Foursquare API
Used Foursquare Places API to Search location and fetch Location information
https://developer.foursquare.com/places-api

## Build the project
To build the application run:
mvnw clean package

## Run
Run the application with the following command:
<pre> mvn spring-boot:run </pre>  OR 
<pre> java -jar target/Locations-0.0.1-SNAPSHOT.war </pre> 
## Testing
To launch your application's tests, run:
<pre> mvnw clean test </pre>
