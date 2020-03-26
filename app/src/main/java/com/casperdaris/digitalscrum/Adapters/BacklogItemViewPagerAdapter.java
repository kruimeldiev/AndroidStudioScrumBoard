package com.casperdaris.digitalscrum.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

//Deze klasse gaat ervoor zorgen dat de drie fragments worden weergegeven in de TabLayout van de ProjectActivity
public class BacklogItemViewPagerAdapter extends FragmentPagerAdapter {

    //Lijst maken met de drie verschillende fragments (To Do, Doing, Done)
    private final List<Fragment> backlogFragmentLijst = new ArrayList<>();
    //Lijst maken met de namen van de fragments. De namen in deze lijst heb je als String nodig voor de TabLayout
    private final List<String> backlogFragmentLijstNamen = new ArrayList<>();

    public BacklogItemViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return backlogFragmentLijst.get(position);
    }

    @Override
    public int getCount() {
        return backlogFragmentLijstNamen.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return backlogFragmentLijstNamen.get(position);
    }

    public void fragmentToevoegen(Fragment fragment, String naam){
        backlogFragmentLijst.add(fragment);
        backlogFragmentLijstNamen.add(naam);
    }
}
