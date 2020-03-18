package com.casperdaris.digitalscrum;

import android.content.Context;
import android.os.AsyncTask;

import com.casperdaris.digitalscrum.Objecten.BacklogItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BacklogOphalen extends AsyncTask<String, String, String> {

    Context context;

    private static final String DB_URL = "jdbc:mysql://10.0.2.2:3306/scrumapp?useSSL=false";
    private static final String USER = "ScrumApp";
    private static final String PASS = "database";

    String backlogOphalenString;

    public BacklogOphalen(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = con.createStatement();

            String backlogQuery = "select * from ScrumApp.backlogitem where prid = '" + DashboardActivity.huidigProject.getPrid() + "'";
            ResultSet backlogResult = statement.executeQuery(backlogQuery);
            while(backlogResult.next()){
                ProjectActivity.backlogItems.add(new BacklogItem(backlogResult.getInt("prid"), backlogResult.getInt("prio"), backlogResult.getString("itnm"), backlogResult.getString("itbes"), backlogResult.getString("stat"), backlogResult.getString("dev")));
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return backlogOphalenString;
    }
}
