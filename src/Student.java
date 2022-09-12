
public class Student extends Osoba {

    private String brIndeksa;
    private int godinaFakulteta;
    private boolean daLiJeNaBudzetu;

    public String getBrIndeksa() {
        return brIndeksa;
    }

    public void setBrIndeksa(String brIndeksa) {
        this.brIndeksa = brIndeksa;
    }

    public int getGodinaFakulteta() {
        return godinaFakulteta;
    }

    
    
    public void setGodinaFakulteta(int godinaFakulteta) {
        this.godinaFakulteta = godinaFakulteta;
    }

    public boolean isDaLiJeNaBudzetu() {
        return daLiJeNaBudzetu;
    }

    public void setDaLiJeNaBudzetu(boolean daLiJeNaBudzetu) {
        this.daLiJeNaBudzetu = daLiJeNaBudzetu;
    }

    public Student(String ime, String prezime, String brIndexa, int godinaFakulteta, boolean daLiJeNaBudzetu) {
        super(ime, prezime);
//        this.brIndeksa = brIndexa;
        setBrIndeksa(brIndexa);
        setGodinaFakulteta(godinaFakulteta);
        setDaLiJeNaBudzetu(daLiJeNaBudzetu);
    }

    @Override
    public void stampaj() {
        super.stampaj();
        Main.print("Broj indexa: " + getBrIndeksa() + " . Godina fakulteta: " + getGodinaFakulteta() + " . Budget = " + isDaLiJeNaBudzetu());
    }


}

