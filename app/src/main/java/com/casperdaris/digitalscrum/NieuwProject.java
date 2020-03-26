package com.casperdaris.digitalscrum;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.casperdaris.digitalscrum.Objecten.Project;

import java.net.ProtocolException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NieuwProject extends AsyncTask<String, String, String> {

    String toastBericht;
    Context context;

    private static final String DB_URL = "jdbc:mysql://10.0.2.2:3306/scrumapp?useSSL=false";
    private static final String USER = "ScrumApp";
    private static final String PASS = "database";

    String naamVanProject = ProjectAanmaken.naamVanProject.getText().toString();
    String beschVanProject = ProjectAanmaken.beschrijvingVanProject.getText().toString();
    String scrmaVanProject = ProjectAanmaken.scrumMasterVanProject.getText().toString();

    public NieuwProject(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            if(con == null){
                toastBericht = "Geen connectie met de database.";
            }else{
                Statement statement = con.createStatement();
                String query = "insert into scrumapp.project (prnaam, besch, prown, scrma) values ('" + naamVanProject + "', '" + beschVanProject + "', '" + MainActivity.huidigeGebruiker.getEmail() + "', '" + scrmaVanProject + "')";
                statement.executeUpdate(query);
                toastBericht = "Nieuw project aangemaakt.";
            }
            con.close();
        }catch (Exception e){
            toastBericht = "Er is een fout opgetreden.";
            e.printStackTrace();
        }
        return toastBericht;
    }

    protected void onPostExecute(String s){
        Toast.makeText(context, toastBericht, Toast.LENGTH_LONG).show();
        if(toastBericht.equals("Nieuw project aangemaakt.")){
            ProjectAanmaken.naamVanProject.getText().clear();
            ProjectAanmaken.beschrijvingVanProject.getText().clear();
            ProjectAanmaken.scrumMasterVanProject.getText().clear();
        }
        DashboardActivity.projectenLijst.clear();
        ProjectenOphalen projectenOphalen = new ProjectenOphalen(context);
        projectenOphalen.execute();
        toastBericht = "";
    }
}
