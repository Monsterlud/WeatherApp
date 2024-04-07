# WeatherApp

**WeatherApp** is a clean & simple sample app that allows the user to input a zip code and 
then get a 5-day weather forecast for that zip code. This app was created to gain a better 
understanding of the data layer of Android app architecture including RESTful calls to 
multiple APIs and the storing of data in local storage using the Room Framework.

![weatherapp_listview](images/weatherapp.png)

## Discussion of Architecture, Frameworks, and UI
This project was created using MVVM architecture. The app utilizes app, presentation(ui, ViewModel), 
and data modules that are tied together using Koin dependency injection. Remote data is handled by 
Ktor and Local storage is handled by the Room Framework. The flow of zip code to the back end and 
the resulting flow of information back to the UI is a unidirectional data flow.

The UI is simple: the user enters a zip code which is passed through the architecture to the 
RemoteDataSource, which uses that zipcode to first get the zip code's geolocation. That geolocation is 
then used to obtain a Json payload of weather forecast information from OpenWeather's 
public API.

That payload is translated into various data classes (DTOs) that are stored locally in a Room Database. 
These Database entries initiate Kotlin Flows which are collected by the presentation layer UI. The 
app uses XML Views including a RecyclerView and Adapter to present the information to the user. The
information is presented as a scrolling list of cards, each representing a forecast for every 3 hours in 
the future at that zip code for the next 5 days.
