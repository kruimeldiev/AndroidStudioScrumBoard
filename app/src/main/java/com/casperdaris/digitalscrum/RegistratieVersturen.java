package com.casperdaris.digitalscrum;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RegistratieVersturen extends AsyncTask <String, String, String> {

    String toastBericht;
    Context context;

    private static final String DB_URL = "jdbc:mysql://10.0.2.2:3306/scrumapp?useSSL=false";
    private static final String USER = "ScrumApp";
    private static final String PASS = "database";

    String email = RegistreerActivity.emailRegiVeld.getText().toString();
    String wawo = RegistreerActivity.wawoRegiVeld.getText().toString();
    String wawoHer = RegistreerActivity.wawoRegiVeld2.getText().toString();
    String voornaam = RegistreerActivity.voornaamVeld.getText().toString();
    String achternaam = RegistreerActivity.achternaamVeld.getText().toString();

    public RegistratieVersturen(Context context){
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
                if(!wawo.equals(wawoHer)) {
                    toastBericht = "Wachtwoord combinatie onjuist.";
                }else if (email.length()<4){
                    toastBericht = "E-mail moet meer dan vier tekens hebben.";
                }else {
                    Statement statement = con.createStatement();
                    String query = "insert into scrumapp.gebruiker (email, wawo, vnaam, anaam) values ('" + email + "', '" + wawo + "', '" + voornaam + "', '" + achternaam + "')";
                    statement.executeUpdate(query);
                    toastBericht = "Nieuw account aangemaakt.";
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
        Toast.makeText(context, toastBericht, Toast.LENGTH_LONG).show();
    }
}