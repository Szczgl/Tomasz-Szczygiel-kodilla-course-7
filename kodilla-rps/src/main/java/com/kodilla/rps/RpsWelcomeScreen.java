package com.kodilla.rps;

import java.util.Scanner;

public class RpsWelcomeScreen {

    private String userName;
    private int numberOfWin;

    Scanner scanner = new Scanner(System.in);

    public String getUserName() {
        return userName;
    }

    public int getNumberOfWin() {
        return numberOfWin;
    }

    public void userName() {
        System.out.println("\nGra w papier, nożyce, kamień, jaszczurke, Spocka\n");
        System.out.print("Podaj swoje imie: ");
        userName = scanner.nextLine();
        System.out.println("\nWitaj " + userName + "\n");
        numberOfWin();
    }

    public void numberOfWin() {
        System.out.print("Podaj do ilu wygranych gramy: ");
        numberOfWin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("OK " + userName + " gramy do " + numberOfWin + " wygranych");

    }
}
