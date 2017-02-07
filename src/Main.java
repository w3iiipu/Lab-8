import java.util.Scanner;

public class Main {

/*
    This the Main program
*/

    public static void main(String[] args) {

        System.out.println("Welcome to the Batting Average Calculator!");

        while (userContinueProgram()) {                                         // ask if user wants to continue


            int[][] batArray = userInput();                                     // initialized the array in main

            /*printArray(batArray);*/                                           // print to check array content

            // print results of both calculations for all batters
            for (int i = 0; i < batArray.length; i++) {
                System.out.printf("Batter %5d Batting average: %-10.2f Slugging percentage: %-10.2f", i + 1,
                        calcBatPerc(batArray[i]), calcSlugPerc(batArray[i]));

                System.out.println();
            }

        }

    } // end of main



/*
    This is the method for calculating batting percentage
*/

    public static double calcBatPerc(int[] batArray) {
        double batAvg = 0.0;  // initializing batAvg values as double


        double batSum = 0;  //outside for loop so it doesn't get reset

        // for loop will go thru a single dimension array of column for batters
        for (int j = 0; j < batArray.length; j++) {
            if (batArray[j] == 0) {                   //If at bat result is 0 the program continues
                continue;
            } else {
                ++batSum;  //else; at bat result is not 0, adds +1 to the count of how many times at bat
            }
        }

        batAvg = batSum / batArray.length;    // calculates the slugging percentage

        return batAvg;          // returns the calculated slugging percentage to main
    }


/*
    This is the method fo calculating slugging percentage
*/

    public static double calcSlugPerc(int[] batArray) {
        double slugPerc = 0.0;   // initializing batAvg values as double

        double sum = 0;    //needs to be outside of for loop so the sum does not reset every iteration
        for (int i = 0; i < batArray.length; i++) {

            sum = sum + batArray[i];     // does not need an if else statement as 0 will still get added to the sum.

        }

        slugPerc = sum / batArray.length;    // calculates the slugging percentage
        return slugPerc;                    // returns the calculated slugging percentage to main
    }


    /**
     * // This prints the array for checking array contents
     * <p>
     * <p>
     * //        public static void printArray(int[][] batArray) {
     * //
     * //
     * //        for (int i = 0; i < batArray.length; i++) {
     * //
     * //
     * //            for (int j = 0; j < batArray[i].length; j++) {
     * //
     * //
     * //                System.out.println(batArray[i][j]);
     * //
     * //            }
     * //        }
     * //
     * //    }
     */



/*
    This is the method to populate arrays by asking user input on number of batters,
    number of times at bat and results of at bat
*/
    public static int[][] userInput() {
        Scanner scan1 = new Scanner(System.in);

        System.out.printf("Please enter number of batters : ");
        int numOfBatters = scan1.nextInt();         // user input SETS number of batters/number of rows in the array
        scan1.nextLine();

        int[][] batArray = new int[numOfBatters][];     //initializing the array with number of batters as rows

        for (int i = 0; i < batArray.length; i++) {
            System.out.printf("Please enter number of times batter (%d) at bat : ", i + 1);
            int atBat = scan1.nextInt();   // user input SETS count at bat for each batter/number of columns for batters
            scan1.nextLine();

            batArray[i] = new int[atBat];       //initializing the array with count at bat as columns

            for (int j = 0; j < batArray[i].length; j++) {
                System.out.printf("Batting results for (%d,%d) : ", i + 1, j + 1);
                batArray[i][j] = scan1.nextInt();   // user input result to be entered into the array for each [i],[J]
                scan1.nextLine();


                // Calling method that checks if the user input for at bat result is valid between 0 and 4
                atBatResult(scan1, batArray[i], j);

            }
        }

        return batArray;    // returns the array back into main
    }


/*
    This is the method to check user input for at bat results
*/

    public static void atBatResult(Scanner scan1, int[] ints, int j) {
        if (ints[j] < 0 || ints[j] > 4) {
            System.out.println("Please input result as : 0 = Out, 1 = Single, 2 = Double, 3 = Triple, 4 = HOME RUN!");
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
        }


    }
}