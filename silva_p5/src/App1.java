// University of Central Florida
// Julia de Macedo Soares da Silva
// COP 3330 - Dr. Hollander - Fall 20
// Programming Assignment 5

import java.util.InputMismatchException;
import java.util.Scanner;

public class App1
{
    // Used to get user's answers to prompts
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        App1 a = new App1();
        a.printMainMenu();
    }

    public static void printMainMenu()
    {
        boolean makeChoice = true;

        while(makeChoice)
        {
            System.out.println("Select Your Application");
            System.out.println("------------------");
            System.out.println("1. contact list");
            System.out.println("2. task list");
            System.out.println("3. quit");

            makeChoice = makeChoice();
        }

        System.out.println("See you later! :))");
        // TODO: stop printing the meu after we say bye
    }

    public static boolean makeChoice()
    {
        System.out.println("Pick one option from above:");

        try
        {
            int action = input.nextInt();

            if (action == 1)
            {
                // take to ContactApp
                ContactApp b = new ContactApp();
                b.printMainMenuContact();
                return true;
            }

            else if (action == 2)
            {
                // take to TaskApp
                TaskApp c = new TaskApp();
                c.printMainMenuTask();
                return true;
            }

            else if (action == 3)
            {
                // quit the program --> make while false
                printMainMenu();
                return false;
            }

            else
            {
                // wrong integer
                System.out.println("Oh no... Please pick another number from 1-3!");
                return true;
            }
        }

        // anything but an integer should be caught by this
        catch(InputMismatchException ex)
        {
            System.out.println("Invalid entry! Please use the keys 1-3");
            input.nextLine();
            return true;
        }
    }
}
