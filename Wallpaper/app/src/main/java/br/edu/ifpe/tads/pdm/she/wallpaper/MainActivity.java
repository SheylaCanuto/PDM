
package br.edu.ifpe.tads.pdm.she.wallpaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import Controle.Gerente;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mToolbar = (Toolbar)findViewById(R.id.tb_main);
//        //mToolbar.setTitle("Musical Wallpaper");
//        //mToolbar.setSubtitle("just a subtitle");
//        setSupportActionBar(mToolbar);


        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Intent intent = new Intent();
        intent.getStringExtra("Username");
        Gerente gerente = Gerente.getInstance();
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menu_conf){
            startActivity(new Intent(this, SettingsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
