package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
    public Film lesFilm(int filmnr, String filmskaper, String filmnavn, Sjanger sjanger, String filmselskap) {
        System.out.println("La til film:");
        System.out.println("Filmnr: " + filmnr);
        System.out.println("Filmskaper: " + filmskaper);
        System.out.println("Filmnavn: " + filmnavn);
        System.out.println("Sjanger: " + sjanger);
        System.out.println("Filmselskap: " + filmselskap + "\n");
        return new Film(filmnr, filmskaper, filmnavn, sjanger, filmselskap);
    }

    public void skrivUtFilm(Film film) {
        System.out.println("Navn: " + film.getFilmnavn());
        System.out.println("Skaper: " + film.getFilmskaper());
        System.out.println("Sjanger: " + film.getSjanger());
        System.out.println("Selskap: " + film.getFilmselskap() + "\n");
    }

    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekTittel(delstreng);

        if (filmer.length == 0) {
            System.out.println("Fant ingen filmer med delstrengen \"" + delstreng + "\"\n");
            return;
        }
        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }

    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String produsent) {
        Film[] filmer = arkiv.soekProdusent(produsent);

        if (filmer.length == 0) {
            System.out.println("Fant ingen filmer med produsenten \"" + produsent + "\"\n");
            return;
        }
        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }

    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        int antallFilmer = arkiv.antall();
        int[] antallSjanger = new int[Sjanger.values().length];

        for (int i = 0; i < Sjanger.values().length; i++) {
            antallSjanger[i] = arkiv.antall(Sjanger.values()[i]);
        }

        System.out.println("Antall filmer: " + antallFilmer);

        for (int i = 0; i < Sjanger.values().length; i++) {
            System.out.println(Sjanger.values()[i] + ": " + antallSjanger[i]);
        }

        System.out.println();
    }
}
