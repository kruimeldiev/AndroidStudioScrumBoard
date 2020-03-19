package com.casperdaris.digitalscrum.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.casperdaris.digitalscrum.R;

public class ToDoFragment extends Fragment {

    View view;

    public ToDoFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Layout (todo_fragment_layout.xml) koppelen aan deze fragment
        view = inflater.inflate(R.layout.todo_fragment_layout, container, false);
        return view;
    }
}