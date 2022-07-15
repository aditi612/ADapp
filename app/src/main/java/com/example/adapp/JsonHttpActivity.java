package com.example.adapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonHttpActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    PostAdapter adapter;
    ArrayList<Posts> postsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_http);

        recyclerView = findViewById(R.id.myRecyclerView);
        linearLayoutManager = new LinearLayoutManager(JsonHttpActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new PostAdapter(postsList);
        recyclerView.setAdapter(adapter);

        fetchPosts();
    }

    private void fetchPosts() {


        RetrofitClient.getRetrofitClient().getPosts().enqueue(new Callback<List<Posts>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<List<Posts>> call, @NonNull Response<List<Posts>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    postsList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Posts>> call, @NonNull Throwable t) {
                Toast.makeText(JsonHttpActivity.this, "Error " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}

//
//    private  void translate(Integer index){
//
//       // postsList = english
//
//        //[
//        //
//        // ]
//        Posts post = postsList.get(index);
//        Posts translatedPost = new Posts();
//        String translatedName = translateName(post.getName());
//        String translatedDOB = translateName(post.getDob());
//
//        translatedPost.setName(translatedName);
//        translatedPost.setDob(translatedDOB);
//
//
//        postsList.add(index, translatedPost);
//        adapter.notifyDataSetChanged();
//
//        //translate data in the postsList:
//                ArrayList<Posts> translatedList = new ArrayList<Posts>();
//
//
//
//
//
//
//        postsList.clear();
//        postsList.addAll(translatedList);
//        adapter.notifyDataSetChanged();
//    }
//}


