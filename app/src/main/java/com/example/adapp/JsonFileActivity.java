package com.example.adapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class JsonFileActivity extends AppCompatActivity {
    private final ArrayList<Users> mEmployeesList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_file);
        getEmployeeList();
        setUIRef();
    }

    private void setUIRef() {
        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);

        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(mEmployeesList);

        recyclerView.setAdapter(myRecyclerViewAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(JsonFileActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void getEmployeeList() {
        String myJSONStr = loadJSONFromAsset("user_data.json");
        try {
            JSONObject rootJSONObject = new JSONObject(myJSONStr);
            JSONArray employeeJSONArray = rootJSONObject.getJSONArray("profile");

            for (int i = 0; i < employeeJSONArray.length(); i++) {

                Users aEmployee = new Users();

                //Get employee JSON object node
                JSONObject jsonObject = employeeJSONArray.getJSONObject(i);


                aEmployee.setName(jsonObject.getString("name"));
                aEmployee.setDob(jsonObject.getString("dob"));
                aEmployee.setPhones(jsonObject.getString("phones"));

                //Add employee object to the list
                mEmployeesList.add(aEmployee);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String loadJSONFromAsset(String fileName) {
        String json;
        try {
            InputStream is = getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

