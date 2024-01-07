package com.kodilla.rps.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserChoice {
    KAMIEN(1),
    JASZCZURKA(2),
    SPOCK(3),
    NOZYCE(4),
    PAPIER(3),
    ZAKONCZ(4),
    ZAKONCZIROZPOCZNIJ(5),
    ;

    final int wartosc;
    UserChoice(int i) {
        wartosc = i;
    }

    public int getWartosc() {
        return wartosc;
    }

    public static int fromString(String i) {
        int result = 0;
        if (i.equals("x")) {
            result = 4;
        }
        if (i.equals("n")) {
            result = 5;
        }
        return result;
    }

    private static final Map<Integer, UserChoice> numberToChoiceMap = new HashMap<>();

    static {
        for (UserChoice userChoice : UserChoice.values()) {
            numberToChoiceMap.put(
                    userChoice.getWartosc(),
                    userChoice
            );
        }
    }

    public static UserChoice fromInt(int numWartosc) {
        return numberToChoiceMap.get(numWartosc);
    }
}
