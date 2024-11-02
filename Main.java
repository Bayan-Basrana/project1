import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println(" Welcome , to my game XO ");
        System.out.println(" First of all , let us knew your name  ");
        String name = input.nextLine();

        System.out.println(" Hallo " + name + " lets Start our game");
        int userWine =0;
        int computerWine=0;
        System.out.println("Choose an option : \n1-play one round\n2-play best of 3 rounds");
        int choice= input.nextInt();
        int roundsToPlay =choice==2?3:1;
        for(int round =1; round<=roundsToPlay;round++){
            System.out.println("Starting round "+ round);
        System.out.println(" This is The Game bord ,");
        String[][] bord = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };
        printBord(bord);

        String letter = "";

        do {
            System.out.println(" chose X or O To began the game ");
            letter = input.next();

            if (letter.equalsIgnoreCase("x")) {
                System.out.println("your choice is X " +
                        "so, I will play with O");
                break;
            } else if (letter.equalsIgnoreCase("o")) {
                System.out.println("your choice is O " +
                        "so, I will play with X");
                break;
            } else if (letter.equalsIgnoreCase("end")) {
                break;
            } else
                System.out.println(" wrong choise");

        } while (!letter.equalsIgnoreCase("end"));

        boolean gameOngoing = true;

        while (gameOngoing) {
            System.out.println("now, chose a position ");
            String position = input.next();
            updateBoard(bord, position, letter);
            printBord(bord);
            if (checkWinner(bord, letter)) {
                System.out.println("Congratulations " + name + ", you won!");
                userWine++;
                gameOngoing = false;
                break;
            }

            if (isBordFull(bord)) {
                System.out.println("It's a tie!");
                break;
            }


            boolean validMove = false;
            System.out.println("Now my turn, my choice will be: ");
            String computer = computerLetter(letter);
            computerTurn(bord,  computer);

            if (checkWinner(bord, computer)) {
                System.out.println("Computer won!");
                computerWine ++;
                gameOngoing = false;
            }

            // Check for a tie after computer's move
            if (isBordFull(bord)) {
                System.out.println("It's a tie!");
                break;
            }

            if (choice == 2 && (computerWine == 2 || userWine == 2))
                break;
        }
        if (userWine > computerWine){
            System.out.println(" Congratulations "+name + " you are the winner");
        } else if (computerWine> userWine) {
            System.out.println(" Computer is the winner ! Better luck next time ");
        }
    }}

        public static void printBord (String[][]bord){
            System.out.println("--------------");
            for (int i = 0; i < 3; i++) {
                System.out.print(" | ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(bord[i][j] + " | ");
                }
                System.out.println();
                System.out.println("--------------");

            }}
            public static String computerLetter (String letter){
                String computer = "";
                if (letter.equalsIgnoreCase("x")) {
                    computer = "o";
                } else if (letter.equalsIgnoreCase("o")) {
                    computer = "x";
                }
                return computer;
            }
            public static boolean checkWinner (String[][]bord, String letter){
                // Check rows, columns, and diagonals
                for (int i = 0; i < 3; i++) {
                    if (bord[i][0].equals(letter) && bord[i][1].equals(letter) && bord[i][2].equals(letter))
                        return true;
                    if (bord[0][i].equals(letter) && bord[1][i].equals(letter) && bord[2][i].equals(letter))
                        return true;
                }
                if (bord[0][0].equals(letter) && bord[1][1].equals(letter) && bord[2][2].equals(letter))
                    return true;
                if (bord[0][2].equals(letter) && bord[1][1].equals(letter) && bord[2][0].equals(letter))
                    return true;
                return false;
            }


            public static boolean isBordFull (String[][]bord){
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!bord[i][j].equalsIgnoreCase("x") && !bord[i][j].equalsIgnoreCase("o"))
                            return false;
                    }
                }
                return true;
            }

    public static void computerTurn (String[][] bord, String computer) {
        Random ran = new Random();
        boolean vaidMove =false;
        while (!vaidMove){
            int randomNum =ran.nextInt(1,10);
            String position = String.valueOf(randomNum);
        switch (position) {
            case "1":

                if (!bord[0][0].equalsIgnoreCase("o")
                        && (!bord[0][0].equalsIgnoreCase("x"))) {
                    bord[0][0] = (computer);
                    vaidMove=true;
                printBord(bord);}

                break;
            case "2":
                if (!bord[0][1].equalsIgnoreCase("o")
                        && (!bord[0][1].equalsIgnoreCase("x"))) {
                    vaidMove=true;
                bord[0][1] = (computer);
                printBord(bord);}
                break;
            case "3":
                if (!bord[0][2].equalsIgnoreCase("o")
                        && (!bord[0][2].equalsIgnoreCase("x"))) {
                    vaidMove=true;
                bord[0][2] = (computer);
                printBord(bord);}
                break;
            case "4":
                if (!bord[1][0].equalsIgnoreCase("o")
                        && (!bord[1][0].equalsIgnoreCase("x"))) {
                    vaidMove=true;
                bord[1][0] = (computer);
                printBord(bord);}
                break;
            case "5":
                if (!bord[1][1].equalsIgnoreCase("o")
                        && (!bord[1][1].equalsIgnoreCase("x"))) {
                    vaidMove=true;
                bord[1][1] = (computer);
                printBord(bord);}
                break;
            case "6":
                if (!bord[1][2].equalsIgnoreCase("o")
                        && (!bord[1][2].equalsIgnoreCase("x"))) {
                    vaidMove=true;
                bord[1][2] = (computer);
                printBord(bord);}
                break;
            case "7":
                if (!bord[2][0].equalsIgnoreCase("o")
                        && (!bord[2][0].equalsIgnoreCase("x"))) {
                    vaidMove=true;
                bord[2][0] = (computer);
                printBord(bord);}
                break;
            case "8":
                if (!bord[2][1].equalsIgnoreCase("o")
                        && (!bord[2][1].equalsIgnoreCase("x"))) {
                    vaidMove=true;
                bord[2][1] = (computer);
                printBord(bord);}
                break;
            case "9":
                if (!bord[2][2].equalsIgnoreCase("o")
                        && (!bord[2][2].equalsIgnoreCase("x"))) {
                    vaidMove=true;
                bord[2][2] = (computer);
                printBord(bord);}
                break;
        }}
        System.out.println(" computer Chose position " + (vaidMove?computer:"no valid "));
        printBord(bord);
    }

            public static void updateBoard (String[][]bord, String position, String letter){
                switch (position) {
                    case "1":
                        if (bord[0][0].equalsIgnoreCase("o")
                                || (bord[0][0].equalsIgnoreCase("x"))) {
                            System.out.println(" position unavailable");
                        } else
                            bord[0][0] = letter;
                        break;
                    case "2":
                        if (bord[0][1].equalsIgnoreCase("o")
                                || (bord[0][1].equalsIgnoreCase("x"))) {
                            System.out.println(" position unavailable");
                        } else
                            bord[0][1] = letter;
                        break;
                    case "3":
                        if (bord[0][2].equalsIgnoreCase("o")
                                || (bord[0][2].equalsIgnoreCase("x"))) {
                            System.out.println(" position unavailable");
                        } else
                            bord[0][2] = letter;
                        break;
                    case "4":
                        if (bord[1][0].equalsIgnoreCase("o")
                                || (bord[1][0].equalsIgnoreCase("x"))) {
                            System.out.println(" position unavailable");
                        } else
                            bord[1][0] = letter;
                        break;
                    case "5":
                        if (bord[1][1].equalsIgnoreCase("o")
                                || (bord[1][1].equalsIgnoreCase("x"))) {
                            System.out.println(" position unavailable");
                        } else
                            bord[1][1] = letter;
                        break;
                    case "6":
                        if (bord[1][2].equalsIgnoreCase("o")
                                || (bord[1][2].equalsIgnoreCase("x"))) {
                            System.out.println(" position unavailable");
                        } else
                            bord[1][2] = letter;
                        break;
                    case "7":
                        if (bord[2][0].equalsIgnoreCase("o")
                                || (bord[2][0].equalsIgnoreCase("x"))) {
                            System.out.println(" position unavailable");
                        } else
                            bord[2][0] = letter;
                        break;
                    case "8":
                        if (bord[2][1].equalsIgnoreCase("o")
                                || (bord[2][1].equalsIgnoreCase("x"))) {
                            System.out.println(" position unavailable");
                        } else
                            bord[2][1] = letter;
                        break;
                    case "9":
                        if (bord[2][2].equalsIgnoreCase("o")
                                || (bord[2][2].equalsIgnoreCase("x"))) {
                            System.out.println(" position unavailable");
                        } else
                            bord[2][2] = letter;
                        break;

                }
            }

        }
