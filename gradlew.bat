package com.example.weatherapp;


import java.io.IOException;

public class Temperature implements Runnable {

    public float temp;
    public String name;
//    private float temperature;
    public Temperature(String name) {

      this.name = name;

//      this.temperature = conditions.getMeasurements().get("temp");
    }



    @Override
    public void run() {
        try {
            WeatherDataLoader loader = new WeatherDataLoader();
            WeatherConditions conditions = loader.getWeather(name);

            temp = conditions.getMeasurements().get("temp");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(name);
    }

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      