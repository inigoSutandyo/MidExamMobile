package com.example.midexammobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.midexammobile.adapter.ItemAdapter;
import com.example.midexammobile.model.Item;

import java.util.ArrayList;


public class ListActivity extends AppCompatActivity {

    TextView emailTxt;

    RecyclerView recyclerView;
    ArrayList<Item> items;
    ItemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        emailTxt = findViewById(R.id.list_email);
        emailTxt.setText(intent.getStringExtra("EMAIL"));
        initRecyclerView();
    }

    private void initRecyclerView() {
        items = new ArrayList<>();
        adapter = new ItemAdapter(this, items);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        populateData();
        adapter.notifyDataSetChanged();
    }

    private void populateData() {
        items.add(new Item("Some Item", "asdasdadsasdasdads"));
        items.add(new Item("Jacket", "Lorem ipsum bla bla bla"));
        items.add(new Item("Trousers", "123123123123123"));
        items.add(new Item("Cup Noodle", "Noodle in a cup."));
        items.add(new Item("T-Shirt", "White t-shirt cheap."));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                logout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void logout() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}