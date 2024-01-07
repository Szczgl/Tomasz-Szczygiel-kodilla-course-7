package com.kodilla.rps;

import com.kodilla.rps.common.Dane;
import com.kodilla.rps.common.DaneObsluga;
import com.kodilla.rps.enums.UserChoice;

import java.util.Random;
import java.util.Scanner;

public class RpsGame {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private String computerChoiceString;

    private final RpsWelcomeScreen rpsWelcomeScreen = new RpsWelcomeScreen();
    private RpsResults rpsResults;

    public RpsGame() {
        startGame();
    }

    public void startGame() {
        rpsWelcomeScreen.userName();
        rpsResults = new RpsResults(rpsWelcomeScreen.getUserName(), rpsWelcomeScreen.getNumberOfWin());
        game();
    }

    public void game() {

        while (!rpsResults.end) {
            System.out.println("\nklawisz 1 - kamień");
            System.out.println("klawisz 2 - jaszczurka");
            System.out.println("klawisz 3 - Spock");
            System.out.println("klawisz 4 - nożyce");
            System.out.println("klawisz 5 - papier");
            System.out.println("\nklawisz x - koniec gry");
            System.out.println("klawisz n - nowa gra\n");

            System.out.print("Wybierz swoj ruch: ");
            String strUserChoice = scanner.nextLine();

            int intValue;
            try {
                intValue = Integer.parseInt(strUserChoice);
            } catch (Exception ex) {
                intValue = UserChoice.fromString(strUserChoice);
            }


            UserChoice userChoice = UserChoice.fromInt(intValue);

            switch (userChoice) {
                case KAMIEN:
                    print("kamień");
                    zrobRuch(strUserChoice);
                    break;
                case JASZCZURKA:
                    print("jaszurkę");
                    zrobRuch(strUserChoice);
                    break;
                case SPOCK:
                    print("Spocka");
                    zrobRuch(strUserChoice);
                    break;
                case NOZYCE:
                    print("nożyce");
                    zrobRuch(strUserChoice);
                    break;
                case PAPIER:
                    print("papier");
                    zrobRuch(strUserChoice);
                    break;
                case ZAKONCZ:
                    System.out.print("Czy napewno zakończyć grę t/n ");
                    sprawdzZakonczenie();
                    break;
                case ZAKONCZIROZPOCZNIJ:
                    System.out.print("Czy napewno zakończyć aktualną grę i zacząć nową t/n ");
                    zakonczenieIRozpoczecie();
                    break;
                default:
                    System.out.println("Niepoprawny wybór");
                    break;

            }

        }
    }

    private void zrobRuch(String strUserChoice) {
        computerMove();
        rpsResults.resultChoice(strUserChoice, computerChoiceString);
    }

    private void zakonczenieIRozpoczecie() {
        String yesOrNot2;
        do {
            yesOrNot2 = scanner.nextLine();
            if (yesOrNot2.equals("t")) {
                rpsResults.setResultComputer(0);
                rpsResults.setResultUser(0);
                startGame();
            } else if (yesOrNot2.equals("n")) {
                game();
            } else {
                System.out.print("t/n ? ");
            }
        } while (!yesOrNot2.equals("t") && !yesOrNot2.equals("n"));
    }

    private void sprawdzZakonczenie() {
        String yesOrNot;
        do {
            yesOrNot = scanner.nextLine();
            if (yesOrNot.equals("t")) {
                rpsResults.end = true;
            } else if (yesOrNot.equals("n")) {
                game();
            } else {
                System.out.print("t/n ? ");
            }
        } while (!yesOrNot.equals("t") && !yesOrNot.equals("n"));
    }

    public void computerMove() {
        int computerChoice = random.nextInt(1, 5);
        switch (computerChoice) {
            case 1:
                System.out.println("komputer wybrał kamień");
                break;
            case 2:
                System.out.println("komputer wybrał jaszurkę");
                break;
            case 3:
                System.out.println("komputer wybrał Spocka");
                break;
            case 4:
                System.out.println("komputer wybrał nożyce");
                break;
            case 5:
                System.out.println("komputer wybrał papier");
                break;
        }
        computerChoiceString = Integer.toString(computerChoice);
    }

    private void print(String wybor) {
        System.out.print("Wybrałeś " + wybor + " a ");
    }
}
