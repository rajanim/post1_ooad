package com.example.spenc.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by spenc on 4/16/2017.
 */

public class Result extends Fragment {

    ViewGroup rootView;
    ArrayAdapter<String> adapter;
    String searchData;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView= (ViewGroup)inflater.inflate(R.layout.activity_result,container,false);

        ListView food_list_view= (ListView) rootView.findViewById(R.id.food_list_view_id);
        ArrayList<String> foodArrayList= new ArrayList<>();

        //Receive Search Data
        Bundle bundle_box= getArguments();
        searchData= bundle_box.getString("SearchData");

        //Add Data to ArrayList
        foodArrayList.addAll(Arrays.asList(getResources().getStringArray(R.array.array_food)));

        //Connect ListView and Data
        adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                foodArrayList);

        //Set ListView on Result Layout
        food_list_view.setAdapter(adapter);

        //Enable Search Field
        setHasOptionsMenu(true);

        return rootView;
    }

    //Create Search Field Through Menu
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //Join Custom Layout
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem items= menu.findItem(R.id.menu_search_id);

        //Create Search
        SearchView search = (SearchView)items.getActionView();

        //Add Search Function
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String Query){
               return false;
            }

            //Filter Text to Search
            @Override
            public boolean onQueryTextChange(String newText){
               adapter.getFilter().filter(newText);

               return false;
            }
        });

        //Receive Search Data from Previous Fragment
        search.setQuery(searchData,false);

        super .onCreateOptionsMenu(menu, inflater);
    }



}
