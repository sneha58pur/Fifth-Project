package com.example.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] title = getResources().getStringArray(R.array.tech_array);
        String[] subtitle ={
                "Price: 1500","Price: 400",
                "Price: 450","Price: 550",
                "Price: 700","Price: 1500","Price: 400",
                "Price: 450","Price: 550",
                "Price: 700"
        };
        Integer[] imgid= {R.drawable.dress, R.drawable.jew, R.drawable.ring, R.drawable.earring,
                R.drawable.coat, R.drawable.dress, R.drawable.jew, R.drawable.ring, R.drawable.earring,
                R.drawable.coat
               };
        ArrayList<Model> data = new ArrayList<>();

        for (int i = 0; i<title.length; i++){
            Model obj = new Model();
            obj.setTitle(title[i]);
            obj.setSubtitle(subtitle[i]);
            obj.setImageId(imgid[i]);
            data.add(obj);
        }

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(data, getApplicationContext());

        recyclerView.setAdapter(adapter);
    }
}