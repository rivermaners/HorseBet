import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double userBet;
        final double EXACTA = 10.0;
        final double EXACTABOX = 5.0;
        final double TRIFECTA = 25.0;
        final double TRIFECTABOX = 20.0;
        int menu;
        int horse = 1;
        int horse1 = 2;
        int horse2 = 3;
        int horse3 = 4;
        int plays = 0;
        String answer;
        System.out.println("How much money would you like to bet?");
        userBet = scan.nextDouble();
        while (userBet != 0) {
            System.out.println("Your current balance is: " + "$" + userBet);
            System.out.println("Welcome to Joshua's horse betting game! You will be placing bets on 4 horses.\nChoose an option below:");
            System.out.println("[1] An EXACTA bets cost 10 dollars to place but you win 100 dollars if you guess the exact winning order of the top two horses. ");
            System.out.println("[2] An EXACTABOX bet costs 5 dollars to place but you win 25 if you guess the top two horses in any order.");
            System.out.println("[3] A TRIFECTA bets cost 25 dollars to place but you win 200 dollars if you guess the exact winning order of the top three horses.");
            System.out.println("[4] A TRIFECTABOX bet costs 20 dollars to place but you win 150 if you guess the top three horses in any order.");
            System.out.println("[5] Check balance");
            System.out.println("[6] Exit");

            System.out.print("Option: ");
            menu = scan.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("You have placed an Exacta bet of $10.00.");
                    userBet = userBet - EXACTA;
                    plays++;
                    break;
                case 2:
                    System.out.println("You have placed an Exactabox bet of $5.00.");
                    userBet = userBet - EXACTABOX;
                    plays++;
                    break;
                case 3:
                    System.out.println("You have placed a Trifecta bet of $25.00.");
                    userBet = userBet - TRIFECTA;
                    plays++;
                    break;
                case 4:
                    System.out.println("You have placed an Trifectabox bet of $20.00.");
                    userBet = userBet - TRIFECTABOX;
                    plays++;
                    break;
                case 5:
                    System.out.println("$" + userBet);
                    break;
                case 6:
                    System.out.println("Your final balance is: $" + userBet);
                    System.out.println("Games played: " + plays);
                    System.out.println("Goodbye.");
                    break;
            }
            if (menu == 1 || menu == 2) {
                System.out.println("Choose your first horse: ");
                horse = scan.nextInt();
                System.out.println("Choose your second horse: ");
                horse1 = scan.nextInt();
                System.out.println("You have chosen " + horse + " and " + horse1);
            }
            if (menu == 3 || menu == 4) {
                System.out.println("Choose your first horse: ");
                horse = scan.nextInt();
                System.out.println("Choose your second horse: ");
                horse1 = scan.nextInt();
                System.out.println("Choose your third horse: ");
                horse2 = scan.nextInt();
                System.out.println("You have chosen " + horse + ", " + horse1 + ", and " + horse2);
            } else if (menu == 5) {
                continue;
            } else if (menu == 6) {
                break;
            }
            System.out.println("Would you like to begin the race?");
            answer = scan.next();
            if (answer.equals("yes") || answer.equals("Yes")) {
                System.out.println("May the horse race begin!");
                Race r = new Race();
                r.readysetgo();
                int firstPlace = r.first();
                int secondPlace = r.second();
                int thirdPlace = r.third();
                int fourthPlace = r.fourth();
                String first = String.valueOf(firstPlace);
                String second = String.valueOf(secondPlace);
                String third = String.valueOf(thirdPlace);
                String fourth = String.valueOf(fourthPlace);
                System.out.println("1st place: " + firstPlace + "\n2nd place: " + secondPlace + "\n3rd place: " + thirdPlace + "\n4th place: " + fourthPlace);
                if (menu == 1) {
                    if (horse == firstPlace && horse1 == secondPlace) {
                        System.out.println("You win!");
                        userBet = userBet + 100;
                    } else {
                        System.out.println("You lose!");
                    }
                }
                if (menu == 2) {
                    if (horse == firstPlace && horse1 == secondPlace || horse == secondPlace && horse1 == firstPlace) {
                        System.out.println("You win!");
                        userBet = userBet + 25;
                    } else {
                        System.out.println("You lose!");
                    }
                }
                if (menu == 3) {
                    if (horse == firstPlace && horse1 == secondPlace && horse2 == thirdPlace) {
                        System.out.println("You win!");
                        userBet = userBet + 200;
                    } else {
                        System.out.println("You lose!");
                    }
                }
                if (menu == 4) {
                    if (fourthPlace != horse && fourthPlace != horse1 && fourthPlace != horse2) {
                        System.out.println("You win!");
                        userBet = userBet + 150;
                    } else {
                        System.out.println("You lose!");
                    }
                }
            }
            if (answer.equals("no") || answer.equals("No")) {
                if (menu == 1) {
                    userBet += 10;
                } else if (menu == 2) {
                    userBet += 5;
                } else if (menu == 3) {                          //}adds money back to balance if canceled
                    userBet += 25;
                } else if (menu == 4) {
                    userBet += 20;
                }
                //sends user back to beginning of while loop
            }
        }
        while (userBet == 0) {
            System.out.println("You are broke.");
            System.out.println("Games played: " + plays);
            break;
        }
    }
}
