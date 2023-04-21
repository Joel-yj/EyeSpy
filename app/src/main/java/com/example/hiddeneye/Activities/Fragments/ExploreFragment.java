package com.example.hiddeneye.Activities.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hiddeneye.Adapters.VideoDataAdapter;
import com.example.hiddeneye.Models.VideoAttribute;
import com.example.hiddeneye.Models.VideoAttributeViewModel;
import com.example.hiddeneye.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class ExploreFragment extends Fragment{

    private RecyclerView recyclerView;
    private VideoAttributeViewModel viewModel;
    private VideoDataAdapter myAdapter;

    public ExploreFragment() {
        // Required empty public constructor
    }

    public static ExploreFragment newInstance(String param1, String param2) {
        ExploreFragment fragment = new ExploreFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_explore, container, false);
    }
    // Inflate the layout for this fragment


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view,savedInstanceState);
        setToolbarMenu();
        recyclerView = view.findViewById(R.id.userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        myAdapter = new VideoDataAdapter(this.getContext(), new ArrayList<>());
        recyclerView.setAdapter(myAdapter);

        viewModel = new ViewModelProvider(this).get(VideoAttributeViewModel.class);

        viewModel.getVideoAttributes().observe(getViewLifecycleOwner(), videoAttributes -> myAdapter.updateList((ArrayList<VideoAttribute>) videoAttributes));
        viewModel.refreshVideoAttributes();

    }


    //TODO Tune search parameters
    private void setToolbarMenu() {
        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {

                menuInflater.inflate(R.menu.search_action_menu,menu);

                MenuItem menuItem = menu.findItem(R.id.search_action);
                SearchView searchView = (SearchView) menuItem.getActionView();
                searchView.setQueryHint("Type here to search");

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {

                        RequestQueue queue = Volley.newRequestQueue(getActivity());
                        String url = "https://hiddeneyebackend.azurewebsites.net/search?query=" + query;
                        StringRequest stringRequest = new StringRequest(Request.Method.GET,url,new Response.Listener<String>(){

                            @Override
                            public void onResponse(String response) {
                                // use response here to filter videoattribute objects
                                Gson gson = new Gson();
                                Type listType = new TypeToken<ArrayList<VideoAttribute>>(){}.getType();
                                ArrayList<VideoAttribute> videoAttributes = gson.fromJson(response,listType);
                                System.out.println(videoAttributes);
                                myAdapter.updateList(videoAttributes);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("MyApp", "Error" + error.getMessage());
                            }
                        });

                        queue.add(stringRequest);

                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return false;
                    }
                });
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        },getViewLifecycleOwner(), Lifecycle.State.RESUMED);
    }



}


