package no.hvl.data102.filmarkiv.impl;

public class Film {
    private int filmnr;
    private String filmskaper;
    private String filmnavn;
    private Sjanger sjanger;
    private String filmselskap;

    public Film() {}

    public Film(int filmnr, String filmskaper, String filmnavn, Sjanger sjanger, String filmselskap) {
        this.filmnr = filmnr;
        this.filmskaper = filmskaper;
        this.filmnavn = filmnavn;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }

    public int getFilmnr() {
        return filmnr;
    }

    void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public String getFilmskaper() {
        return filmskaper;
    }

    void setFilmskaper(String filmskaper) {
        this.filmskaper = filmskaper;
    }

    public String getFilmnavn() {
        return filmnavn;
    }

    void setFilmnavn(String filmnavn) {
        this.filmnavn = filmnavn;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Film other = (Film) obj;
        return this.filmnr == other.filmnr;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(filmnr);
    }
}
