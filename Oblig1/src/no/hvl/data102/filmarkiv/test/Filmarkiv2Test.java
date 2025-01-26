package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Filmarkiv2Test {
    Filmarkiv2 arkiv;

    Filmarkiv2Test() {
        this.arkiv = new Filmarkiv2();
        Film film1 = new Film(12, "Steven Spielberg", "Jurassic Park", Sjanger.ACTION, "Universal Pictures");
        Film film2 = new Film(25, "Christopher Nolan", "Inception", Sjanger.THRILLER, "Warner Bros.");
        Film film3 = new Film(1, "Peter Jackson", "The Lord of the Rings: The Fellowship of the Ring", Sjanger.ACTION, "New Line Cinema");
        Film film4 = new Film(2, "Peter Jackson", "The Lord of the Rings: The Two Towers", Sjanger.ACTION, "New Line Cinema");
        Film film5 = new Film(3, "Peter Jackson", "The Lord of the Rings: The Return of the King", Sjanger.ACTION, "New Line Cinema");

        arkiv.leggTilFilm(film1);
        arkiv.leggTilFilm(film2);
        arkiv.leggTilFilm(film3);
        arkiv.leggTilFilm(film4);
        arkiv.leggTilFilm(film5);
    }

    @Test
    public void testLeggTilFilm() {
        Film film = new Film(42, "Quentin Tarantino", "Pulp Fiction", Sjanger.ACTION, "Miramax Films");
        arkiv.leggTilFilm(film);
        assertEquals(6, arkiv.antall(), "Did not add film correctly");
    }

    @Test
    public void testFinnFilm() {
        Film film = arkiv.finnFilm(12);
        assertEquals("Jurassic Park", film.getFilmnavn(), "Did not find correct film");
    }

    @Test
    public void testSlettFilm() {
        arkiv.slettFilm(12);
        assertNull(arkiv.finnFilm(12), "Did not delete film correctly");
    }

    @Test
    public void testSoekTittel() {
        Film[] filmer = arkiv.soekTittel("The Lord of the Rings");
        assertEquals(3, filmer.length, "Did not find correct number of films");
    }

    @Test
    public void testSoekProdusent() {
        Film[] filmer = arkiv.soekProdusent("Peter Jackson");
        assertEquals(3, filmer.length, "Did not find correct number of films");
    }

    @Test
    public void testAntallSjanger() {
        assertEquals(4, arkiv.antall(Sjanger.ACTION), "Did not find correct number of films");
    }
}
