package nix.education.java.coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {
    static int numWater = 400, numMilk = 540, numCoffee = 120, numCup = 9, numMoney = 550;
    static void printt(int water, int milk, int coffee, int cup, int money) {
        System.out.println("\nThe coffee machine has:\n" + water + " of water\n" + milk + " of milk\n" + coffee + " of coffee beans\n" + cup + " of disposable cups\n" + money + " of money\n");
    }

    static boolean minCupEspresso(int espressoWater, int espressoMilk, int espressoCoffee, int espressoNumCup)
    {
        int minCupEspresso = 0;
        espressoWater = espressoWater / 250;
        espressoCoffee = espressoCoffee / 16;
        minCupEspresso = espressoWater;
        if (minCupEspresso > espressoCoffee)
            minCupEspresso = espressoCoffee;
        else if (minCupEspresso > espressoNumCup)
            minCupEspresso = espressoNumCup;
        return minCupEspresso != 0;
    }

    static boolean minCupLatte(int latteWater, int latteMilk, int latteCoffee, int latteNumCup)
    {
        int minCupLatte = 0;
        latteWater = latteWater / 350;
        latteMilk = latteMilk / 75;
        latteCoffee = latteCoffee / 20;
        minCupLatte = latteWater;
        if (minCupLatte > latteCoffee)
            minCupLatte = latteCoffee;
        else if (minCupLatte > latteMilk)
            minCupLatte = latteMilk;
        else if (minCupLatte > latteNumCup)
            minCupLatte = latteNumCup;
        return minCupLatte != 0;
    }

    static boolean minCupCappuccino(int cappuccinoWater, int cappuccinoMilk, int cappuccinoCoffee, int cappuccinoNumCup)
    {
        int minCupCappuccino = 0;
        cappuccinoWater = cappuccinoWater / 200;
        cappuccinoMilk = cappuccinoMilk / 100;
        cappuccinoCoffee = cappuccinoCoffee / 12;
        minCupCappuccino = cappuccinoWater;
        if (minCupCappuccino > cappuccinoCoffee)
            minCupCappuccino = cappuccinoCoffee;
        else if (minCupCappuccino > cappuccinoMilk)
            minCupCappuccino = cappuccinoMilk;
        else if (minCupCappuccino > cappuccinoNumCup)
            minCupCappuccino = cappuccinoNumCup;
        return minCupCappuccino != 0;
    }

    static void makeEspresso()
    {
        if (minCupEspresso(numWater, numMilk, numCoffee, numCup)) {
            numWater -= 250;
            numCoffee -= 16;
            numCup--;
            numMoney += 4;
            System.out.println("\nI have enough resources, making you a coffee!");
            printt(numWater, numMilk, numCoffee, numCup, numMoney);
        } else
            System.out.println("\nFew ingredients\n");
    }

    static void makeLatte()
    {
        if (minCupLatte(numWater, numMilk, numCoffee, numCup)) {
            numWater -= 350;
            numMilk -= 75;
            numCoffee -= 20;
            numCup--;
            numMoney += 7;
            System.out.println("\nI have enough resources, making you a coffee!");
            printt(numWater, numMilk, numCoffee, numCup, numMoney);
        } else
            System.out.println("\nFew ingredients\n");
    }

    static void makeCappuccino()
    {
        if (minCupCappuccino(numWater, numMilk, numCoffee, numCup)) {
            numWater -= 200;
            numMilk -= 100;
            numCoffee -= 12;
            numCup--;
            numMoney += 6;
            System.out.println("\nI have enough resources, making you a coffee!");
            printt(numWater, numMilk, numCoffee, numCup, numMoney);
        } else
            System.out.println("\nFew ingredients\n");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for (; ; ) {
            System.out.print("Write action (buy, fill, take, remaining, exit):\n> ");
            String menu = scan.next();
            switch (menu) {
                case "buy": {
                    System.out.println(" What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
                    String coffeeType = scan.next();
                    switch (coffeeType) {
                        case "1":
                        {
                            makeEspresso();
                        }
                        break;
                        case "2": {
                            makeLatte();
                        }
                        break;
                        case "3": {
                            makeCappuccino();
                        }
                        break;
                        case "back":
                            continue;
                        default:
                            System.out.println("Select from the list.");
                            break;
                    }
                }
                break;
                case "fill": {
                    int add;
                    System.out.print("Write how many ml of water you want to add:\n> ");
                    add = scan.nextInt();
                    numWater += add;
                    System.out.print("Write how many ml of milk you want to add:\n> ");
                    add = scan.nextInt();
                    numMilk += add;
                    System.out.print("Write how many grams of coffee beans you want to add:\n> ");
                    add = scan.nextInt();
                    numCoffee += add;
                    System.out.print("Write how many disposable coffee cups you want to add:\n> ");
                    add = scan.nextInt();
                    numCup += add;
                    printt(numWater, numMilk, numCoffee, numCup, numMoney);
                }
                break;
                case "take": {
                    System.out.println("I gave you " + numMoney);
                    numMoney = 0;
                    printt(numWater, numMilk, numCoffee, numCup, numMoney);
                }
                break;
                case "remaining":
                    printt(numWater, numMilk, numCoffee, numCup, numMoney);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("\nIncorrect input\n");
                    break;
            }
        }
    }
}