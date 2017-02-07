import java.util.Scanner;

public class Main {

/*
                        This the Main program
     */

    public static void main(String[] args) {

        System.out.println("Welcome to the Batting Average Calculator!");

        while (userContinueProgram()) {                                         // ask if user wants to continue


            int[][] batArray = userInput();


            for (int i = 0; i < batArray.length; i++) {
                System.out.printf("Batter %5d Batting average: %-10.2f Slugging percentage: %-10.2f", i + 1,
                        calcBatPerc(batArray), calcSlugPerc(batArray));
                System.out.println();
            }

        }

    } // end of main

/*
                        This is the method for calculating batting percentage
     */

    public static double calcBatPerc(int[][] batArray) {
        double batAvg = 0.0;


        for (int i = 0; i < batArray.length; i++) {
            double batSum = 0;

            for (int j = 0; j < batArray[i].length; j++) {
                if (batArray[i][j] == 0) {
                    continue;
                } else {
                    ++batSum;
                }
            }

            batAvg = batSum / batArray[i].length;
        }
        return batAvg;
    }

/*
                        This is the method fo calculating slugging percentage
     */

    public static double calcSlugPerc(int[][] batArray) {
        double slugPerc = 0.0;


        for (int i = 0; i < batArray.length; i++) {
            double sum = 0;

            for (int j = 0; j < batArray[i].length; j++) {
                if (batArray[i][j] == 0) {
                    continue;
                } else {
                    sum = sum + batArray[i][j];
                }
            }

            slugPerc = sum / batArray[i].length;
        }
        return slugPerc;
    }

/*
                    This is the method to populate arrays by asking user input on number of batters, number of times at bat and results of at bat
     */


    public static int[][] userInput() {
        Scanner scan1 = new Scanner(System.in);

        System.out.printf("Please enter number of batters : ");
        int numOfBatters = scan1.nextInt();
        scan1.nextLine();

        int[][] batArray = new int[numOfBatters][];

        for (int i = 0; i < batArray.length; i++) {
            System.out.printf("Please enter number of times batter (%d) at bat : ", i + 1);
            int atBat = scan1.nextInt();
            scan1.nextLine();


            batArray[i] = new int[atBat];

            for (int j = 0; j < batArray[i].length; j++) {
                System.out.printf("Batting results for (%d,%d) : ", i + 1, j + 1);
                batArray[i][j] = scan1.nextInt();
                scan1.nextLine();


                // This checks if the user input for at bat result is valid between 0 and 4
                if (batArray[i][j] < 0 || batArray [i][j] > 4) {
                    System.out.println("Please input result as : 0=out, 1=single, 2=double, 3=triple, 4=home run");
                    batArray[i][j] = scan1.nextInt();
                    scan1.nextLine();

                } else {
                    continue;

                }

            }
        }

        return batArray;
    }

/*
                        This is the method to ask if user wants to continue
     */


    public static boolean userContinueProgram() {
        Scanner scan = new Scanner(System.in);
        String userCont;

        System.out.print("Would you like to continue? (y/n) ");
        userCont = scan.nextLine();

        while (!userCont.equalsIgnoreCase("y") &&
                !userCont.equalsIgnoreCase("yes") &&
                !userCont.equalsIgnoreCase("n") &&
                !userCont.equalsIgnoreCase("no")) {
            System.out.println("That is not a valid input.  Please try again. (y/n) ");
            userCont = scan.nextLine();
        }


        if (userCont.equals("y") || userCont.equals("yes")) {
            return true;
        } else {
            System.out.println("Thanks You. Goodbye.");
            return false;
            //System.exit(0);                                                                                             // Exits the program if user enters anything other then 'y'
        }


    }
}