package com.casperdaris.digitalscrum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProjectActivity extends AppCompatActivity {

    TextView naamVanProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        naamVanProject = findViewById(R.id.naamVanProject);

        naamVanProject.setText(DashboardActivity.huidigProject.getPrnaam());
    }
}
