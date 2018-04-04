package com.example.arvin.weatherapp.view;

import com.example.arvin.weatherapp.model.City;
import com.example.arvin.weatherapp.model.Weather;
import com.example.arvin.weatherapp.model.WeatherResponse;

import java.util.List;

public interface WeatherView {
    void updateUi(WeatherResponse response);
}
