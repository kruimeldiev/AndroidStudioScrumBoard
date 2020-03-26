package com.casperdaris.digitalscrum;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.casperdaris.digitalscrum.Objecten.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class VerwijderProject extends AsyncTask<String, String, String> {

    String toastBericht;
    Context context;

    private static final String DB_URL = "jdbc:mysql://10.0.2.2:3306/scrumapp?useSSL=false";
    private static final String USER = "ScrumApp";
    private static final String PASS = "database";

    String naamVanProject = ProjectVerwijderen.naamVanProject.getText().toString();

    public VerwijderProject(Context context){
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
                String query = "delete from ScrumApp.Project where prnaam = '" + naamVanProject + "'";
                statement.executeUpdate(query);
                toastBericht = "Project verwijderd.";
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
        if(toastBericht.equals("Project verwijderd.")){
            ProjectAanmaken.naamVanProject.getText().clear();
        }
        toastBericht = "";
    }
}
