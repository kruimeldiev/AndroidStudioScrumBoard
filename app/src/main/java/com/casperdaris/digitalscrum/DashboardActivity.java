package com.casperdaris.digitalscrum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.casperdaris.digitalscrum.Objecten.Project;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    //RecyclerView aanmaken om de projecten van de gebruiker weer te geven
    private RecyclerView projectenRecyclerView;

    //Adapter zorgt ervoor dat de projecten ArrayList (projectenLijst) wordt weergegeven in de RecyclerView
    private ProjectenAdapter projectenAdapter;

    //LayoutManager zorgt ervoor dat de projecten op de juiste manier worden weergegeven in de RecyclerView
    private RecyclerView.LayoutManager projectenLayoutManager;

    public static Project huidigProject;

    //Arraylist met projecten die in ProjectenOphalen.java klasse zijn opgehaald uit de database
    public static ArrayList<Project> projectenLijst = new ArrayList<>();

    TextView naamVanGebruiker;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        maakProjectenRecyclerView();

        naamVanGebruiker = findViewById(R.id.naamVanGebruiker);
        naamVanGebruiker.setText(MainActivity.huidigeGebruiker.getVnaam() + " " + MainActivity.huidigeGebruiker.getAnaam());
    }

    public void maakProjectenRecyclerView(){
        projectenRecyclerView = findViewById(R.id.recycleViewProjecten);
        projectenRecyclerView.setHasFixedSize(true);
        projectenLayoutManager = new LinearLayoutManager(this);

        //Deze lijst gaat naar de ProjectenAdapter om de projecten weer te geven in de app
        projectenAdapter = new ProjectenAdapter(projectenLijst);

        projectenRecyclerView.setLayoutManager(projectenLayoutManager);
        projectenRecyclerView.setAdapter(projectenAdapter);

        //HIER NOG WAT EXTRA UITLEG GEVEN
        projectenAdapter.setOnProjectClickListener(new ProjectenAdapter.OnProjectClickListener() {
            @Override
            public void onProjectClick(int position) {
                //Het project van de positie van de klik selecteren
                huidigProject = projectenLijst.get(position);

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
