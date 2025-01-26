package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
    public Film lesFilm() {
        // TODO: Implement this method?
        // Funksjonen skal returnere et Film-objekt basert på input fra brukeren.
        // Vi har bare funksjoner for delsøk i tittel og produsent.
        // Vi kan lage flere, men dette blir utenfor oppgavens rammer.
        // Grunnet tilgjengelige metoder, er det svært sansynlig at resultate ikke blir unikt.
        // Slik som start metoden i Meny-klassen er implementert, ser jeg ikke noe bruk for denne metoden.
        return null;
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
