package com.mop.korac.mopstar.decode;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

import static android.content.Context.MODE_PRIVATE;

public class JWTUtils {

    public static void decoded(String JWTEncoded) throws Exception {
        try {
            String[] split = JWTEncoded.split("\\.");
            Log.d("JWT_DECODED", "Header: " + getJson(split[0]));
            Log.d("JWT_DECODED", "Body: " + getJson(split[1]));


        } catch (UnsupportedEncodingException e) {
            //Error
        }
    }

    private static String getJson(String strEncoded) throws UnsupportedEncodingException {
        byte[] decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE);
        return new String(decodedBytes, "UTF-8");
    }
    public static String body(String JWTEncoded){
        String[] split = JWTEncoded.split("\\.");
        String json = null;
        try {
            json = getJson(split[1]);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
