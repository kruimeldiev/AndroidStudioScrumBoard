package com.casperdaris.digitalscrum.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.casperdaris.digitalscrum.Objecten.Gebruiker;
import com.casperdaris.digitalscrum.R;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter <TeamAdapter.TeamlidViewHolder>{

    public static ArrayList<Gebruiker> mTeamLijst;

    public static class TeamlidViewHolder extends RecyclerView.ViewHolder{

        public TextView voornaam, achternaam, email;

        public TeamlidViewHolder(@NonNull View itemView) {
            super(itemView);
            voornaam = itemView.findViewById(R.id.teamLidVoornaam);
            achternaam = itemView.findViewById(R.id.teamLidAchternaam);
            email = itemView.findViewById(R.id.teamLidMail);
        }
    }

    public TeamAdapter(ArrayList<Gebruiker> teamLijst){
        mTeamLijst = teamLijst;
    }

    @NonNull
    @Override
    public TeamlidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //De layout voor de CardView ophalen
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_lid, parent, false);
        //De layout van de CardView vullen met de data in de ViewHolder
        TeamlidViewHolder tlvh = new TeamlidViewHolder(v);
        return tlvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamlidViewHolder holder, int position) {
        Gebruiker huidigTeamlid = mTeamLijst.get(position);

        holder.voornaam.setText(huidigTeamlid.getVnaam());
        holder.achternaam.setText(huidigTeamlid.getAnaam());
        holder.email.setText(huidigTeamlid.getEmail());
    }

    @Override
    public int getItemCount() {
        return mTeamLijst.size();
    }
}
