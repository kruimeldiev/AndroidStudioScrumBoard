package com.casperdaris.digitalscrum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.casperdaris.digitalscrum.Objecten.BacklogItem;

import java.util.ArrayList;

public class ProjectActivity extends AppCompatActivity {

    TextView naamVanProject;

    public static ArrayList<BacklogItem> backlogItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        naamVanProject = findViewById(R.id.naamVanProject);
        naamVanProject.setText(DashboardActivity.huidigProject.getPrnaam());
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        backlogItems.clear();
    }
}
