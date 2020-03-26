package com.casperdaris.digitalscrum.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.casperdaris.digitalscrum.Objecten.BacklogItem;
import com.casperdaris.digitalscrum.ProjectActivity;
import com.casperdaris.digitalscrum.R;

import java.util.ArrayList;

public class DoneBacklogAdapter extends RecyclerView.Adapter<DoneBacklogAdapter.DoneViewHolder> {

    public static class DoneViewHolder extends RecyclerView.ViewHolder{

        public TextView itemNaam, itemBeschrijving, developer;

        public DoneViewHolder(@NonNull View itemView) {
            super(itemView);

            itemNaam = itemView.findViewById(R.id.itemNaamLayout);
            itemBeschrijving = itemView.findViewById(R.id.itemBeschLayout);
            developer = itemView.findViewById(R.id.devVanItemLayout);
        }
    }

    //Alle data van de ArrayList met backlogItems (ProjectenActivity.doneItemLijst) worden hieronder naar de Adapter geplaatst.
    public DoneBacklogAdapter(ArrayList<BacklogItem> backlogItemsVoorWeergave){
        ProjectActivity.doneItemLijst = backlogItemsVoorWeergave;
    }

    @NonNull
    @Override
    public DoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Layout van de CardView (backlog_item_layout.xml) ophalen om deze later weer te kunnen geven in de RecyclerView (dat gebeurt bij de onBindViewHolder)
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.backlog_item_layout, parent, false);
        DoneViewHolder donevh = new DoneViewHolder(v);
        return donevh;
    }

    @Override
    public void onBindViewHolder(@NonNull DoneViewHolder holder, int position) {
        BacklogItem backlogItemWeergeven = ProjectActivity.doneItemLijst.get(position);

        holder.itemNaam.setText(backlogItemWeergeven.getItnm());
        holder.itemBeschrijving.setText(backlogItemWeergeven.getItbes());
        holder.developer.setText("Developer: " + backlogItemWeergeven.getDev());
    }

    @Override
    public int getItemCount() {
        return ProjectActivity.doneItemLijst.size();
    }
}
