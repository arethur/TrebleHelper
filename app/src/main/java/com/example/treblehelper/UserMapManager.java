package com.example.treblehelper;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;


public class UserMapManager {
    private static final String PREFS = "MAP_LOCATION";
    private static final String MAP_KEY = "MAP_KEY";
    private Map userMap;
    private Gson gson;

    public UserMapManager() {
        userMap = new HashMap();
        gson = new Gson();
    }

    public Map<String, Users> getUserMap(Context context) {
        SharedPreferences myPrefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        if (myPrefs.contains(MAP_KEY)) {
            String stringMap = myPrefs.getString(MAP_KEY,null);
            Type typeStringMap = new TypeToken<Map<String, Users>>() {}.getType();
            userMap = gson.fromJson(stringMap, typeStringMap);
            Log.d("J-DEBUG","Getting a Map");
            return userMap;
        } else
            return null;

    }

    public void saveUserMap(Map<String, Users> user, Context context) {
        SharedPreferences myPrefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        if (myPrefs.contains(MAP_KEY)) {
            myPrefs.edit().clear().apply();
        }
        SharedPreferences.Editor editor = myPrefs.edit();
        String mapString = gson.toJson(user);
        editor.putString(MAP_KEY, mapString);
        editor.apply();
        Log.d("J-DEBUG","Setting a Map");
    }
}
