package no.hvl.data102.filmarkiv.impl;

public enum Sjanger {
    ACTION, THRILLER, DRAMA, COMEDY, HORROR, ROMANCE, FANTASY, SCIFI, ANIMATION, DOCUMENTARY;

    public static Sjanger finnSjanger(String navn) {
        for (Sjanger s : Sjanger.values()) {
            if (s.toString().equalsIgnoreCase(navn)) {
                return s;
            }
        }
        return null;
    }
}
