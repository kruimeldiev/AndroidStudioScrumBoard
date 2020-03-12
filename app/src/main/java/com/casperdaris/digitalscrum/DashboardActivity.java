package com.casperdaris.digitalscrum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.casperdaris.digitalscrum.Objecten.Gebruiker;
import com.casperdaris.digitalscrum.Objecten.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView projectRecyclerView;
    private RecyclerView.Adapter projectAdapter;
    private RecyclerView.LayoutManager projectLayoutManager;

    TextView naamVanGebruiker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        naamVanGebruiker = findViewById(R.id.naamVanGebruiker);
        naamVanGebruiker.setText(MainActivity.huidigeGebruiker.getVnaam() + " " + MainActivity.huidigeGebruiker.getAnaam());

        ArrayList<Project> projectenLijst = new ArrayList<>();
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));
        projectenLijst.add(new Project(1,1,1,"Test Project", "Dit is een test om te kijken of mijn projectenlijst het doet.", "Naam van Projectowner", "Naam van Scrum master"));


        projectRecyclerView = findViewById(R.id.recycleViewProjecten);
        projectLayoutManager = new LinearLayoutManager(this);
        projectAdapter = new ProjectAdapter(projectenLijst);

        projectRecyclerView.setLayoutManager(projectLayoutManager);
        projectRecyclerView.setAdapter(projectAdapter);
    }
}
