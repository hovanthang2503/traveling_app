package com.example.traveling_app.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.traveling_app.MainActivity;
import com.example.traveling_app.R;
import com.example.traveling_app.entity.LoveTourAdapter;
import com.example.traveling_app.entity.Tour;

import java.util.ArrayList;
import java.util.List;

public class Menu_Love extends Fragment {

    private List<Tour> tours=new ArrayList<>();

    private MainActivity mainActivity;

    private View view;

    private RecyclerView love_rcv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_menu__love, container, false);
        mainActivity= (MainActivity) getActivity();
        love_rcv=view.findViewById(R.id.love_rcv);
        LinearLayoutManager ln=new LinearLayoutManager(mainActivity,RecyclerView.VERTICAL,false);;
        love_rcv.setLayoutManager(ln);
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(mainActivity, DividerItemDecoration.VERTICAL);
        love_rcv.addItemDecoration(itemDecoration);
        LoveTourAdapter adapter=new LoveTourAdapter(mainActivity,tours);
        love_rcv.setAdapter(adapter);
        return view;
    }
}