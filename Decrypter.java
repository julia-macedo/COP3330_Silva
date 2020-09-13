// Julia de Macedo Soares da Silva
// COP 3330 - ju649983

// import java.util.Scanner;
// import java.lang.*;

public class Decrypter
{
  // Allow the user to enter an encrypted four-digit integer and then decrypt
  // it(by reversing the encryption scheme) to form the original number.
  public static String decrypt (String encryptedInteger)
  {
    int arr[] = new int[4];
    for(int i = 0; i < 4; i++)
    {
      char digit = encryptedInteger.charAt(i);
      arr[i] = Character.getNumericValue(digit);
    }

    // Swap the third digit with the first back
    int temp3 = arr[0];
    arr[0] = arr[2];
    arr[2] = temp3;

    // Swap the fourth digit with the second back
    temp3 = arr[1];
    arr[1] = arr[3];
    arr[3] = temp3;

    // To reverse the math operation, I created a table with single results for
    // each encrypted digit, as there was no repetition, it was easy to link
    // them to their orginal digit by using cases.
    for(int i = 0; i < 4; i++)
    {
      int digit = arr[i];
      switch(digit)
      {
        case 0:
          arr[i] = 3;
          break;

        case 1:
          arr[i] = 4;
          break;

        case 2:
          arr[i] = 5;
          break;

        case 3:
          arr[i] = 6;
          break;

        case 4:
          arr[i] = 7;
          break;

        case 5:
          arr[i] = 8;
          break;

        case 6:
          arr[i] = 9;
          break;

        case 7:
          arr[i] = 0;
          break;

        case 8:
          arr[i] = 1;
          break;

        case 9:
          arr[i] = 2;
          break;
      }
    }

    int newInteger = 0;
    for(int i = 0; i < 4; i++)
    // To place the digits in the right order or decimal place
    newInteger = newInteger * 10 + arr[i];

    // To return a String object representing an Integer’s value
    String decryptedInteger = Integer.toString(newInteger);

    // To avoid excluding "0" at the beggining when printing, we need
    // to reinforce the string 0.
    if(arr[0] == 0)
    decryptedInteger = "0" + decryptedInteger;

    return decryptedInteger;
  }
}
