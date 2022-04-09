package com.example.empy1;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;

public class Commands {
    public static void volleyPostEsp(Context context, JSONObject jsonObject) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, Constant.URL_POST_ESP, jsonObject,
                response -> {
                    System.out.println(response);
                    Log.e("JSON OBJECT","RESPONSE =>" + response);
                },
                error -> Log.e("JSON OBJECT","ERROR =>" + error));
        queue.add(jsObjRequest);
    }
    public static void volleyPostArray(Context context, JSONObject jsonObject) {
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, Constant.URL_POST_ARRAY, jsonObject,
                response -> {
                    System.out.println(response);
                    Log.e("JSON ARRAY","RESPONSE =>" + response);
                },
                error -> Log.e("JSON ARRAY","ERROR =>" + error));
        queue.add(jsObjRequest);
    }
    public static void volleyGet(Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constant.URL_GET,
                response -> {
                    System.out.println(response);
                    Log.e("JSON GET","RESPONSE =>" + response);
                },
                error -> Log.e("JSON GET","ERROR =>" + error));
        queue.add(stringRequest);
    }
}
