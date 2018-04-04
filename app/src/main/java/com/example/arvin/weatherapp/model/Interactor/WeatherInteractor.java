package com.example.arvin.weatherapp.model.Interactor;

import com.example.arvin.weatherapp.model.WeatherResponse;

import io.reactivex.Observable;

public interface WeatherInteractor {
    Observable<WeatherResponse> getWeatherData();
}
