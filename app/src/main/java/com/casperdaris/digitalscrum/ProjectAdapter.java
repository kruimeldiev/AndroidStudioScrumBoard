package com.casperdaris.digitalscrum;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.casperdaris.digitalscrum.Objecten.Project;

import java.util.ArrayList;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    private ArrayList<Project> projectArrayList;

    public static class ProjectViewHolder extends RecyclerView.ViewHolder{
        public TextView projectNaam, projectBes, prown, scrma;

        public ProjectViewHolder(View itemView) {
            super(itemView);

            projectNaam = itemView.findViewById(R.id.projetNaamVanLayout);
            projectBes = itemView.findViewById(R.id.projectBeschVanLayout);
            prown = itemView.findViewById(R.id.prownVanLayout);
            scrma = itemView.findViewById(R.id.scrmaVanLayout);
        }
    }

    public ProjectAdapter(ArrayList<Project> projectenLijst){
        projectArrayList = projectenLijst;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_layout, parent, false);
        ProjectViewHolder pvh = new ProjectViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        Project huidigProject = projectArrayList.get(position);

        holder.projectNaam.setText(huidigProject.getPrnaam());
        holder.projectBes.setText(huidigProject.getPrbes());
        holder.prown.setText(huidigProject.getPrown());
        holder.scrma.setText(huidigProject.getScrma());
    }

    @Override
    public int getItemCount() {
        return projectArrayList.size();
    }
}
