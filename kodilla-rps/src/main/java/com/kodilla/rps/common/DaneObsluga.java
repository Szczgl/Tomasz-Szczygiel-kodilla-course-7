package com.kodilla.rps.common;

public class DaneObsluga {
    private static final Dane data = new Dane();

    public static Dane getReference() {
        return data;
    }
}
