package com.casperdaris.digitalscrum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistreerActivity extends AppCompatActivity {

    static EditText emailRegiVeld, wawoRegiVeld, wawoRegiVeld2, voornaamVeld, achternaamVeld;
    static Button registreerRegiKnop, annuleerRegiKnop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registreer);

        emailRegiVeld = findViewById(R.id.emailRegiVeld);
        wawoRegiVeld = findViewById(R.id.wawoRegiVeld);
        wawoRegiVeld2 = findViewById(R.id.wawoRegiVeld2);
        voornaamVeld = findViewById(R.id.voornaamVeld);
        achternaamVeld = findViewById(R.id.achternaamVeld);
        registreerRegiKnop = findViewById(R.id.registreerRegiKnop);
        annuleerRegiKnop = findViewById(R.id.annuleerRegiKnop);

        //Activiteit sluiten en terug naar het login scherm
        annuleerRegiKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //Registratie versturen naar de MySQL database
        registreerRegiKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistratieVersturen registratieVersturen = new RegistratieVersturen(v.getContext());
                registratieVersturen.execute();
            }
        });
    }
}
