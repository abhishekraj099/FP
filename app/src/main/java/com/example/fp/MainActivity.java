package com.example.fp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ApiService;
import com.example.Faculty;
import com.example.FacultyAdapter;
import com.example.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FacultyAdapter adapter;
    private List<Faculty> facultyList;
    private ProgressBar progressBar;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);

        // Initialize API service
        apiService = RetrofitClient.getClient().create(ApiService.class);

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        facultyList = new ArrayList<>();
        adapter = new FacultyAdapter(this, facultyList);
        recyclerView.setAdapter(adapter);

        // Load data
        loadFacultyData();
    }

    private void loadFacultyData() {
        progressBar.setVisibility(View.VISIBLE);

        apiService.getAllFaculty().enqueue(new Callback<List<Faculty>>() {
            @Override
            public void onResponse(Call<List<Faculty>> call, Response<List<Faculty>> response) {
                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful() && response.body() != null) {
                    facultyList.clear();
                    facultyList.addAll(response.body());
                    adapter.notifyDataSetChanged();

                    if (facultyList.isEmpty()) {
                        Toast.makeText(MainActivity.this, "No faculty data available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Failed to load faculty data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Faculty>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}