
public abstract class Osoba {

	
	
	    private String ime;
	    private String prezime;

	    public String getIme() {
	        return ime;
	    }

	    public void setIme(String ime) {
	        this.ime = ime;
	    }

	    public String getPrezime() {
	        return prezime;
	    }

	    public void setPrezime(String prezime) {
	        this.prezime = prezime;
	    }

	    public Osoba(String ime, String prezime) {
	        this.setIme(ime);
	        this.setPrezime(prezime);
	    }

	    public Osoba() {}

	    public void stampaj() {
	        Main.print("Ime: " + getIme() + ", prezime: "  + getPrezime());
	    }
	}




