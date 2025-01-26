package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

public class FilmarkivMain {
    public static void main(String[] args) {
        FilmarkivADT filmarkiv = new Filmarkiv(100);
        Meny meny = new Meny(filmarkiv);
        meny.start();
    }
}
