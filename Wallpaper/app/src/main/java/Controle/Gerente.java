package Controle;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.util.ArrayList;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lucas on 15/06/17.
 */

public final class Gerente {
    private static final Gerente ourInstance = new Gerente();
    private static WallpaperManager gerenteWallpaper = WallpaperManager.getInstance(null);
    private static final GerenteLastFM gerenteLastFM = new GerenteLastFM();
    private int i = 0;
    public String username;

    public static Gerente getInstance() {
      return ourInstance;
    }

    private Gerente()
    {
    }


    /**
     Esse método recebe uma imagem e o contexto,
     Vai ser público pq o usuário pode definir qual wallpaper vai querer
     **/
    public void trocarWallpaper(Context contexto, Bitmap imagem)
    {
        gerenteWallpaper = WallpaperManager.getInstance(contexto);
        try {
            gerenteWallpaper.setBitmap(imagem);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void trocarArtistaACada10Minutos(Context contexto, String user)
    {
        trocarAutomaticamente(10, contexto, pegarImagensTop10Artista(user));
    }

    public void trocarArtistaACada30Minutos(Context contexto, String user)
    {
        trocarAutomaticamente(30, contexto, pegarImagensTop10Artista(user));
    }

    public void trocarArtistaACada60Minutos(Context contexto, String user)
    {
        trocarAutomaticamente(60, contexto, pegarImagensTop10Artista(user));
    }

    public void trocarAlbumACada10Minutos(Context contexto, String user)
    {
        trocarAutomaticamente(10, contexto, pegarImagensTop10Album(user));
    }

    public void trocarAlbumACada30Minutos(Context contexto, String user)
    {
        trocarAutomaticamente(30, contexto, pegarImagensTop10Album(user));
    }

    public void trocarAlbumACada60Minutos(Context contexto, String user)
    {
        trocarAutomaticamente(60, contexto, pegarImagensTop10Album(user));
    }




    /**Esse vai ser privado pq vai definir quando irá ser a troca de wallpaper
     *
     *
     */
    private void trocarAutomaticamente(int tempo, Context contexto, ArrayList<Bitmap> imagens)
    {
        final long milissegundos = tempo * 60 * 1000;

       Timer timer = new Timer();
        final TimerTask tarefa = new TimerTask() {
            @Override
            public void run()
            {

            }

            private void atualizar(int i)
            {

            }
        };

        timer.scheduleAtFixedRate(tarefa, 0, milissegundos);

        if(tarefa.equals((milissegundos)))
        {
            trocarWallpaper(contexto, imagens.get(i));
            if(i < 10)
            {
                i++;
            } else
            {
                i = 0;
            }

            trocarAutomaticamente(tempo, contexto, imagens);
        }
    }

    private ArrayList<Bitmap> pegarImagensTop10Artista(String user)
    {
        ArrayList<String> Lista = gerenteLastFM.pegarTop10Artista(user);
        ArrayList<Bitmap> listaIMG = new ArrayList<Bitmap>();
        int i = 0;

        while(Lista.iterator().hasNext())
        {
            listaIMG.add(BitmapFactory.decodeFile(Lista.get(i)));
            i++;
        }

        return listaIMG;
    }

    private ArrayList<Bitmap> pegarImagensTop10Album(String user)
    {
        ArrayList<String> Lista = gerenteLastFM.pegarTop10Album(user);
        ArrayList<Bitmap> listaIMG = new ArrayList<Bitmap>();
        int i = 0;

        while(Lista.iterator().hasNext())
        {
            listaIMG.add(BitmapFactory.decodeFile(Lista.get(i)));
            i++;
        }

        return listaIMG;
    }


    public boolean testarUser()
    {
        if(pegarImagensTop10Album(username) == null)
            return false;

        return true;
    }

    public void setUser(String user)
    {
        this.username = user;
    }
}
