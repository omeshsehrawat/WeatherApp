package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText cityInput;
    private TextView temperatureText, weatherDescriptionText;
    private ImageView weatherImage;

    private final String API_KEY = "5289e6cffe10fd6f08ed20a1d7cd49db"; // Replace this with your OpenWeatherMap API key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityInput = findViewById(R.id.cityInput);
        temperatureText = findViewById(R.id.temperatureText);
        weatherDescriptionText = findViewById(R.id.weatherDescriptionText);
        weatherImage = findViewById(R.id.weatherImage);
        Button fetchButton = findViewById(R.id.fetchButton);

        fetchButton.setOnClickListener(v -> {
            String city = cityInput.getText().toString();
            if (!city.isEmpty()) {
                getWeather(city);
            } else {
                Toast.makeText(this, "Please enter a city name", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getWeather(String city) {
        new Thread(() -> {
            try {
                String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" +
                        city + "&appid=" + API_KEY + "&units=metric";
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                JSONObject jsonObject = new JSONObject(result.toString());
                String temp = jsonObject.getJSONObject("main").getString("temp");
                String description = jsonObject.getJSONArray("weather")
                        .getJSONObject(0).getString("description").toLowerCase();

                String cityName = jsonObject.getString("name");  // Extract city name

                runOnUiThread(() -> {
                    temperatureText.setText("City: " + cityName + "\nTemperature: " + temp + "°C");
                    weatherDescriptionText.setText("Condition: " + description);

                    if (description.contains("rain")) {
                        weatherImage.setImageResource(R.drawable.rainy);
                    } else if (description.contains("cloud")) {
                        weatherImage.setImageResource(R.drawable.cloudy);
                    } else if (description.contains("clear")) {
                        weatherImage.setImageResource(R.drawable.sunny);
                    } else if (description.contains("storm")) {
                        weatherImage.setImageResource(R.drawable.storm);
                    } else {
                        weatherImage.setImageResource(R.drawable.sunny); // default
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() -> {
                    temperatureText.setText("Error");
                    weatherDescriptionText.setText("Could not fetch data.");
                    weatherImage.setImageResource(R.drawable.error);
                });
            }
        }).start();
    }
}
