package com.login.chayo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.etUsername);
        passwordEditText = findViewById(R.id.etPassword);
        loginButton = findViewById(R.id.btnLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Perform login validation or logic here
                if (username.equals("chayo") && password.equals("123")) {
                    //inicio de sesion exitosa
                    Toast.makeText(MainActivity.this, "Datos correctos", Toast.LENGTH_SHORT).show();
                    // Navigate to the next activity or perform other actions
                    // Dentro del bloque if (username.equals("chayo") && password.equals("123"))

                    Intent intent = new Intent(MainActivity.this, Activity_menu.class);
                    startActivity(intent);
                } else {
                    //inicio de sesion fallida
                    Toast.makeText(MainActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}