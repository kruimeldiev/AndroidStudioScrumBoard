package com.casperdaris.digitalscrum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.casperdaris.digitalscrum.Adapters.ProjectenAdapter;
import com.casperdaris.digitalscrum.Objecten.BacklogItem;
import com.casperdaris.digitalscrum.Objecten.Project;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    //RecyclerView aanmaken om de projecten van de gebruiker weer te geven
    public static RecyclerView projectenRecyclerView;

    //Adapter zorgt ervoor dat de projecten ArrayList (projectenLijst) wordt weergegeven als CardViews in de RecyclerView
    public static ProjectenAdapter projectenAdapter;

    //LayoutManager zorgt ervoor dat de projecten op de juiste manier worden weergegeven in de RecyclerView
    public static RecyclerView.LayoutManager projectenLayoutManager;

    //Wanneer de gebruiker op de CardView van een project klikt, wordt dit project aangemaakt.
    //Dit Project wordt vervolgens gebruikt in de maakProjectenRecyclerView om de BacklogItems van dit project uit de database op te halen.
    public static Project huidigProject;

    //Arraylist met projecten die in ProjectenOphalen.java klasse zijn opgehaald uit de database
    public static ArrayList<Project> projectenLijst = new ArrayList<>();

    Button nieuwProjectKnop, verwijderProjectKnop, refreshProjecten;

    TextView naamVanGebruiker;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Projecten ophalen voor de Arraylist (projectenLijst) in de DashboardActivity
        ProjectenOphalen projectenOphalen = new ProjectenOphalen(context);
        projectenOphalen.execute();

        maakProjectenRecyclerView();

        naamVanGebruiker = findViewById(R.id.naamVanGebruiker);
        naamVanGebruiker.setText(MainActivity.huidigeGebruiker.getVnaam() + " " + MainActivity.huidigeGebruiker.getAnaam());

        nieuwProjectKnop = findViewById(R.id.projectToevoegenKnop);
        refreshProjecten = findViewById(R.id.projectenRefresh);
        verwijderProjectKnop = findViewById(R.id.projectVerwijderenKnop);

        nieuwProjectKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProjectAanmaken.class);
                startActivity(intent);
                finish();
            }
        });

        //Alle projecten opnieuw ophalen uit de database en in RecyclerView plaatsen
        refreshProjecten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                projectenLijst.clear();

                projectenRecyclerView.getRecycledViewPool().clear();

                ProjectenOphalen projectenOphalen = new ProjectenOphalen(context);
                projectenOphalen.execute();

                maakProjectenRecyclerView();

                projectenAdapter.notifyDataSetChanged();
            }
        });

        verwijderProjectKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProjectVerwijderen.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void maakProjectenRecyclerView(){
        projectenRecyclerView = findViewById(R.id.recycleViewProjecten);
        projectenLayoutManager = new LinearLayoutManager(this);

        //projectenLijst gaat naar de ProjectenAdapter om de projecten uit de database weer te geven in de app
        projectenAdapter = new ProjectenAdapter(projectenLijst);

        projectenRecyclerView.setLayoutManager(projectenLayoutManager);
        projectenRecyclerView.setAdapter(projectenAdapter);

        projectenAdapter.setOnProjectClickListener(new ProjectenAdapter.OnProjectClickListener() {
            @Override
            public void onProjectClick(int position) {
                //Het project van de positie van de klik selecteren
                huidigProject = projectenLijst.get(position);

                //Alle backlog items ophalen voor het geselecteerde project en een nieuwe activity starten voor dit project
                BacklogOphalen backlogOphalen = new BacklogOphalen(context);
                backlogOphalen.execute();

                Intent intent = new Intent(context, ProjectActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //Projecten Arraylist leeghalen bij uitloggen
        projectenLijst.clear();
    }
}
