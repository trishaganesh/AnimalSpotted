/**
 * @purpose: Attempting to re-conduct trials until a specific animal is spotted.
 *
 * @author Trisha Ganesh
 * @version 02/07/2021
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class AnimalPopulation {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Fox Squirrel Simulator");
        System.out.println("\n");
        System.out.println("How many trials should be simulated?");
        System.out.print("Please enter a value greater than or equal to 1000: ");
        int numTrials;
        while (true) {
            numTrials = in.nextInt();
            if (numTrials >= 1000)
                break;
            System.out.print("Please enter a value greater than or equal to 1000: ");
        }

        //Print message
        System.out.println("\nsimulating trials now....one moment please....");
        int maximum = 10;
        int minimum = 1;

        // Generate random numbers from 1-10
        int numberOfAnimalsSpotted = 0;

        //Writing to the file
        PrintWriter outFile = new PrintWriter(new File("MonteCarlo.txt"));

        //import Random class
        Random rand = new Random();

        //for loop to loop through each trial
        for (int trial = 0; trial < numTrials; trial++) {
            //while loop to determine if the chosen animal (10) is spotted, then break and continue trials
            while (true) {
                int randomInteger = rand.nextInt(10) + 1;
                numberOfAnimalsSpotted++;
                if (randomInteger == 10)
                    break;
            }
            outFile.println(numberOfAnimalsSpotted);
            numberOfAnimalsSpotted = 0;
        }
        outFile.close();
        //Reading the file
        File filename = new File("MonteCarlo.txt");
        Scanner inFile = new Scanner(filename);
        //average of the numbers in trial(s)
        double averageOfTotalAnimals = 0.0;
        String token = "";
        while (inFile.hasNext()) {
            token = inFile.next();
            //total number of animals spotted in trial(s)
            int totalNumberOfAnimalsSpotted = Integer.parseInt(token);
            averageOfTotalAnimals += totalNumberOfAnimalsSpotted;
        }
        inFile.close();

        //Display results
        System.out.println();
        System.out.println("The results!");
        System.out.println("The average number of squirrels observed until\nspotting a Fox Squirrel at the city part is: " + averageOfTotalAnimals /numTrials);

    }

}

