import java.util.Scanner;

public class Main {

/*
                            This the Main program
     */

    public static void main(String[] args) {

        System.out.println("Welcome to the Batting Average Calculator!");

        while (userContinueProgram()) {                                         // ask if user wants to continue


            int[][] batArray = userInput();                                     // initialized the array in main


            // print results of both calculations for all batters
            for (int i = 0; i < batArray.length; i++) {
                System.out.printf("Batter %5d Batting average: %-10.2f Slugging percentage: %-10.2f", i + 1,
                        calcBatPerc(batArray), calcSlugPerc(batArray));

                System.out.println();
            }

        }

    } // end of main

//    TODO                  The program is only outputting the last batter's result


/*
                        This is the method for calculating batting percentage
     */

    public static double calcBatPerc(int[][] batArray) {
        double batAvg = 0.0;


        for (int i = 0; i < batArray.length; i++) {
            double batSum = 0;

            for (int j = 0; j < batArray[i].length; j++) {
                if (batArray[i][j] == 0) {                   //If at bat result is 0 the program continues
                    continue;
                } else {
                    ++batSum;  //else; at bat result is not 0, adds +1 to the count of how many times at bat
                }
            }

            batAvg = batSum / batArray[i].length;    // calculates the slugging percentage
        }
        return batAvg;          // returns the calculated slugging percentage to main
    }



/*
                        This is the method fo calculating slugging percentage
     */

    public static double calcSlugPerc(int[][] batArray) {
        double slugPerc = 0.0;


        for (int i = 0; i < batArray.length; i++) {
            double sum = 0;

            for (int j = 0; j < batArray[i].length; j++) {
                if (batArray[i][j] == 0) {         //If at bat result is 0 the program continues
                    continue;
                } else {
                    sum = sum + batArray[i][j];     //else; at bat result is not 0, adds the total number in the row
                }
            }

            slugPerc = sum / batArray[i].length;    // calculates the slugging percentage
        }
        return slugPerc;         // returns the calculated slugging percentage to main
    }



/*
                        This is the method to populate arrays by asking user input on number of batters,
                         number of times at bat and results of at bat
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
                atBatResult(scan1, batArray[i], j);

            }
        }

        return batArray;
    }


    /*
                        This is the method to check user input for at bat results
         */
    public static void atBatResult(Scanner scan1, int[] ints, int j) {
        if (ints[j] < 0 || ints[j] > 4) {
            System.out.println("Please input result as : 0=out, 1=single, 2=double, 3=triple, 4=home run");
            ints[j] = scan1.nextInt();
            scan1.nextLine();

        } else {
            return;

        }
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