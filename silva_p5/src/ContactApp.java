import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp
{
    private static final Scanner userInput = new Scanner(System.in);
    private static ContactList contactList;

// ------------------------------------------------------------------------------------------------------------------
//                                     Main Task Menu Functions
// ------------------------------------------------------------------------------------------------------------------

    static void printMainMenuContact()
    {
        boolean makeMainContactAction = true;

        while(makeMainContactAction)
        {
            System.out.println("Main Menu");
            System.out.println("------------------");
            System.out.println("1. create a new contact list");
            System.out.println("2. load en existing contact list");
            System.out.println("3. quit");

            makeMainContactAction = makeMainContactAction();
        }

        System.out.println("See you later!! :)");
    }

    private static boolean makeMainContactAction()
    {
        System.out.println("Pick one option from above:");

        try
        {
            int action = userInput.nextInt();

            if (action == 1)
            {
                contactList =  new ContactList();
                System.out.println("New contact list created!");
                printOperationalMenu();
                return true;
            }
            else if (action == 2)
            {
                userInput.nextLine();
                // load an existing list

                contactList = new ContactList();
                System.out.println("Enter the name of the file: ");
                String fileName = userInput.nextLine();

                contactList.loadList(fileName);
                System.out.println(fileName + " has been loaded.");

                return true;
            }

            else if (action == 3)
            {
                // quit --> make while false
                return false;
            }

            else
            {
                System.out.println("Invalid Entry! Please use the keys 1-3");
                // userInput.nextLine();
                return true;
            }
        }

        catch(NullPointerException ex)
        {
            System.out.println("FLAG Invalid entry! Please use the keys 1-3");
            userInput.nextLine();
            return true;
        }

        catch(InputMismatchException ex)
        {
            System.out.println("FLAGGGGGGG Invalid entry! Please use the keys 1-3");
            userInput.nextLine();
            return true;
        }
    }

// ------------------------------------------------------------------------------------------------------------------
//                                     Operational Menu Functions
// ------------------------------------------------------------------------------------------------------------------

    private static void printOperationalMenu()
    {
        boolean makeTaskAction = true;

        while(makeTaskAction)
        {
            System.out.println("List Operation Menu");
            System.out.println("------------------");
            System.out.println("1. view the list");
            System.out.println("2. add an item");
            System.out.println("3. edit an item");
            System.out.println("4. remove an item");
            System.out.println("5. save the current task list");
            System.out.println("6. quit to the main menu");

            makeTaskAction = makeTaskAction();
        }

        System.out.println("Taking you back now!");
    }

    private static boolean makeTaskAction()
    {
        System.out.println("Pick one option from above:");

        try
        {
            int option = userInput.nextInt();

            // view the list
            if (option == 1)
            {
                contactList.printContactList();
                return true;
            }

            // add item
            else if (option == 2)
            {
                contactList.printContactList();

                Scanner input = new Scanner(System.in);

                String firstName;
                String lastName;
                String phoneNumber;
                String email;

                System.out.print("Contact first name: ");
                firstName = input.nextLine();
                System.out.print("Contact last name: ");
                lastName = input.nextLine();
                System.out.print("Contact phone number: ");
                phoneNumber = input.nextLine();
                System.out.print("Contact email: ");
                email = input.nextLine();

                ContactItem newTask = new ContactItem(firstName, lastName, phoneNumber,email);

                contactList.addItem(newTask);

                System.out.println("Item successfully added to your list!");
                return true;
            }

            // edit item
            else if (option == 3)
            {
                contactList.printContactList();

                try
                {
                    Scanner scan = new Scanner(System.in);
                    int index;
                    String firstName;
                    String lastName;
                    String phoneNumber;
                    String email;

                    System.out.print("Which contact will you edit? ");
                    index = scan.nextInt();
                    scan.nextLine();

                    System.out.printf("Enter a new first name for " + index + ": ");
                    firstName = scan.nextLine();
                    System.out.printf("Enter a new last name for " + index + ": ");
                    lastName = scan.nextLine();
                    System.out.printf("Enter a new phone number for " + index + ": ");
                    phoneNumber = scan.nextLine();
                    System.out.printf("Enter a new email for " + index + ": ");
                    email = scan.nextLine();

                    contactList.editItem(index, contactList.getItemList().size(), firstName, lastName, phoneNumber, email);
                }

                catch (Exception ex)
                {
                    System.out.println("ERROR: invalid key!");
                }

                return true;
            }

            // delete item
            else if (option == 4)
            {
                contactList.printContactList();

                int size = contactList.getItemList().size();

                // pick an index and takes to the list item referred --> getItem
                System.out.println("Which task will you remove?");
                Scanner index2 = new Scanner(System.in);
                int getItem2 = index2.nextInt();

                // delete the task from the array list
                contactList.removeItem(getItem2, size);

                System.out.println("Task successfully deleted!");
                return true;
            }

            // save list
            else if (option == 5)
            {
                String fileName;
                Scanner input = new Scanner(System.in);

                System.out.print("Enter the filename to save as: ");
                fileName = input.nextLine();
                contactList.saveFile(fileName);

                System.out.println("List successfully saved!");
                return true;
            }

            // quit and go back to main menu
            else if (option == 6)
            {
                // TODO: printMainMenu() instead
                printMainMenuContact();
                return false;
            }

            // default error
            else
            {
                System.out.println("Invalid Entry! Please use the keys 1-6");
                return true;
            }
        }

        catch(InputMismatchException ex)
        {
            System.out.println("Invalid entry! Please use the keys 1-6");
            userInput.nextLine();
            return true;
        }
    }
}
