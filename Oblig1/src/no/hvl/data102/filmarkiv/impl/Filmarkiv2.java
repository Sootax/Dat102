package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
    private int antall;
    private LinearNode<Film> start;

    public Filmarkiv2() {
        this.antall = 0;
        this.start = null;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> current = start;

        while (current != null) {
            if (current.data.getFilmnr() == nr) {
                return current.data;
            }

            current = current.neste;
        }

        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> newNode = new LinearNode<>(nyFilm);
        newNode.neste = start;
        start = newNode;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if (start != null && start.data.getFilmnr() == filmnr) {
            start = start.neste;
            antall--;
            return true;
        }

        LinearNode<Film> current = start;

        while (current != null && current.neste != null) {
            if (current.neste.data.getFilmnr() == filmnr) {
                current.neste = current.neste.neste;
                antall--;
                return true;
            }

            current = current.neste;
        }

        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] filmerMedDelstreng = new Film[antall];
        int antall = 0;
        LinearNode<Film> current = start;

        while (current != null) {
            String filmnavn = current.data.getFilmnavn().toLowerCase();

            if (filmnavn.contains(delstreng.toLowerCase())) {
                filmerMedDelstreng[antall] = current.data;
                antall++;
            }

            current = current.neste;
        }

        return trimTab(filmerMedDelstreng, antall);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] filmerMedDelstreng = new Film[antall];
        int antall = 0;
        LinearNode<Film> current = start;

        while (current != null) {
            String produsent = current.data.getFilmskaper().toLowerCase();

            if (produsent.contains(delstreng.toLowerCase())) {
                filmerMedDelstreng[antall] = current.data;
                antall++;
            }

            current = current.neste;
        }

        return trimTab(filmerMedDelstreng, antall);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int antallSjanger = 0;
        LinearNode<Film> current = this.start;

        while (current != null) {
            if (current.data.getSjanger() == sjanger) {
                antallSjanger++;
            }
            current = current.neste;
        }

        return antallSjanger;
    }

    @Override
    public int antall() {
        return antall;
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
