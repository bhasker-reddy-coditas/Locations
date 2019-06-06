# Locations
Demo Project to explore Fouresquare palces API

In this project created a REST End point which allows a user to search for a location and fetches all the location related information like Photos, Tips etc.</br>
Consumed below two APIs to Search a Venue and it's related information<br/>
<pre>https://developer.foursquare.com/docs/api/venues/search </br>
https://developer.foursquare.com/docs/api/venues/details </pre>

* **URL**

    http://localhost:8080/api/searchVenues
* **Method:**

    GET
* **URL Params:**
 
   `query` : *Required* A search term to be applied against venue names.<br />
   `near`  : Required unless <b> ll </b>is provided. A string naming a place in the world.<br />
   `ll`    : Required unless <b>near</b> is provided. Latitude and longitude of the user’s location.<br />
   `radius`: Limit results to venues within this many meters of the specified location.<br />
   `intent`: One of the <b>checkin, global, browse, match </b> values, indicating your intent in performing the search.<br />
   `limit` : Number of results to return, up to 50.<br />
   `filter`: Filter query to filter the venue returned in API response<br />
  
* **Sample URL:**  
    <pre>http://localhost:8080/api/searchVenues?query=KFC&near=Pune india&radius=10000&intent=browse&limit=10&filter=BBQ</pre>
    
* **Success Response:**
 * **Code:** 200 <br />
    **Content:** 
    ```json
    {
        "meta": {
        "code": 200,
        "requestId": "5cf884f51ed21914c0aaf2f0"
      },
      "response": {
        "venues": [
          {
            "id": "509cea7fe4b064bf6bb2cc2c",
            "name": "KFC Restaureat",
            "location": {},
            "categories": {},
            "venueDetails": {}
          }
        ]
      }
    }  
## Prerequisites
Softwares needs to be installed
  - Java 1.8
  - Apache Maven-3.5.3
  
## Libraries Used
  - Apache HttpClient » 4.5.8
  http://hc.apache.org/
  
  Apache HttpComponents Client library is used to invoke the Foursquare Places API from the custom end point.

## Spring Boot
Created this project using Spring Boot 2.1.5 https://spring.io/projects/spring-boot. </br>
Spring Boot Reference Guide https://docs.spring.io/spring-boot/docs/2.1.5.RELEASE/reference/htmlsingle/

## Foursquare API
Used Foursquare Places API to Search location and fetch location information
https://developer.foursquare.com/places-api

## Build the project
To build the application run:
<pre> mvnw clean package </pre>

## Run
Run the application with the following command:
<pre> mvn spring-boot:run </pre>  OR 
<pre> java -jar target/Locations-0.0.1-SNAPSHOT.war </pre> 
## Testing
To launch your application's tests, run:
<pre> mvnw clean test </pre>
