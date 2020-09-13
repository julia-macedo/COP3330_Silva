// Julia de Macedo Soares da Silva
// COP 3330 - ju649983

// import java.util.Scanner;
// import java.lang.*;

public class Encrypter
{
    public static String encrypt (String integer)
    {
        // Create an array of integers of size 4 and fill it with the given string
        int arr[] = new int[4];
        for (int i = 0; i < 4; i++)
        {
            char digit = integer.charAt(i);
            // Returns the int value that the specified Unicode character represents
            arr[i] = Character.getNumericValue(digit);
        }

        // We should loop through the given string of numbers and add 7 to the
        // digit and get the remainder after dividing the new value by 10
        // math theory: (x + 7) mod% 10 = y
        for (int i = 0; i < 4; i++)
        {
            // Use a temporary variable to not lose anything in the process of sub
            int temp1 = arr[i];
            temp1 += 7;
            temp1 = temp1 % 10;
            arr[i] = temp1;
        }

        // To move string positions, we need a temporary variable as well.
        // Also, remeber to +1 for the positions

        // Swap the first digit with the third
        int temp2 = arr[0];
        arr[0] = arr[2];
        arr[2]= temp2;

        // Swap the second digit with the fourth.
        temp2 = arr[1];
        arr[1] = arr[3];
        arr[3] = temp2;

        int newInteger = 0 ;
        for(int i = 0; i < 4; i++)
            // To place the digits in the right order or decimal place
            newInteger = newInteger * 10 + arr[i];

        // To return a String object representing an Integer’s value
        String output = Integer.toString(newInteger);

        // To avoid excluding "0" at the beggining when printing, we need
        // to reinforce the string 0.
        if(arr[0] == 0)
            encryptedInteger = "0" + encryptedInteger;

        // Return the encrypted integer as a String
        return encryptedInteger;
    }
}
