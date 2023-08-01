package com.example.oo_vko12.sampledata;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oo_vko12.Item;
import com.example.oo_vko12.ItemListAdapter;
import com.example.oo_vko12.ItemStorage;
import com.example.oo_vko12.R;

import java.util.Collections;
import java.util.Comparator;

public class Lista extends Fragment {

    private ItemStorage itemStorage;
    private RecyclerView recyclerView;
    private ItemListAdapter itemListAdapter;

    private Context context;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        itemStorage = ItemStorage.getInstance();
        context = view.getContext();

        recyclerView = view.findViewById(R.id.rvItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        /*
        Send user list to ItemListAdapter.java
         */
        itemListAdapter = new ItemListAdapter(context, itemStorage.getItems()); //getApplicationContext()
        recyclerView.setAdapter(itemListAdapter);


        /*
        sort buttons
         */
        //Sort by alphabetical
        view.findViewById(R.id.btnSortByAlphabetical).setOnClickListener(_view -> {
            Collections.sort(itemStorage.getItems(), new Comparator<Item>() {
                @Override
                public int compare(Item itemA, Item itemB) {
                    return (itemA.getText()).compareTo(itemB.getText());
                    //return (itemA.getText()).compareToIgnoreCase(itemB.getText()); //
                }
            });
            itemListAdapter.notifyDataSetChanged();
        });

        //Sort by time (item is created)
        view.findViewById(R.id.btnSortByTime).setOnClickListener(_view -> {
            Collections.sort(itemStorage.getItems(), new Comparator<Item>() {
                @Override
                public int compare(Item itemA, Item itemB) {
                    return (itemA.getTimeCreated()).compareTo(itemB.getTimeCreated());
                    //return (itemA.getTimeCreated()).compareToIgnoreCase(itemB.getTimeCreated()); //
                }
            });
            itemListAdapter.notifyDataSetChanged();
        });


        return view;
    }


    public ItemListAdapter getAdapter() {
        return itemListAdapter;
    }

}