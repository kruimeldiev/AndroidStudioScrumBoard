package com.casperdaris.digitalscrum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.casperdaris.digitalscrum.Objecten.Project;

public class ProjectAanmaken extends AppCompatActivity {

    static EditText naamVanProject, beschrijvingVanProject, scrumMasterVanProject;
    static Button projectAanmakenKnop, annuleerKnop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_aanmaken);

        naamVanProject = findViewById(R.id.naamVanProjectAanmaken);
        beschrijvingVanProject = findViewById(R.id.beschVanProjectAanmaken);
        scrumMasterVanProject = findViewById(R.id.scrumMasterVeld);

        projectAanmakenKnop = findViewById(R.id.projectAanmakenKnop);
        annuleerKnop = findViewById(R.id.annuleerProjecrAanmakenKnop);

        projectAanmakenKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NieuwProject nieuwProject = new NieuwProject(v.getContext());
                nieuwProject.execute();
            }
        });

        final Context context = this;

        annuleerKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
