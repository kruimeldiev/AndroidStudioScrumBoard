package com.casperdaris.digitalscrum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.casperdaris.digitalscrum.Adapters.BacklogItemViewPagerAdapter;
import com.casperdaris.digitalscrum.Fragments.DoingFragment;
import com.casperdaris.digitalscrum.Fragments.DoneFragment;
import com.casperdaris.digitalscrum.Fragments.ToDoFragment;
import com.casperdaris.digitalscrum.Objecten.BacklogItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ProjectActivity extends AppCompatActivity {

    TextView naamVanProject, beschrijvingVanProject;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private Button itemToevoegen, itemVerwijderen, teamWeergeven;

    //Lijsten met alle opgehaalde BacklogItems uit de database
    public static ArrayList<BacklogItem> todoItemLijst = new ArrayList<>();
    public static ArrayList<BacklogItem> doingItemLijst = new ArrayList<>();
    public static ArrayList<BacklogItem> doneItemLijst = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        naamVanProject = findViewById(R.id.naamVanProject);
        naamVanProject.setText(DashboardActivity.huidigProject.getPrnaam());
        beschrijvingVanProject = findViewById(R.id.beschrijvingVanProject);
        beschrijvingVanProject.setText(DashboardActivity.huidigProject.getPrbes());

        itemToevoegen = findViewById(R.id.backlogToevoegenKnop);
        itemVerwijderen = findViewById(R.id.backlogVerwijderenKnop);
        teamWeergeven = findViewById(R.id.teamWeergevenKnop);

        tabLayout = findViewById(R.id.projectTabLayout);
        viewPager = findViewById(R.id.projectPageViewer);

        //Fragments toevoegen aan de PageView
        BacklogItemViewPagerAdapter adapter = new BacklogItemViewPagerAdapter(getSupportFragmentManager());
        adapter.fragmentToevoegen(new ToDoFragment(), "To Do");
        adapter.fragmentToevoegen(new DoingFragment(), "Doing");
        adapter.fragmentToevoegen(new DoneFragment(), "Done");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        todoItemLijst.clear();
        doingItemLijst.clear();
        doneItemLijst.clear();
    }
}