package br.edu.ifpe.tads.pdm.she.wallpaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Controle.Gerente;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText username = (EditText)findViewById(R.id.user_name);
        Button btn=(Button)findViewById(R.id.button_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user;
                String username;
                user = (EditText) findViewById(R.id.user_name);
                username = user.getText().toString();

                Gerente gerente = Gerente.getInstance();
                gerente.setUser(username);

                if (gerente.username == null || gerente.testarUser() == false){

                    Toast.makeText(getApplication(),"Username  não encontrado", Toast.LENGTH_LONG).show();
                }else{
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("Username", username);
                startActivity(intent);
                finish();
                }
            }
        });
    }
}
