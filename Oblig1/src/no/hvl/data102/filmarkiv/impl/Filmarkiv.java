package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
    private Film[] filmer;
    private int nesteLedige;

    public Filmarkiv(int antall) {
        this.filmer = new Film[antall];
        nesteLedige = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        for (Film film : filmer) {
            if (film.getFilmnr() == nr) {
                return film;
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        filmer[nesteLedige] = nyFilm;
        nesteLedige++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < nesteLedige; i++) {
            if (filmer[i].getFilmnr() == filmnr) {
                for (int j = i; j < nesteLedige - 1; j++) {
                    filmer[j] = filmer[j + 1];
                }
                nesteLedige--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] filmerMedDelstreng = new Film[filmer.length];
        int antall = 0;

        for (Film film : filmer) {
            if (film == null) {
                break;
            }
            String filmnavn = film.getFilmnavn().toLowerCase();
            if (filmnavn.contains(delstreng.toLowerCase())) {
                filmerMedDelstreng[antall] = film;
                antall++;
            }
        }
        return trimTab(filmerMedDelstreng, antall);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] filmerMedDelstreng = new Film[filmer.length];
        int antall = 0;

        for (Film film : filmer) {
            if (film == null) {
                break;
            }
            String filmskaper = film.getFilmskaper().toLowerCase();
            if (filmskaper.contains(delstreng.toLowerCase())) {
                filmerMedDelstreng[antall] = film;
                antall++;
            }
        }
        return trimTab(filmerMedDelstreng, antall);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int antall = 0;
        for (Film film : filmer) {
            if (film.getSjanger() == sjanger) {
                antall++;
            }
        }
        return antall;
    }

    @Override
    public int antall() {
        return nesteLedige;
    }

    private Film[] trimTab(Film[] tab, int n) {
        Film[] nytab = new Film[n];
        int i = 0;
        while (i < n) {
            nytab[i] = tab[i];
            i++;
        }
        return nytab;
    }
}
