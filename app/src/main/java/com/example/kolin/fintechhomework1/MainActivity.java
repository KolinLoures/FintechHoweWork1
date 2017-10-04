package com.example.kolin.fintechhomework1;

import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContactsRecyclerAdapter adapter = new ContactsRecyclerAdapter();

        final View view = findViewById(R.id.main_view);
        RecyclerView recyclerView = findViewById(R.id.main_recycler_view_contacts);


        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

        adapter.setListener(new ContactsRecyclerAdapter.ContractsRecyclerListener() {
            @Override
            public void onClickInfo(String text, int pos) {
                Snackbar.make(view, text + " | pos in adapter: " + pos, BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });

        adapter.addData(getTestData());
    }

    private List<String> getTestData(){
        List<String> temp = new ArrayList<>();
        temp.add("Fintech");
        temp.add("Fintech");
        temp.add("Fintech");
        temp.add("Fintech");
        temp.add("Fintech");
        temp.add("Fintech");
        temp.add("Fintech");
        return temp;
    }
}
