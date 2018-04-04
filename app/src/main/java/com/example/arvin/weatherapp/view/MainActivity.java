package com.example.arvin.weatherapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.arvin.weatherapp.R;
import com.example.arvin.weatherapp.adapter.WeatherAdapter;
import com.example.arvin.weatherapp.model.City;
import com.example.arvin.weatherapp.model.Interactor.WeatherInteractor;
import com.example.arvin.weatherapp.model.Interactor.WeatherInteractorImp;
import com.example.arvin.weatherapp.model.Weather;
import com.example.arvin.weatherapp.model.WeatherResponse;
import com.example.arvin.weatherapp.presenter.WeatherPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements WeatherView {

    WeatherInteractor mWeatherInteractor;
    WeatherPresenter mWeatherPresenter;
    RecyclerView mRecyclerView;
    WeatherAdapter mWeatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWeatherInteractor = new WeatherInteractorImp();
        mWeatherPresenter = new WeatherPresenter(mWeatherInteractor, this);
        mWeatherPresenter.bind(this);

        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mWeatherPresenter.networkCall();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWeatherPresenter.unbind();
    }

    @Override
    public void updateUi(WeatherResponse response) {
        mWeatherAdapter = new WeatherAdapter(response, this);
        mRecyclerView.setAdapter(mWeatherAdapter);
    }
}
