package com.ssoftwares.recycler_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String [] Data={"NAna","Lala","NAna","Lala","NAna","Lala","NAna","Lala","NAna","Lala","NAna","Lala"};
        recyclerView.setAdapter(new RecyclerAdapter(Data) );
    }
}
