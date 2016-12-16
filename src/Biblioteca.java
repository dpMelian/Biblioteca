package Biblioteca;

/**
 * Created by dpMelian on 24/11/2016.
 */
import java.util.*;

public class Biblioteca {
    private Set<Album> biActual;

    public Biblioteca(){
        biActual =  new LinkedHashSet<>();
    }
    public void añadeÁlbum(Album a1){
        biActual.add(a1);
    }
    public Album dameÁlbum(String nombre){
        for(Album album : biActual){
            if(album.dameNombre().equals(nombre)){
                return album;
            }
        }
        return null;
    }
    public void eliminaÁlbum(String nombre){
        for(Album a : biActual){
            if(a.dameNombre().equals(nombre)){
                biActual.remove(a);
            }
        }
    }
    public Set<Cancion> dameCancionesRepetidas(){
        Set<Cancion> res = new HashSet<>();
        Set<Cancion> sinRepetir = new HashSet<Cancion>();
        List<Cancion> todasCanciones = new LinkedList<Cancion>();

        for(Album a1 : biActual){
            for(int i= 0; i < a1.númeroDeCanciones(); i++){
                todasCanciones.add(a1.dameCanción(i));
            }
        }
        for(Cancion c : todasCanciones) {
            if(!sinRepetir.add(c)) {
                res.add(c);
            }
        }
        System.out.println(res);
        return res;
    }
    public List<String> dameIntérpretes(){
        final Map<String, Integer> freq = new TreeMap<String, Integer>();

        List<Cancion> todasCanciones = new LinkedList<Cancion>();
        List<String> interpretes = new LinkedList<String>();

        for(Album a1 : biActual){
            for(int i= 0; i < a1.númeroDeCanciones(); i++){
                todasCanciones.add(a1.dameCanción(i));
            }
        }
        for(Cancion c : todasCanciones){
            interpretes.add(c.dameIntérprete());
        }
        for (String str : interpretes) {
            freq.put(str, 1 + (freq.containsKey(str) ? freq.get(str) : 0));
        }
        List<String> res = new ArrayList<String>(freq.keySet());
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                return freq.get(y) - freq.get(x);
            }
        });
        return res;
    }

    @Override
    public String toString(){
        String res = "";
        for(Album album : biActual){
            res+=album.toString() + "\n";
        }
        return res.substring(0, res.length()-1);
    }
}