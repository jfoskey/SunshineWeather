package com.example.android.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jerma_000 on 6/6/2015.
 */
public class WeatherDataParser {
    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        // TODO: add parsing code here
        //create JSONObject with name/value mappings from the JSON string
        JSONObject jWeather = new JSONObject (weatherJsonStr);
        //gets the Array in the Object
        JSONArray jArray = jWeather.getJSONArray("list");

        if  (jArray.length()>0 ){
            //Returns JSONObjectw values at index of the Array of Objects
            JSONObject json_data = jArray.getJSONObject(dayIndex);
            //get sub object inside the index array's object
            JSONObject json_max_data = json_data.getJSONObject("temp");

            if(json_max_data.has("max")){
                return json_max_data.getDouble("max");
            }else{
                return 4.0;
            }
        }
        return 2.0;
    }

}
