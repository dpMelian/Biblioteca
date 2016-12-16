package Biblioteca;

/**
 * Created by dpMelian on 24/11/2016.
 */
import java.util.*;

public class Album {
    private String id;
    private List<Cancion> alActual;

    public Album(String id){
        this.id = id;
        alActual = new LinkedList<>();
    }
    public String dameNombre(){
        return this.id;
    }
    public int númeroDeCanciones(){
        return alActual.size();
    }
    public Cancion dameCanción(int p){
        if(p <= alActual.size() - 1){
            return alActual.get(p);
        }
        return null;
    }
    public void añadeCanción(Cancion c){
        alActual.add(c);
    }
    public void quitaCanción(int p){
        if(alActual.contains(p)){
            alActual.remove(p);
        }
    }
    public int duración(){
        int res = 0;
        for(Cancion cancion : alActual){
            res += cancion.dameDuración();
        }
        return res;
    }
    public Set<Cancion> isRepeated(){
        Set<Cancion> nonDuplicates = new HashSet<Cancion>(alActual);
        return nonDuplicates;
    }
    public List<Cancion> dameLista(Album a1){
        return a1.alActual;
    }
    @Override
    public String toString(){
        int count = 1;
        String res = this.id + ":\n";

        for(Cancion cancion : alActual){
            res += count + ") " + cancion.toString() + "\n";
            count++;
        }
        return res.substring(0, res.length()-1);
    }
}
