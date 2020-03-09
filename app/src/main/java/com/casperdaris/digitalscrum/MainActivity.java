package com.casperdaris.digitalscrum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static EditText emailVeld, wawoVeld;
    public static Button loginKnop, registreerKnop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailVeld = findViewById(R.id.emailVeld);
        wawoVeld = findViewById(R.id.wawoVeld);
        loginKnop = findViewById(R.id.loginKnop);
        registreerKnop = findViewById(R.id.registreerKnop);

        registreerKnop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RegistreerActivity.class);
                startActivity(intent);
            }
        });
    }
}
