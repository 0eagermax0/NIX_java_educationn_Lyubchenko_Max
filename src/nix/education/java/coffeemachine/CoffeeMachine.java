package nix.education.java.coffeemachine;

import java.util.Scanner;

public class CoffeeMachine {
    static void printt(int water, int milk, int coffee, int cup, int money) {
        System.out.println("\nThe coffee machine has:\n" + water + " of water\n" + milk + " of milk\n" + coffee + " of coffee beans\n" + cup + " of disposable cups\n" + money + " of money\n");
    }

    static boolean countCup(int typeCoffee, int water, int milk, int coffee, int cup) {
        int min;
        if (typeCoffee == 1) {
            water = water / 250;
            coffee = coffee / 16;
            min = water;
            if (min > coffee)
                min = coffee;
            else if (min > cup)
                min = cup;
        } else if (typeCoffee == 2) {
            water = water / 350;
            milk = milk / 75;
            coffee = coffee / 20;
            min = water;
            if (min > coffee)
                min = coffee;
            else if (min > milk)
                min = milk;
            else if (min > cup)
                min = cup;
        } else {
            water = water / 200;
            milk = milk / 100;
            coffee = coffee / 12;
            min = water;
            if (min > coffee)
                min = coffee;
            else if (min > milk)
                min = milk;
            else if (min > cup)
                min = cup;
        }
        return min != 0;
    }

    public static void main(String[] args) {
        /*System.out.println("Starting to make a coffee\nGrinding coffee beans\nBoiling water" +
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
*/
        int numWater = 400, numMilk = 540, numCoffee = 120, numCup = 9, numMoney = 550;
        //int numCupEspresso, numCupLatte, numCupCappuccino;
        Scanner scan = new Scanner(System.in);
        for (; ; ) {
            System.out.print("Write action (buy, fill, take, remaining, exit):\n> ");
            String menu = scan.next();
            switch (menu) {
                case "buy": {
                    System.out.println(" What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:");
                    String coffeeType = scan.next();
                    switch (coffeeType) {
                        case "1": {
                            int coffeeType1 = Integer.parseInt(coffeeType);
                            if (CoffeeMachine.countCup(coffeeType1, numWater, numMilk, numCoffee, numCup)) {
                                numWater -= 250;
                                numCoffee -= 16;
                                numCup--;
                                numMoney += 4;
                                System.out.println("\nI have enough resources, making you a coffee!");
                                printt(numWater, numMilk, numCoffee, numCup, numMoney);
                            } else
                                System.out.println("\nFew ingredients\n");
                        } break;
                        case "2": {
                            int coffeeType1 = Integer.parseInt(coffeeType);
                            if (CoffeeMachine.countCup(coffeeType1, numWater, numMilk, numCoffee, numCup)) {
                                numWater -= 350;
                                numMilk -= 75;
                                numCoffee -= 20;
                                numCup--;
                                numMoney += 7;
                                System.out.println("\nI have enough resources, making you a coffee!");
                                printt(numWater, numMilk, numCoffee, numCup, numMoney);
                            } else
                                System.out.println("\nFew ingredients\n");
                        }break;
                        case "3": {
                            int coffeeType1 = Integer.parseInt(coffeeType);
                            if (CoffeeMachine.countCup(coffeeType1, numWater, numMilk, numCoffee, numCup)) {
                                numWater -= 200;
                                numMilk -= 100;
                                numCoffee -= 12;
                                numCup--;
                                numMoney += 6;
                                System.out.println("\nI have enough resources, making you a coffee!");
                                printt(numWater, numMilk, numCoffee, numCup, numMoney);
                            } else
                                System.out.println("\nFew ingredients\n");
                        }break;
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
                    System.out.println("Write how many ml of water you want to add:\n> ");
                    add = scan.nextInt();
                    numWater += add;
                    System.out.println("Write how many ml of milk you want to add:\n> ");
                    add = scan.nextInt();
                    numMilk += add;
                    System.out.println("Write how many grams of coffee beans you want to add:\n> ");
                    add = scan.nextInt();
                    numCoffee += add;
                    System.out.println("Write how many disposable coffee cups you want to add:\n> ");
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
