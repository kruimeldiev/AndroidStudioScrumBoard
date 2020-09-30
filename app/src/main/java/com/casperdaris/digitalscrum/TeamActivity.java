package com.casperdaris.digitalscrum;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.casperdaris.digitalscrum.Adapters.TeamAdapter;
import com.casperdaris.digitalscrum.Objecten.Gebruiker;

import java.util.ArrayList;

public class TeamActivity extends AppCompatActivity {

    public static ArrayList<Gebruiker> teamLijst = new ArrayList<>();

    private TeamOphalen teamOphalen = new TeamOphalen(this);

    private RecyclerView teamRecyclerView;
    private TeamAdapter teamAdapter;
    private RecyclerView.LayoutManager teamLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        teamOphalen.execute();

        teamRecyclerView = findViewById(R.id.recycleViewTeam);
        teamRecyclerView.setHasFixedSize(true);

        teamLayoutManager = new LinearLayoutManager(this);
        teamAdapter = new TeamAdapter(teamLijst);

        teamRecyclerView.setLayoutManager(teamLayoutManager);
        teamRecyclerView.setAdapter(teamAdapter);
    }
}
