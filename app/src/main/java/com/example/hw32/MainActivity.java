package com.example.hw32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText etGmail, etUsername, etMassage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.send);
        etGmail = findViewById(R.id.et_gmail);
        etMassage = findViewById(R.id.et_text);
        etUsername = findViewById(R.id.et_username);
        btn.setOnClickListener(view -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "GGG@mail.com", null));
            emailIntent.putExtra(Intent.EXTRA_EMAIL, etGmail.getText().toString());
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, etUsername.getText().toString());
            emailIntent.putExtra(Intent.EXTRA_TEXT, etMassage.getText().toString());
            startActivity(Intent.createChooser(emailIntent, "Send Massage"));
        });
    }
}