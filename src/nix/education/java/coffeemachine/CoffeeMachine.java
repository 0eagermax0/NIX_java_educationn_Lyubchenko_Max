package nix.education.java.coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        System.out.println("Starting to make a coffee\nGrinding coffee beans\nBoiling water" +
        "Mixing boiled water with crushed coffee beans\nPouring coffee into the cup\n" +
                "Pouring some milk into the cup\nCoffee is ready!");
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        System.out.print("> ");
        int numCup = scan.nextInt();
        System.out.println("For " + numCup + " cups of coffee you will need:");
        int numWater = numCup * 200;
        int numMilk = numCup * 50;
        int numCoffee = numCup * 15;
        System.out.println(numWater + " ml of water\n" + numMilk + " ml of milk\n" + numCoffee + " g of coffee beans");
        System.out.println("Write how many ml of water the coffee machine has:");
        System.out.print("> ");
        numWater = scan.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        System.out.print("> ");
        numMilk = scan.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        System.out.print("> ");
        numCoffee = scan.nextInt();
        do {
            System.out.println("Write how many cups of coffee you will need:");
            System.out.print("> ");
            numCup = scan.nextInt();
            if (numCup == 0)
                System.out.println("Fail! Try again.");
        } while (numCup == 0);
        numWater = numWater / 200;
        numMilk = numMilk / 50;
        numCoffee = numCoffee / 15;
        int min;
        if (numWater >= numMilk)
            min = numMilk;
        else
            min = numWater;
        if (min >= numCoffee)
            min = numCoffee;
        if (min == numCup)
            System.out.println("Yes, I can make that amount of coffee");
        else if(min > numCup) {
            int N = min - numCup;
            System.out.println("Yes, I can make that amount of coffee (and even " + N + " more than that)");
        }
        else
            System.out.println("No, I can make only " + min + " cups of coffee");
    }
}
