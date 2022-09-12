
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //TODO
    //Za vezbanje
    //1. Napisite metodu koja prebrojava samo redovne profesore i stampa ih na izlazu
    //2. Napisite metodu koja nalazi profesora i asistenta na istom predmetu, i stampa ih na izlazu
    //3. Napisite metodu koja, na osnovu indeksa Studenta, izdvaja njegovu godinu upisa i trazi sve studente upisane iste godine, stampa na izlazu
    // HINT: koristi se metoda split() iz klase String
    // U pocetku mogu metode biti void i da samo stampaju rezultate
    // Naprednija resenja mogu vracati nove nizove pa ih tek onda stampati koristeci postojecu metodu istampajNiz


    public static void main(String[] args) {
        //U main metodi koristimo samo pozive metoda
        //metoda koja ucitava iz konzole i izbacuje ArrayList niz osoba koje smo ucitali u njoj
        ArrayList<Osoba> nizOsoba = unosOsoba();
        //niz osoba koje smo ucitali sada prosledjujemo metodi istampajNiz
        istampajNiz(nizOsoba);
        //sada pozivamo metodu koja vraca broj redovnih studenata iz naseg ucitanog niza
        int brojRedovnih = vratiBrojRedovnihStudenata(nizOsoba);
        print("Broj redovnih studenata je " + brojRedovnih);
    }

    //static metoda koju koristimo da stampamo niz osoba
    public static void istampajNiz(ArrayList<Osoba> nizOsoba) {
        //for each petlja, koja dohvata jednu po jednu osobu iz niza
        for(Osoba osoba : nizOsoba) {
            //u zavisnosti koji je tip podklase , pozivamo metodu stampaj (ako je asistent onda je njegova stampaj metoda)
            osoba.stampaj();
        }
    }

    //Metoda za ucitavanje niza osoba iz konzole
    public static ArrayList<Osoba> unosOsoba() {
        //Kada imamo jednu super klasu i vise njenih podklasa, ovako mozemo napraviti niz od clanova superklase
        ArrayList<Osoba> nizOsoba = new ArrayList<>();

        while (true) {
            print("Unesite (S)tudenta, (P)rofesora, (A)sistenta, ili unesite 'stop' za prekid");
            //useDelimiter("\n") nam pomaze da ucitamo i Stringove koji sadrze razmak u sebi
            Scanner scanner = new Scanner(System.in);
            		//.useDelimiter("\n");
            String komanda = scanner.next();
            if(komanda.equals("stop")) break;
            String ime, prezime, brIndeksa, predmet;
            boolean daLiJeNaBudgetu, daLiJeRedovan;
            int godina, fondCasova;
            switch (komanda) {
                case "S" :
                    print("Unesi ime");
                    ime = scanner.next();
                    print("Unesi prezime");
                    prezime = scanner.next();
                    print("Unesi broj indeksa");
                    brIndeksa = scanner.next();
                    print("Unesi godinu na fakultetu");
                    godina = scanner.nextInt();
                    print("Unesi da li je na budgetu (true/false)");
                    daLiJeNaBudgetu = scanner.nextBoolean();
                    Student student = new Student(ime, prezime, brIndeksa, godina, daLiJeNaBudgetu);
                    //u slucaju da je osoba Student, onda kreiramo objekat te klase i dodajemo u niz
                    nizOsoba.add(student);
                    break;

                case "P" :
                    print("Unesi ime");
                    ime = scanner.next();
                    print("Unesi prezime");
                    prezime = scanner.next();
                    print("Unesi predmet");
                    predmet = scanner.next();
                    print("Unesi da li je redovan profesor (true/false)");
                    daLiJeRedovan = scanner.nextBoolean();
                    Profesor profesor = new Profesor(ime, prezime, predmet, daLiJeRedovan);
                    nizOsoba.add(profesor);
                    break;

                case "A" :
                    print("Unesi ime");
                    ime = scanner.next();
                    print("Unesi prezime");
                    prezime = scanner.next();
                    print("Unesi predmet");
                    predmet = scanner.next();
                    print("Unesi da li je redovan profesor (true/false)");
                    daLiJeRedovan = scanner.nextBoolean();
                    print("Unesi fond casova");
                    fondCasova = scanner.nextInt();
                    Asistent asistent = new Asistent(ime, prezime, predmet,daLiJeRedovan, fondCasova);
                    nizOsoba.add(asistent);
                    break;

                default: print("Nisi uneo dobar izbor"); break;
            }
        }
        return  nizOsoba;
    }


    //metoda koja prebrojava redovne studente, njoj prosledjujemo niz osoba
    public static int vratiBrojRedovnihStudenata(ArrayList<Osoba> nizOsoba) {
        //brojac
        int brojacRedovnihStudenata = 0;
        //for each petlja za dohvatanje svih clanova niza osoba
        for (Osoba osoba : nizOsoba) {
            //ovo je uslov koji proverava kog je tipa (pod klase) taj clan niza
            if(osoba instanceof Student) {
                // ((Student) osoba).isDaLiJeNaBudzetu() je java konstrukcija koja nam omogucava da nad objektom super klase pozovemo metodu iz Student klase
                //najcesce se koristi (u ovakvom slucaju) kada imamo niz koji prihvata sve objekte podklasa
                if(((Student) osoba).isDaLiJeNaBudzetu()) brojacRedovnihStudenata++;
            }
        }
        return brojacRedovnihStudenata;
    }

    //static metoda za stampanje
    public static void print(String s) {
        System.out.println(s);
    }

}
