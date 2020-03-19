package com.casperdaris.digitalscrum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.casperdaris.digitalscrum.Adapters.BacklogItemViewPagerAdapter;
import com.casperdaris.digitalscrum.Fragments.DoingFragment;
import com.casperdaris.digitalscrum.Fragments.DoneFragment;
import com.casperdaris.digitalscrum.Fragments.ToDoFragment;
import com.casperdaris.digitalscrum.Objecten.BacklogItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ProjectActivity extends AppCompatActivity {

    TextView naamVanProject;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    //Lijst met alle opgehaalde BacklogItems uit de database
    public static ArrayList<BacklogItem> backlogItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        naamVanProject = findViewById(R.id.naamVanProject);
        naamVanProject.setText(DashboardActivity.huidigProject.getPrnaam());

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
        backlogItems.clear();
    }
}
