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
    private static final String MAP_TEACHER = "MAP_TEACHER";
    private static final String MAP_STUDENT = "MAP_STUDENT";
    private Map userMap;
    private Gson gson;

    public UserMapManager() {
        userMap = new HashMap();
        gson = new Gson();
    }

    public Map<String, Users> getUserMap(Context context, String userType) {
        SharedPreferences myPrefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        Type typeStringMap = new TypeToken<Map<String, Users>>() {}.getType();
        if (userType.equals("TEACHER")) {
            String stringMap = myPrefs.getString(MAP_TEACHER,null);
            userMap = gson.fromJson(stringMap, typeStringMap);
            Log.d("J-DEBUG","Getting a Map");
            return userMap;
        } else if (userType.equals("STUDENT")) {
            String stringMap = myPrefs.getString(MAP_STUDENT,null);
            userMap = gson.fromJson(stringMap, typeStringMap);
            Log.d("J-DEBUG","Getting a Map");
            return userMap;
        } else
            return null;
    }

    public void saveUserMap(Map<String, Users> user, Context context, String userType) {
        SharedPreferences myPrefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrefs.edit();
        if(userType.equals("TEACHER")) {
            if (myPrefs.contains(MAP_TEACHER)) {
                myPrefs.edit().clear().apply();
            }
            String mapString = gson.toJson(user);
            editor.putString(MAP_TEACHER, mapString);
            editor.apply();
            Log.d("J-DEBUG", "Setting a Map");
        } else if(userType.equals("STUDENT")) {
            if (myPrefs.contains(MAP_STUDENT)) {
                myPrefs.edit().clear().apply();
            }
            String mapString = gson.toJson(user);
            editor.putString(MAP_STUDENT, mapString);
            editor.apply();
            Log.d("J-DEBUG", "Setting a Map");
        }
    }
}
