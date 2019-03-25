package com.example.treblehelper;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;


public class UserMapManager extends AppCompatActivity {
    private SharedPreferences myPrefs;
    private static final String PREFS = "MAP_LOCATION";
    private Map userMap;
    private Gson gson;

    public UserMapManager() {
        myPrefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        userMap = new HashMap();
        gson = new Gson();
    }

    public Map<String, Users> getUserMap() {
        if (myPrefs.contains(PREFS)) {

        }
        return userMap;
    }

    public void saveUserMap() {

    }
}
