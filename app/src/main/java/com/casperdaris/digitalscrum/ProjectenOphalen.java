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
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = con.createStatement();
            email = MainActivity.huidigeGebruiker.getEmail();
            String query = "select * from ScrumApp.project where prid in (select prid from ScrumApp.gebruiker_is_developer where email = '" + email + "')";
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                DashboardActivity.projectenLijst.add(new Project(result.getInt("prid"),result.getInt("sprnr"),result.getInt("sprlt"),result.getString("prnaam"), result.getString("besch"), result.getString("prown"), result.getString("scrma")));
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return email;
    }
}
