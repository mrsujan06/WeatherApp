package com.example.arvin.weatherapp.model.api;

import com.example.arvin.weatherapp.model.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiWeatherService {

    @GET("data/2.5/forecast?id=2643743&APPID=6436d3681ea4be573a8f17db2e4ce9da")
    Observable<WeatherResponse> getWeatherData();
}
