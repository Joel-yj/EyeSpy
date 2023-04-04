package com.example.hiddeneye.Activities.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.hiddeneye.R;
import com.example.hiddeneye.Repository.CognitiveSearchRepository;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    String endpoint = "https://test-joel.search.windows.net";
    String apikey = "ApZGjq5ub4YYtJhr65j8lfWIpMva8Qes7pbCHDT51nAzSeCIPW0x";
    String indexName = "azureblob-test-index";

    public SettingsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
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
        // Inflate the layout for this fragment
        CognitiveSearchRepository searchRepository = new CognitiveSearchRepository();
        searchRepository.searchVideos("*");
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }
}