package com.example.horizontalrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView,dynamic_rv;
    private List<JunkAttributes> junkAttributes;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);

        junkAttributes=new ArrayList<>();
        junkAttributes.add(new JunkAttributes("Hamburger",R.drawable.hamburger));
        junkAttributes.add(new JunkAttributes("Pizza",R.drawable.pizza));
        junkAttributes.add(new JunkAttributes("Coffee",R.drawable.coffee));
        junkAttributes.add(new JunkAttributes("Pasta",R.drawable.pasta));
        junkAttributes.add(new JunkAttributes("Juice",R.drawable.juice));
        junkAttributes.add(new JunkAttributes("Chocolate",R.drawable.chocolate));







        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));




        adapter=new RecyclerAdapter(MainActivity.this,junkAttributes);
        recyclerView.setAdapter(adapter);
    }
}