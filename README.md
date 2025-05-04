# Weather App

A simple Android weather app that allows users to check the weather conditions for a given city. The app fetches weather data from the OpenWeatherMap API and displays the temperature, weather condition, and an appropriate weather icon.

## Features

- **City Search**: Enter the city name to fetch weather details.
- **Weather Data**: Displays the temperature and weather condition (e.g., clear, rainy, cloudy).
- **Icons**: Shows relevant weather icons based on the current condition.
- **Error Handling**: Displays an error message if the city is not found or if there's an issue with the API.

## Screenshots

<img src="https://github.com/user-attachments/assets/faaec2ba-3dbe-43cd-a4aa-e2a9f1964a6f" width="200" />
<img src="https://github.com/user-attachments/assets/21d4d3b8-4cdd-4dc4-b246-ceaca04c3616" width="200" />
<img src="https://github.com/user-attachments/assets/aa4b2258-c2f8-419c-8b52-c610facef060" width="200" />
<img src="https://github.com/user-attachments/assets/6bf85a70-1b9f-4101-999c-dda8028b5d40" width="200" />



## Requirements

- **Android Studio**: To build and run the app.
- **OpenWeatherMap API Key**: You'll need to create an account at [OpenWeatherMap](https://openweathermap.org/) and get an API key to access weather data.
- **Internet Connection**: The app fetches data from the OpenWeatherMap API, so you need an active internet connection.

## Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/yourusername/weather-app.git
cd weather-app
```

### 2. Open the project in Android Studio
- Open Android Studio and choose Open an existing Android Studio project.

- Navigate to the cloned project directory and select the project.

### 3. Add your OpenWeatherMap API key
In MainActivity.java, replace the placeholder API key with your own key:

```
private final String API_KEY = "YOUR_OPENWEATHERMAP_API_KEY"; // Replace this with your OpenWeatherMap API key
```

### 4. Run the app
- Connect your Android device or use an emulator.

- Click the Run button in Android Studio.

## How it Works
 1. The user inputs a city name in the EditText field.

 2. The user clicks the Get Weather button to fetch the weather information.

 3. The app makes an HTTP GET request to the OpenWeatherMap API.

 4. It processes the response and updates the UI with the temperature, weather condition, and a weather icon.

 5. In case of an error, it displays an error message.

## Code Structure
**MainActivity.java:** Contains the main logic for fetching weather data from the API and updating the UI.

**activity_main.xml:** Layout file for the user interface, consisting of input fields, a button, and a card view to display the weather details.

**drawable folder:** Contains weather icons (sunny, rainy, cloudy, storm, error).
