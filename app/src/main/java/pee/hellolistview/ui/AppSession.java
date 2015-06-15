package pee.hellolistview.ui;

import android.app.Application;

import java.util.List;

import pee.hellolistview.mb.Account;

/**
 * Created by pvu_asus on 25/05/2015.
 */
public class AppSession extends Application {
    WeatherData weatherData;

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public String toString() {
        return "AppSession{" +
                "weatherData=" + weatherData +
                '}';
    }
}
