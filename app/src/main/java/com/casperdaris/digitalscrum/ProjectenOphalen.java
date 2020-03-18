package com.casperdaris.digitalscrum;

import android.content.Context;
import android.os.AsyncTask;

import com.casperdaris.digitalscrum.Objecten.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProjectenOphalen extends AsyncTask<String, String, String> {

    Context context;

    private static final String DB_URL = "jdbc:mysql://10.0.2.2:3306/scrumapp?useSSL=false";
    private static final String USER = "ScrumApp";
    private static final String PASS = "database";

    String email;

    public ProjectenOphalen(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        try{
            //Connectie proberen aan te maken met de database
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = con.createStatement();
            email = MainActivity.huidigeGebruiker.getEmail();

            //De projecten die hieronder worden opgehaald worden geplaatst in de ArrayList(projectenLijst) in de DashboardActivity

            //Projecten ophalen uit de database waar de gebruiker Project Owner is
            String prownQuery = "select * from ScrumApp.project where prown = '" + email + "'";
            ResultSet prownResult = statement.executeQuery(prownQuery);
            while(prownResult.next()){
                DashboardActivity.projectenLijst.add(new Project(prownResult.getInt("prid"), prownResult.getInt("sprnr"), prownResult.getInt("sprlt"), prownResult.getString("prnaam"), prownResult.getString("besch"), prownResult.getString("prown"), prownResult.getString("scrma")));
            }

            //Projecten ophalen uit de database waar de gebruiker Scrum Master is
            String scrmaQuery = "select * from ScrumApp.project where scrma = '" + email + "'";
            ResultSet scrmaResult = statement.executeQuery(scrmaQuery);
            while(scrmaResult.next()){
                DashboardActivity.projectenLijst.add(new Project(scrmaResult.getInt("prid"), scrmaResult.getInt("sprnr"), scrmaResult.getInt("sprlt"), scrmaResult.getString("prnaam"), scrmaResult.getString("besch"), scrmaResult.getString("prown"), scrmaResult.getString("scrma")));
            }

            //Projecten ophalen uit de database waar de gebruiker developer is
            String devQuery = "select * from ScrumApp.project where prid in (select prid from ScrumApp.gebruiker_is_developer where email = '" + email + "')";
            ResultSet devResult = statement.executeQuery(devQuery);
            while(devResult.next()){
                DashboardActivity.projectenLijst.add(new Project(devResult.getInt("prid"), devResult.getInt("sprnr"), devResult.getInt("sprlt"), devResult.getString("prnaam"), devResult.getString("besch"), devResult.getString("prown"), devResult.getString("scrma")));
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return email;
    }
}
