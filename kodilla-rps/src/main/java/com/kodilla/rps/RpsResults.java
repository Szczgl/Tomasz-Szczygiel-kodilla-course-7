package com.kodilla.rps;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RpsResults {

    private int resultUser;
    private int resultComputer;
    private final String userName;
    private final int numberOfWin;
    public boolean end = false;

    private Map<String, List<String>> wygrywajaceKombinacje = new HashMap<>();


    public RpsResults(final String userName, final int numberOfWin) {
        this.userName = userName;
        this.numberOfWin = numberOfWin;

        wygrywajaceKombinacje.put("1", Arrays.asList("2", "4"));
        wygrywajaceKombinacje.put("2", Arrays.asList("3", "5"));
        wygrywajaceKombinacje.put("3", Arrays.asList("1", "4"));
        wygrywajaceKombinacje.put("4", Arrays.asList("2", "5"));
        wygrywajaceKombinacje.put("5", Arrays.asList("1", "3"));
    }

    public void setResultUser(int resultUser) {
        this.resultUser = resultUser;
    }

    public void setResultComputer(int resultComputer) {
        this.resultComputer = resultComputer;
    }

    public void resultChoice(String userChoice, String computerChoiceString) {

        List<String> kombinacje = wygrywajaceKombinacje.get(userChoice);
        if (userChoice.equals(computerChoiceString)) {
            System.out.println("Remis");
        } else if (kombinacje.contains(computerChoiceString)) {
            System.out.println(userName + " wygrywa rundę");
            resultUser++;
        } else {
            System.out.println("Komputer wygrywa rundę");
            resultComputer++;
        }

        System.out.println("Aktualny wynik (" + userName + ", Komputer): " + resultUser + ":" + resultComputer);
        System.out.println();
        if (numberOfWin == resultUser || numberOfWin == resultComputer) {
            if (resultUser > resultComputer) {
                System.out.println("Grę wygrywa " + userName + " wynikiem " + resultUser + ":" + resultComputer);
            } else {
                System.out.println("Grę wygrywa komputer wynikiem " + resultComputer + ":" + resultUser);
            }
            end = true;
        }
    }

}
