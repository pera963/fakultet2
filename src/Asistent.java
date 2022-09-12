
public class Asistent extends Profesor {
    private int fondCasovaVezbi;



    public int getFondCasovaVezbi() {
        return fondCasovaVezbi;
    }

    public void setFondCasovaVezbi(int fondCasovaVezbi) {
        this.fondCasovaVezbi = fondCasovaVezbi;
    }

    public Asistent(String ime, String prezime, String predmet, boolean redovan, int fondCasovaVezbi) {
        super(ime, prezime, predmet, redovan);
        setFondCasovaVezbi(fondCasovaVezbi);
    }

    public void stampaj() {
        super.stampaj();
        Main.print("Fond casova vezbi: " + getFondCasovaVezbi());
    }

}
