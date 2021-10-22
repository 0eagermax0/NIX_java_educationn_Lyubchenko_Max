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
    }
}
