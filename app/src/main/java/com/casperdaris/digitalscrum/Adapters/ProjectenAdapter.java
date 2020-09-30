package com.casperdaris.digitalscrum.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.casperdaris.digitalscrum.Objecten.Project;
import com.casperdaris.digitalscrum.R;

import java.util.ArrayList;

public class ProjectenAdapter extends RecyclerView.Adapter<ProjectenAdapter.ProjectenViewHolder> {

    private ArrayList<Project> mProjectenLijst;

    private OnProjectClickListener projectListener;

    public interface OnProjectClickListener{
        void onProjectClick(int position);
    }

    public void setOnProjectClickListener(OnProjectClickListener listener){
        projectListener = listener;
    }

    public static class ProjectenViewHolder extends RecyclerView.ViewHolder{

        //TextView van de projecten aanmaken
        public TextView projectNaam, projectBeschrijving, projectPrown, projectScrma;

        public ProjectenViewHolder(@NonNull View itemView, final OnProjectClickListener listener) {
            super(itemView);

            //TextView van de projecten linken aan project_layout.xml
            projectNaam = itemView.findViewById(R.id.projectNaamLayout);
            projectBeschrijving = itemView.findViewById(R.id.projectBeschLayout);
            projectPrown = itemView.findViewById(R.id.prownLayout);
            projectScrma = itemView.findViewById(R.id.scrmaLayout);

            //de itemView zijn de projecten die voor de gebruiker worden weergegeven
            //wanneer de gebruiker op een specifiek project klikt, wordt er gecontrolleerd op welke positie er wordt geklikt
            //de positie van de klik wordt doorgestuurd naar de OnProjectClickListener interface bovenaan deze klasse
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onProjectClick(position);
                        }
                    }
                }
            });
        }
    }

    public ProjectenAdapter(ArrayList<Project> projectenLijst) {
        mProjectenLijst = projectenLijst;
    }

    @NonNull
    @Override
    public ProjectenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Layout van de CardView (project_layout.xml) ophalen om deze later weer te kunnen geven in de RecyclerView (dat gebeurt bij de onBindViewHolder)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_layout, parent, false);
        ProjectenViewHolder pvh = new ProjectenViewHolder(v, projectListener);
        return pvh;
    }

    //De methode hieronder zorgt ervoor dat de Projecten in de DashboardActivity.projectenLijst worden omgezet naar Cards voor de Cardview
    @Override
    public void onBindViewHolder(@NonNull ProjectenViewHolder holder, int position) {
        Project projectWeergeven = mProjectenLijst.get(position);

        holder.projectNaam.setText(projectWeergeven.getPrnaam());
        holder.projectBeschrijving.setText(projectWeergeven.getPrbes());
        holder.projectPrown.setText("Product Owner: " + projectWeergeven.getPrown());
        holder.projectScrma.setText("Scrum Master: " + projectWeergeven.getScrma());
    }

    @Override
    public int getItemCount() {

        //de hoeveelheid van de cardviews bepalen
        return mProjectenLijst.size();
    }
}
