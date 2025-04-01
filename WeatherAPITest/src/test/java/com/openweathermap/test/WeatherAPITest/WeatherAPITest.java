package com.openweathermap.test.WeatherAPITest;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class WeatherAPITest {

	 
    private static final String API_KEY = "2b4b234057fe53a95838f1c2b4b14ded";  // Your API Key
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    @Test
    public void validateWeatherForCoordinates() {
    	
    	RestAssured.useRelaxedHTTPSValidation();
    	 
        Response response =
            given()
                .queryParam("lat", "44.34")  
                .queryParam("lon", "10.99")  
                .queryParam("appid", API_KEY)  
            .when()
                .get(BASE_URL)  
            .then()
                .statusCode(200)  
                .body("name", notNullValue())  
                .body("main.temp", notNullValue())  
                .body("weather[0].description", notNullValue())  
                .body("main.humidity", greaterThan(0)) 
                .body("wind.speed", greaterThan(0f))  
                .body("sys.country", notNullValue())  
                .extract().response();

        // Print API response for debugging
        System.out.println("API Response: " + response.asPrettyString());
    }
}
