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

import com.casperdaris.digitalscrum.Adapters.TodoBacklogAdapter;
import com.casperdaris.digitalscrum.ProjectActivity;
import com.casperdaris.digitalscrum.R;

public class ToDoFragment extends Fragment {

    //RecyclerView aanmaken om de To Do Items van het project in te plaatsen
    private RecyclerView todoRecyclerView;

    private TodoBacklogAdapter todoAdapter;

    //LayoutManager zorgt ervoor dat de projecten op de juiste manier worden weergegeven in de RecyclerView
    private RecyclerView.LayoutManager todoLayoutManager;

    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.todo_fragment_layout, container, false);

       todoRecyclerView = view.findViewById(R.id.recycleViewToDo);
       todoRecyclerView.setHasFixedSize(true);
       todoLayoutManager = new LinearLayoutManager(context);
       todoAdapter = new TodoBacklogAdapter(ProjectActivity.todoItemLijst);

       todoRecyclerView.setLayoutManager(todoLayoutManager);
       todoRecyclerView.setAdapter(todoAdapter);

       return view;
    }
}