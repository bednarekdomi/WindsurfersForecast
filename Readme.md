![github](https://user-images.githubusercontent.com/40741056/74937413-4304d980-53ec-11ea-8010-58655042feb5.jpg)

# About

##### REST API  microservice application uses Spring Boot and external weather API https://www.weatherbit.io/api/weather-forecast-16-day

* getting best location for windsurfing depending on weather conditions


## Technologies

* Java
* Spring Boot
* REST API
* Lombok
* Gradle

____________________________________________________________________________________________________________
####  Get_Location_With_Best_Conditions
##### Getting best location for windsurfing depending on weather conditions
* GET
* Example Request:
````
http://localhost:8080/WeatherApp/getLocationWithBestConditions?date=2023-02-28
````           
* Example JSON Body:
````	
{
    "city_name": "BRIDGERTOWN",
    "data": [
        {
            "datetime": "2023-02-28",
            "temp": 25.2,
            "wind_spd": 6.7,
            "bestScore": 45.3
        }
    ]
}
````