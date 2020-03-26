package com.casperdaris.digitalscrum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProjectVerwijderen extends AppCompatActivity {

    static EditText naamVanProject;
    static Button projectVerwijderKnop, annuleerKnop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_verwijderen);

        naamVanProject = findViewById(R.id.naamVanProjectVerwijderen);
        projectVerwijderKnop = findViewById(R.id.projectVerwijderenKnop);
        annuleerKnop = findViewById(R.id.annuleerProjectVerwijderenKnop);

        final Context context = this;

        projectVerwijderKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerwijderProject verwijderProject = new VerwijderProject(context);
                verwijderProject.execute();
            }
        });

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
