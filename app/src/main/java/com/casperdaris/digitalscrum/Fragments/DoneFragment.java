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

import com.casperdaris.digitalscrum.Adapters.DoneBacklogAdapter;
import com.casperdaris.digitalscrum.Adapters.TodoBacklogAdapter;
import com.casperdaris.digitalscrum.ProjectActivity;
import com.casperdaris.digitalscrum.R;

public class DoneFragment extends Fragment {

    private RecyclerView doneRecyclerView;
    private DoneBacklogAdapter doneAdapter;
    private RecyclerView.LayoutManager doneLayoutManager;

    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.done_fragment_layout, container, false);

        doneRecyclerView = view.findViewById(R.id.recycleViewDone);
        doneRecyclerView.setHasFixedSize(true);
        doneLayoutManager = new LinearLayoutManager(context);
        doneAdapter = new DoneBacklogAdapter(ProjectActivity.doneItemLijst);

        doneRecyclerView.setLayoutManager(doneLayoutManager);
        doneRecyclerView.setAdapter(doneAdapter);

        return view;
    }
}