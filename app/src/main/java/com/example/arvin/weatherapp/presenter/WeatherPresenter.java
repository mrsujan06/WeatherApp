package com.example.arvin.weatherapp.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.arvin.weatherapp.model.Interactor.WeatherInteractor;
import com.example.arvin.weatherapp.model.List;
import com.example.arvin.weatherapp.model.Weather;
import com.example.arvin.weatherapp.model.WeatherResponse;
import com.example.arvin.weatherapp.view.WeatherView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class WeatherPresenter {

    WeatherView view;
    WeatherInteractor mWeatherInteractor;
    Context mContext;

    public WeatherPresenter(WeatherInteractor mWeatherInteractor, Context mContext) {
        this.mWeatherInteractor = mWeatherInteractor;
        this.mContext = mContext;
    }

    public void bind(WeatherView view) {
        this.view = view;
    }

    public void unbind() {
        view = null;
    }

    @SuppressLint("CheckResult")
    public void networkCall() {

        mWeatherInteractor.getWeatherData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherResponse>() {

                    @Override
                    public void accept(WeatherResponse weatherResponse) throws Exception {

                        if (view != null) {
                            view.updateUi(weatherResponse);
                        }

                        Toast.makeText(mContext, weatherResponse.getCity().getName(), Toast.LENGTH_SHORT).show();
                        Log.d("Success Message", " Success");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(mContext, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }


}
