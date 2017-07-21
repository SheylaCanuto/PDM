package br.edu.ifpe.tads.pdm.she.wallpaper;

        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.preference.PreferenceActivity;
        import android.preference.PreferenceFragment;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
        import android.view.MenuItem;
        import android.widget.TextView;

        import Controle.Gerente;

public class SettingsActivity extends PreferenceActivity {

    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_opcoes);
       // definirConfiguracoes();

        //getFragmentManager().beginTransaction().replace(android.R.id.content,new SetFrag()).commit();

        setContentView(R.layout.activity_settings);



    }

//    private void definirConfiguracoes()
//    {
//        Context contexto = this;
//        Gerente gerente = Gerente.getInstance();
//        SharedPreferences pref = contexto.getSharedPreferences("MudarWallpaperTempo", Context.MODE_PRIVATE);
//
//        if(pref.getBoolean("MudarWallpaperTempo", "10min") == true)
//        {
//            gerente.trocarAlbumACada10Minutos(this, (TextView) R.id.user_name);
//        }
//    }
//    public static class SetFrag extends PreferenceFragment{
//    //@Override
//    public void OnCreate(Bundle savedInstanceState){
//        super.OnCreate(savedInstanceState);
//        addPreferencesFromResource(R.xml.pref_opcoes);
//
//        }




    public boolean OnOpitionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home) {
            startActivity(new Intent(SettingsActivity.this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);

    }


}

