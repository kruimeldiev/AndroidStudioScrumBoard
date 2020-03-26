package com.casperdaris.digitalscrum.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.casperdaris.digitalscrum.Adapters.DoingBacklogAdapter;
import com.casperdaris.digitalscrum.Adapters.TodoBacklogAdapter;
import com.casperdaris.digitalscrum.ProjectActivity;
import com.casperdaris.digitalscrum.R;

public class DoingFragment extends Fragment {

    private RecyclerView doingRecyclerView;
    private DoingBacklogAdapter doingAdapter;
    private RecyclerView.LayoutManager doingLayoutManager;

    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.doing_fragment_layout, container, false);

        doingRecyclerView = view.findViewById(R.id.recycleViewDoing);
        doingRecyclerView.setHasFixedSize(true);
        doingLayoutManager = new LinearLayoutManager(context);
        doingAdapter = new DoingBacklogAdapter(ProjectActivity.doingItemLijst);

        doingRecyclerView.setLayoutManager(doingLayoutManager);
        doingRecyclerView.setAdapter(doingAdapter);

        return view;
    }
}