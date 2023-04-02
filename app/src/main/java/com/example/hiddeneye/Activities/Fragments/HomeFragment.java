package com.example.hiddeneye.Activities.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hiddeneye.Adapters.VideoDataAdapter;
import com.example.hiddeneye.Models.VideoAttribute;
import com.example.hiddeneye.Models.VideoAttributeViewModel;
import com.example.hiddeneye.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private VideoAttributeViewModel viewModel;
    private VideoDataAdapter myAdapter;
    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        myAdapter = new VideoDataAdapter(recyclerView.getContext(), new ArrayList<>());
        recyclerView.setAdapter(myAdapter);

        VideoAttributeViewModel viewModel = new ViewModelProvider(this).get(VideoAttributeViewModel.class);

        viewModel.getVideoAttributes().observe(getViewLifecycleOwner(), new Observer<List<VideoAttribute>>() {
            @Override
            public void onChanged(List<VideoAttribute> videoAttributes) {
                myAdapter.updateList(videoAttributes);
            }
        });



    }

}
