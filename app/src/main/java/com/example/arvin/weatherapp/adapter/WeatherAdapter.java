package com.example.arvin.weatherapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arvin.weatherapp.R;
import com.example.arvin.weatherapp.model.Weather;
import com.example.arvin.weatherapp.model.WeatherResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    WeatherResponse mWeatherResponse;
    Context mContext;

    public WeatherAdapter(WeatherResponse mWeatherResponse, Context mContext) {
        this.mWeatherResponse = mWeatherResponse;
        this.mContext = mContext;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_layout, parent, false);
        return new WeatherViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {

        //For Icon
        String icon = mWeatherResponse.getList().get(position).getWeather().get(0).getIcon();
        String iconUrl = "http://openweathermap.org/img/w/" + icon + ".png";

        Picasso.with(holder.iv_weather_icon.getContext()).load(iconUrl).into(holder.iv_weather_icon);
        holder.tv_city_name.setText(mWeatherResponse.getCity().getName());
        holder.tv_weather_description.setText(mWeatherResponse.getList().get(position).getWeather().get(0).getDescription());
        holder.tv_date.setText(mWeatherResponse.getList().get(position).getDtTxt());

        holder.tv_normal.setText(mWeatherResponse.getList().get(position).getMain().getTemp().toString());
        holder.tv_min.setText(mWeatherResponse.getList().get(position).getMain().getTempMin().toString());
        holder.tv_max.setText(mWeatherResponse.getList().get(position).getMain().getTempMax().toString());
        holder.tv_humidity.setText(mWeatherResponse.getList().get(position).getMain().getHumidity().toString());
        holder.tv_pressure.setText(mWeatherResponse.getList().get(position).getMain().getPressure().toString());

        holder.tv_speed.setText(mWeatherResponse.getList().get(position).getWind().getSpeed().toString());
        holder.tv_deg.setText(mWeatherResponse.getList().get(position).getWind().getDeg().toString());

    }

    @Override
    public int getItemCount() {
        return mWeatherResponse.getList().size();
    }

    class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_city_name, tv_date, tv_normal, tv_min, tv_max, tv_humidity, tv_pressure;
        ImageView iv_weather_icon;
        TextView tv_weather_description, tv_speed, tv_deg;


        public WeatherViewHolder(View itemView) {
            super(itemView);

            tv_city_name = itemView.findViewById(R.id.tv_city_name);
            iv_weather_icon = itemView.findViewById(R.id.iv_weather_icon);
            tv_weather_description = itemView.findViewById(R.id.tv_weather_description);
            tv_date = itemView.findViewById(R.id.tv_date);

            tv_normal = itemView.findViewById(R.id.tv_normal);
            tv_min = itemView.findViewById(R.id.tv_min);
            tv_max = itemView.findViewById(R.id.tv_max);
            tv_humidity = itemView.findViewById(R.id.tv_humidity);
            tv_pressure = itemView.findViewById(R.id.tv_pressure);

            tv_speed = itemView.findViewById(R.id.tv_speed);
            tv_deg = itemView.findViewById(R.id.tv_deg);

        }

        @Override
        public void onClick(View v) {
        }

    }


}
