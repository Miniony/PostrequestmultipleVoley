package com.example.empy1;

import android.os.Bundle;
import android.widget.Button;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.appcompat.app.AppCompatActivity;
import static com.example.empy1.Commands.volleyGet;
import static com.example.empy1.Commands.volleyPostArray;
import static com.example.empy1.Commands.volleyPostEsp;


public class MainActivity extends AppCompatActivity {
    JSONObject jsonObject = new JSONObject();
    JSONObject allObj = new JSONObject();
    JSONArray jsonArray = new JSONArray();

    Button postArray, postEsp, getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postArray = findViewById(R.id.postArray);
        postEsp = findViewById(R.id.postEsp);
        getData = findViewById(R.id.get);

        postEsp.setOnClickListener(view -> {
            try {
                jsonObject.put("command", "ping_gerkon");
                jsonObject.put("state", "1");
                jsonObject.put("action", "");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            volleyPostEsp(getApplicationContext(), jsonObject);
        });

        postArray.setOnClickListener(view -> {
            try {
                jsonObject.put("command", "pin1");
                jsonObject.put("action", "1");
                jsonArray.put(jsonObject);
                allObj.put("command", "three_mode_switch");
                allObj.put("pins", jsonArray);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            volleyPostArray(getApplicationContext(), allObj);
        });

        getData.setOnClickListener(view -> {
            volleyGet(getApplicationContext());
        });

    }
}
