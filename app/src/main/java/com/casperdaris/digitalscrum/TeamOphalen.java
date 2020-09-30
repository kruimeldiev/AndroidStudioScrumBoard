package com.casperdaris.digitalscrum;

import android.content.Context;
import android.os.AsyncTask;

import com.casperdaris.digitalscrum.Objecten.Gebruiker;
import com.casperdaris.digitalscrum.Objecten.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TeamOphalen extends AsyncTask<String, String, String> {

    Context context;

    private static final String DB_URL = "jdbc:mysql://10.0.2.2:3306/scrumapp?useSSL=false";
    private static final String USER = "ScrumApp";
    private static final String PASS = "database";

    String testString;

    public TeamOphalen(Context context){
        this.context = context;
    }

    protected String doInBackground(String... string){
        try{
            //Connectie proberen aan te maken met de database
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = con.createStatement();

            //De gebruikers die hieronder worden opgehaald worden geplaatst in de ArrayList(teamLijst) in de TeamActivity

            //Gebruikers ophalen uit de database die lid zijn van het team van het geselecteerde project
            String devQuery = "select * from ScrumApp.gebruiker_is_developer where prid = " + DashboardActivity.huidigProject.getPrid();
            ResultSet devResult = statement.executeQuery(devQuery);
            while(devResult.next()){
                TeamActivity.teamLijst.add(new Gebruiker(devResult.getString("email"), devResult.getString("vnaam"), devResult.getString("anaam"), devResult.getString("wawo")));
            }

            //Gebruikers ophalen uit de database die lid zijn van het team van het geselecteerde project
            String prownQuery = "select email, vnaam, anaam from ScrumApp.gebruiker inner join ScrumApp.project on gebruiker.email = project.prown where prid = " + DashboardActivity.huidigProject.getPrid();
            ResultSet prownResult = statement.executeQuery(prownQuery);
            while(prownResult.next()){
                TeamActivity.teamLijst.add(new Gebruiker(prownResult.getString("email"), prownResult.getString("vnaam"), prownResult.getString("anaam"), ""));
            }

            //Gebruikers ophalen uit de database die lid zijn van het team van het geselecteerde project
            String scrmaQuery = "select email, vnaam, anaam from ScrumApp.gebruiker inner join ScrumApp.project on gebruiker.email = project.scrma where prid = " + DashboardActivity.huidigProject.getPrid();
            ResultSet scrmaResult = statement.executeQuery(scrmaQuery);
            while(scrmaResult.next()){
                TeamActivity.teamLijst.add(new Gebruiker(scrmaResult.getString("email"), scrmaResult.getString("vnaam"), scrmaResult.getString("anaam"), ""));
            }

            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return testString;
    }
}
