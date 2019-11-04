package com.example.headphonesapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MainModel> mainModelList;

    private int[] imagesList = {R.drawable.red_headphone, R.drawable.black_headphone,
            R.drawable.dark_blue_headphone, R.drawable.yellow_headphone};

    private RecyclerView recyclerView;

    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        mainModelList = new ArrayList<>();
        for (Integer i : imagesList) {
            MainModel mainModel = new MainModel();
            mainModel.setImages(i);
            mainModelList.add(mainModel);
        }
        adapter = new MainAdapter(mainModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
