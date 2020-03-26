package com.casperdaris.digitalscrum;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InlogVersturen extends AsyncTask<String, String, String> {

    String toastBericht;
    Context context;

    private static final String DB_URL = "jdbc:mysql://10.0.2.2:3306/scrumapp?useSSL=false";
    private static final String USER = "ScrumApp";
    private static final String PASS = "database";

    String email = MainActivity.emailVeld.getText().toString();
    String wawo = MainActivity.wawoVeld.getText().toString();

    //Context ophalen
    public InlogVersturen(Context context){
        this.context = context;
    }

    //Gegevens naar de database sturen om proberen in te loggen
    @Override
    protected String doInBackground(String... strings){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            if(con == null){
                toastBericht = "Geen connectie met de database.";
            }else{
                Statement statement = con.createStatement();
                String query = "select * from scrumapp.gebruiker where email = '" + email + "' and wawo = '" + wawo + "'";
                ResultSet result = statement.executeQuery(query);
                if(result.next()) {
                    toastBericht = "Login succesvol.";
                    MainActivity.huidigeGebruiker.setEmail(result.getString("email"));
                    MainActivity.huidigeGebruiker.setVnaam(result.getString("vnaam"));
                    MainActivity.huidigeGebruiker.setAnaam(result.getString("anaam"));
                    MainActivity.huidigeGebruiker.setWawo(result.getString("wawo"));

                    //Nieuwe activiteit openen wanneer de gegeven inlogdata kloppen
                    Intent intent = new Intent(context, DashboardActivity.class);
                    context.startActivity(intent);
                }else{
                    toastBericht = "E-mail of wachtwoord onjuist.";
                }
            }
            con.close();
        }catch (Exception e){
            toastBericht = "Er is een fout opgetreden.";
            e.printStackTrace();
        }
        return toastBericht;
    }

    protected void onPostExecute(String s){
        //Toastbericht maken
        Toast.makeText(context, toastBericht, Toast.LENGTH_LONG).show();
    }

}
