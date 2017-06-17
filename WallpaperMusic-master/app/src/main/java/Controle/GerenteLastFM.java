package Controle;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import de.umass.lastfm.Album;
import de.umass.lastfm.Artist;
import de.umass.lastfm.ImageSize;
import de.umass.lastfm.User;

/**
 * Created by lucas on 15/06/17.
 */

public class GerenteLastFM
{
    private static final String chave = "1f8c625c96ed108182332fa5a21856ef";

    public ArrayList<String> pegarTop10Artista(String user)
    {
        Collection<Artist> Lista = User.getTopArtists(user,chave);
        ImageSize tamanho = ImageSize.HUGE;
        ArrayList<String> Artistas = new ArrayList<>();
        int i = 0;

        while(Lista.iterator().hasNext() && i < 10)
        {
           Artistas.add(Lista.iterator().next().getImageURL(tamanho));
            i++;
        }

        return Artistas;
    }

    public ArrayList<String> pegarTop10Album(String user)
    {
        Collection<Artist> Lista = User.getTopArtists(user,chave);
        ImageSize tamanho = ImageSize.HUGE;
        ArrayList<String> Albuns = new ArrayList<>();
        int i = 0;

        while(Lista.iterator().hasNext() && i < 10)
        {
            Albuns.add(Lista.iterator().next().getImageURL(tamanho));
            i++;
        }

        return Albuns;
    }
    
}
