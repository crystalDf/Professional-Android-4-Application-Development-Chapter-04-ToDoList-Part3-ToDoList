package com.star.todolist;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity
        implements NewItemFragment.OnNewItemAddedListener {

    private ArrayAdapter<String> aa;
    private ArrayList<String> toDoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        FragmentManager fragmentManager = getSupportFragmentManager();
        ToDoListFragment toDoListFragment =
                (ToDoListFragment) fragmentManager.findFragmentById(R.id.ToDoListFragment);

        toDoItems = new ArrayList<>();

        aa = new ArrayAdapter<>(this, R.layout.todolist_item, toDoItems);

        toDoListFragment.setListAdapter(aa);

    }

    @Override
    public void onNewItemAdded(String newItem) {
        toDoItems.add(newItem);
        aa.notifyDataSetChanged();
    }
}
