package com.github.zipcodewilmington.casino.games.roulette;

import java.util.Random;
import java.util.Scanner;

public class GameRoulette {

//    public static void main(String[] args) {
//        GameRoulette game = new GameRoulette();
//        game.run();
//    }
    Scanner console = new Scanner(System.in);
    Random rand = new Random();

    int bank = 100;
    int max = bank;
    int spins = 0;
    public void run(){
        play();
        int bet = getBet();
        int choice = getChoice("What would you like to bet on?", "1. odd", "2. even");
        int spin = getSpin();
        compareResults(bet, choice, spin);
        spins++;
        quit();
    }
    public void play() {
        System.out.println("Welcome to Roulette!");

//        int bet = getChoice("You have $" + bank + " in your bank.", "The maximum amount you can bet is $" + max + ".", "How much would you like to bet?");
//        if (bet > max) {
//            System.out.println("You cannot bet more than $" + max + ".");
//            System.out.println("How much would you like to bet?");
//            bet = console.nextInt();
//        }



    }


    private void compareResults(int bet, int choice, int spin) {
        if (choice == 1) {
            if (spin % 2 == 1) {
//            if (spin == 1 || spin == 3 || spin == 5 || spin == 7 || spin == 9 || spin == 11 || spin == 13 || spin == 15 ||
//                    spin == 17 || spin == 19 || spin == 21 || spin == 23 || spin == 25 || spin == 27 || spin == 29 ||
//                    spin == 31 || spin == 33 || spin == 35 || spin == 37) {
                System.out.println("You win!");
                System.out.println("the spin was " + spin);
                bank = bank + bet;
                System.out.println("You now have $" + bank + " in your bank.");
            } else {
                System.out.println("You lose!");
                System.out.println("the spin was " + spin);
                bank = bank - bet;
                System.out.println("You now have $" + bank + " in your bank.");
            }
        } else if (choice == 2) {
            if (spin % 2 == 0) {
//            if (spin == 0 ||spin == 2 || spin == 4 || spin == 6 || spin == 8 || spin == 10 || spin == 12 || spin == 14 ||
//                    spin == 16 || spin == 18 || spin == 20|| spin == 22 || spin == 24|| spin == 26 || spin == 28
//                    || spin == 30 || spin == 32 || spin == 34 || spin == 36) {
                System.out.println("You win!");
                System.out.println("the spin was " + spin);
                bank = bank + bet;
                System.out.println("You now have $" + bank + " in your bank.");
            } else {
                System.out.println("You lose!");
                System.out.println("the spin was " + spin);
                bank = bank - bet;
                System.out.println("You now have $" + bank + " in your bank.");
            }
        }
    }

    private int getSpin() {
        int spin = rand.nextInt(38);
        return spin;
    }

    private int getChoice(String x, String x1, String x2) {
        System.out.println(x);
        System.out.println(x1);
        System.out.println(x2);

        int choice = console.nextInt();
        return choice;
    }

//    int bet = getChoice("You have $" + bank + " in your bank.", "The maximum amount you can bet is $" + max + ".", "How much would you like to bet?");
//        if (bet > max) {
//            System.out.println("You cannot bet more than $" + max + ".");
//            System.out.println("How much would you like to bet?");
//            bet = console.nextInt();

    private int getBet() {
        System.out.println("How much would you like to bet?");
        int bet = console.nextInt();
        return bet;
    }
    private void quit() {
        System.out.println("Thank you for playing! Press 1 to replay or 2 to return to the casino lobby.");
        int choice = console.nextInt();
        if (choice == 1) {
            run();
        } else if (choice == 2) {
//            Casino casino = new Casino();
//            casino.run();
        }
    }
}