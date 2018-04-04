package com.example.arvin.weatherapp.model.Interactor;

import com.example.arvin.weatherapp.model.Interactor.WeatherInteractor;
import com.example.arvin.weatherapp.model.WeatherResponse;
import com.example.arvin.weatherapp.model.api.ApiWeatherService;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherInteractorImp implements WeatherInteractor {

    ApiWeatherService mService;

    public WeatherInteractorImp() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = retrofit.create(ApiWeatherService.class);
    }

    @Override
    public Observable<WeatherResponse> getWeatherData() {
        return mService.getWeatherData();
    }
}
