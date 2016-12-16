package Biblioteca;

public class Cancion {
    private String título;
    private String intérprete;
    private int duración;

    public Cancion(String título, String intérprete, int duración) {
        this.título = título;
        this.intérprete = intérprete;
        this.duración = duración;
    }
    public String dameTítulo() {
        return título;
    }
    public String dameIntérprete() {
        return intérprete;
    }
    public int dameDuración() {
        return duración;
    }
    public String toString() {
        return "[Título:"+título+" intérprete:"+intérprete+" duración:"+duración+"]";
    }
    public boolean equals(Cancion c){
        if(título.equals(c.dameTítulo())){
            return true;
        }
        return false;
    }
}