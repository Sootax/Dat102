package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import no.hvl.data102.filmarkiv.impl.Film;
import java.util.Scanner;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        this.tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
        init();
    }

    private void init() {
        // Dette er for å simulere en database, så gjør det derfor enkelt.
        Film film1 = new Film(1, "Christopher Nolan", "Inception", Sjanger.ACTION, "Warner Bros.");
        Film film2 = new Film(2, "Christopher Nolan", "The Dark Knight", Sjanger.ACTION, "Warner Bros.");
        Film film3 = new Film(3, "Christopher Nolan", "Interstellar", Sjanger.ACTION, "Warner Bros.");
        Film film4 = new Film(4, "Christopher Nolan", "Dunkirk", Sjanger.ACTION, "Warner Bros.");
        Film film5 = new Film(5, "Peter Jackson", "The Lord of the Rings: The Fellowship of the Ring", Sjanger.ACTION, "New Line Cinema");
        Film film6 = new Film(6, "Peter Jackson", "The Lord of the Rings: The Two Towers", Sjanger.ACTION, "New Line Cinema");
        Film film7 = new Film(7, "Peter Jackson", "The Lord of the Rings: The Return of the King", Sjanger.ACTION, "New Line Cinema");
        Film film8 = new Film(8, "Peter Jackson", "The Hobbit: An Unexpected Journey", Sjanger.ACTION, "New Line Cinema");
        Film film9 = new Film(9, "Peter Jackson", "The Hobbit: The Desolation of Smaug", Sjanger.ACTION, "New Line Cinema");
        Film film10 = new Film(10, "Peter Jackson", "The Hobbit: The Battle of the Five Armies", Sjanger.ACTION, "New Line Cinema");
        Film film11 = new Film(11, "Steven Spielberg", "Jurassic Park", Sjanger.ACTION, "Universal Pictures");
        Film film12 = new Film(12, "Steven Spielberg", "Indiana Jones and the Raiders of the Lost Ark", Sjanger.ACTION, "Paramount Pictures");
        Film film13 = new Film(13, "Steven Spielberg", "E.T. the Extra-Terrestrial", Sjanger.ACTION, "Universal Pictures");

        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);
        filmarkiv.leggTilFilm(film3);
        filmarkiv.leggTilFilm(film4);
        filmarkiv.leggTilFilm(film5);
        filmarkiv.leggTilFilm(film6);
        filmarkiv.leggTilFilm(film7);
        filmarkiv.leggTilFilm(film8);
        filmarkiv.leggTilFilm(film9);
        filmarkiv.leggTilFilm(film10);
        filmarkiv.leggTilFilm(film11);
        filmarkiv.leggTilFilm(film12);
        filmarkiv.leggTilFilm(film13);
    }

    public void start() {
        boolean close = false;
        do {
            System.out.println("1. Søk etter tittel");
            System.out.println("2. Søk etter produsent");
            System.out.println("3. Skriv ut statistikk");
            System.out.println("4. Avslutt");
            System.out.println("\nVelg et alternativ: ");

            Scanner scanner = new Scanner(System.in);
            int valg = scanner.nextInt();
            scanner.nextLine();

            switch (valg) {
                case 1:
                    System.out.println("\nSkriv inn delstrengen du vil søke etter: ");
                    String delstreng = scanner.nextLine();
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, delstreng);
                    break;
                case 3:
                    System.out.println("\nSkriv inn produsenten du vil søke etter: ");
                    String produsent = scanner.nextLine();
                    tekstgr.skrivUtFilmProdusent(filmarkiv, produsent);
                    break;
                case 4:
                    tekstgr.skrivUtStatistikk(filmarkiv);
                    break;
                case 5:
                    close = true;
                    break;
                default:
                    System.out.println("\nUgyldig valg. Prøv igjen.");
                    break;
            }
        } while (close);
    }
}
