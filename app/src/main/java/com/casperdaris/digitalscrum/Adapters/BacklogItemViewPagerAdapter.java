package com.casperdaris.digitalscrum.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class BacklogItemViewPagerAdapter extends FragmentPagerAdapter {

    //Lijst maken met de drie verschillende fragments (To Do, Doing, Done)
    private final List<Fragment> backlogItemLijst = new ArrayList<>();
    private final List<String> backlogItemLijstNamen = new ArrayList<>();

    public BacklogItemViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return backlogItemLijst.get(position);
    }

    @Override
    public int getCount() {
        return backlogItemLijstNamen.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return backlogItemLijstNamen.get(position);
    }

    public void fragmentToevoegen(Fragment fragment, String naam){
        backlogItemLijst.add(fragment);
        backlogItemLijstNamen.add(naam);
    }
}
