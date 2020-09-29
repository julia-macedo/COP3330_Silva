// Julia de Macedo Soares da Silva
// COP 3330 - ju649983

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    // A scanner object to read the inputted info and it can be used by any method
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput())
        {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    // The method `getUserWeight` prompts the user to enter their weight in pounds and only accepts positive values.
    private static double getUserWeight()
    {
        System.out.println("Please input your weight: ");
        double userWeight = input.nextDouble();
        input.nextLine();

        if(userWeight < 0)
            getUserWeight();

        return userWeight;
    }

    // The method `getUserHeight` prompts the user to enter their height in inches and only accepts positive values.
    private static double getUserHeight()
    {
        System.out.println("Please input your height: ");
        double userHeight = input.nextDouble();
        input.nextLine();

        if(userHeight < 0)
            getUserHeight();

        return userHeight;
    }

    // The method `displayBmiStatistics` prints out the average BMI score of the data.
    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData)
    {
        double total = 0;

        for (int i = 0; i < bmiData.size(); i++)
            total += bmiData.get(i).userScore;

        double average = total / bmiData.size();

        System.out.println("The average BMI score is:" + average);
    }

    // The method `displayBmiInfo` prints out a user's BMi score and category using
    // the data contained in a BodyMassIndex object.
    private static void displayBmiInfo(BodyMassIndex bmi)
    {
        System.out.println("Your BMI scores is:" + bmi.userScore);
        System.out.println("Your BMI category is:" + bmi.userCategory);
    }

    // The method `moreInput` prompts the user to enter "Y" or "N" and
    // returns an appropriate boolean value based on their input.
    private static boolean moreInput()
    {
        String question = "";
        boolean flag = false;

        System.out.println("Is there more information to be inputted? Press Y for yes and N for no");
        question = input.nextLine();

        if (question.equals("Y"))
            flag =  true;

        return flag;

        // return (question == "Y") ? true : false;
    }
}
