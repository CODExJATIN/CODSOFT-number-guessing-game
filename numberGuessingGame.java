import java.util.Random;
import java.util.Scanner;

class randomNumber {
    private int input;
    private int randomNum;
    private int tries, score;

    private boolean isUserWon = false;

    public void newrandomNumber() {
        Random rd = new Random();
        int rndNum = rd.nextInt(100) + 1;
        randomNum = rndNum;
    }

    public int getRandomNum() {
        return randomNum;
    }

    public void takeUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER THE NUMBER YOU GUESSED: ");
        int userIn = sc.nextInt();
        input = userIn;
        tries++;
    }

    public void isCorrectNumber() {
        if (input == randomNum) {
            System.out.println("CONGRATULATIONS!!! , YOU GUESSED THE RIGHT NUMBER");
            System.out.println("YOU GUESSED THE RIGHT NUMBER IN " + tries + " Tries");
            score = 1000 - (tries * 100);
            System.out.println("Your score is " + score);
            isUserWon = true;
        } else {
            if (input < 0 || input > 100) {
                System.out.println("YOU ENTERED INVALID VALUE");
            } else if (input > randomNum) {
                System.out.println("THE NUMBER YOU GUESSED IS TOO LARGE");
            } else if (input < randomNum) {
                System.out.println("THE NUMBER YOU GUESSED IS TOO SMALL");
            }
        }
    }

    public int getTries() {
        return tries;
    }

    public int getInput() {
        return input;
    }

    public void help() {
        System.out.println("Game is simple: you just have to enter the number you guessed, and if it's correct, CONGRATULATIONS! You won.");
        System.out.println("If it's not correct, don't lose hope; give it another try, and you will get the correct one for sure.");
    }

    public void bestOf(int n) {
        int roundsWon = 0;
        System.out.println("HERE WE GO FOR THE BEST OF " + n);
        System.out.println("Rules are the same as before, just there are gonna be " + n + " rounds");
        for (int i = 0; i < n; i++) {
            newrandomNumber();
            System.out.println("\nROUND: " + (i + 1));
            tries = 0;
            while (tries<10 && !isUserWon) {
                takeUserInput();
                isCorrectNumber();
            }
            if(tries>=10){
                System.out.println("Sorry , you've reached maximum number of tries");
            }

            if (input == randomNum) {
                roundsWon++;
            }
            isUserWon = false;
        }
        if (roundsWon <= n / 2) {
            System.out.println("SORRY! You lost the best of " + n);
        } else {
            System.out.println("Congratulations, You Won");
            System.out.println("NUMBER OF ROUNDS YOU WON: " + roundsWon);
            System.out.println("YOUR SCORE: " + roundsWon * 1000);
        }
    }

    public void playSingleGame() {
        newrandomNumber();
        tries = 0;
        isUserWon = false;

        System.out.println("WELCOME TO NUMBER GUESSING GAME");
        help();

        while (!isUserWon) {
            if(tries>=10){
                System.out.println("Sorry , you've reached maximum number of tries");
                break;
            }
            else {
                takeUserInput();
                isCorrectNumber();
            }
        }
    }
}

public class numberGuessingGame {
    public numberGuessingGame() {
        randomNumber game = new randomNumber();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Single Game");
        System.out.println("2. Best of 3");
        System.out.println("3. Best of 5");
        int option = sc.nextInt();

        if (option == 1) {
            game.playSingleGame();
        } else if (option == 2) {
            game.bestOf(3);
        } else if (option == 3) {
            game.bestOf(5);
        } else {
            System.out.println("Invalid option. Exiting...");
        }
    }

    public static void main(String[] args) {
        new numberGuessingGame();
    }
}
