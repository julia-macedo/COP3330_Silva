import java.util.Scanner;
import java.io.IOException;
import java.text.ParseException;

// interacts with user and validate and passes an input to the task list
// no test cases needed for this class
public class App
{
    public static void main (String[] args) throws ParseException, IOException, ClassNotFoundException
    {
        printMainMenu();

        boolean flag = true;

        while (flag)
        {
            System.out.println("Pick one option from above:");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();

            if(option != 1 || option != 2 || option != 3)
            {
                System.out.println("Please use the keys 1, 2 or 3");
                option = input.nextInt();
            }

            switch(option)
            {
                case 1: // create
                    TaskList myList = new TaskList();
                    System.out.println("A new task list has been created!");
                    operationMenu(myList);
                    break;

                case 2: // load
                    // loadExistingList; --> should be in TaskList
                    // TODO: TaskList.loadExistingList();
                    break;

                case 3: // exit
                    flag = false;
                    break;
            }
        }
    }

    private static void operationMenu(TaskList myList)
    {
        printOpMenu();

        Scanner inputChoice = new Scanner(System.in);
        int optionMenu = inputChoice.nextInt();

        while (true)
        {
            if(optionMenu < 1 || optionMenu > 8)
            {
                System.out.println("Please enter any key between 1 to 8");
                optionMenu = inputChoice.nextInt();
            }

            Scanner title = new Scanner(System.in);
                String titleInputted = title.nextLine();
            Scanner description= new Scanner(System.in);
                String descriptionInputted = title.nextLine();
            Scanner dueDate = new Scanner(System.in);
                String dueDateInputted = title.nextLine();

            switch(optionMenu)
            {
                case 1: // A user shall be able to view the current task list
                    TaskList.printTaskList();
                    break;

                case 2: // A user shall be able to add an item to the current task list
                    myList.addItem(titleInputted, descriptionInputted, dueDateInputted);

                    System.out.println("Task title: " + titleInputted);
                    System.out.println("Task description: " + descriptionInputted);
                    System.out.println("Task due date (YYYY-MM-DD):" + dueDateInputted);

                    break;

                case 3: // A user shall be able to edit an item in the current task list
                    TaskList.printTaskList();
                    // pick an index and takes to the list item referred --> getItem
                    System.out.println("Which task will you edit?");
                    Scanner index = new Scanner(System.in);
                        int getItem = index.nextInt();

                    System.out.println("Enter a new title for" + titleInputted + ": ");
                    System.out.println("Enter a new description for" + titleInputted + ": ");
                    System.out.println("Enter a new task due date (YYYY-MM-DD) for" + titleInputted +":");

                    Scanner title2 = new Scanner(System.in);
                        String newTitle = title2.nextLine();
                    Scanner description2= new Scanner(System.in);
                        String newDesc = description2.nextLine();
                    Scanner dueDate2 = new Scanner(System.in);
                        String newDueDate = dueDate2.nextLine();

                    // edit the task in the array list
                    TaskList.editItem(getItem, newTitle, newDesc, newDueDate);

                    System.out.println("Task successfully edited!");
                    break;

                case 4: // A user shall be able to remove an item from the current task list
                    TaskList.printTaskList();
                    // pick an index and takes to the list item referred --> getItem
                    System.out.println("Which task will you remove?");

                    Scanner index2 = new Scanner(System.in);
                    int getItem2 = index2.nextInt();

                    // delete the task from the array list
                    TaskList.deleteItem(getItem2);

                    System.out.println("Task successfully deleted!");
                    break;

                case 5: // A user shall be able to mark an item in the current task list as completed
                    TaskList.printTaskList();
                    // pick an index and takes to the list item referred --> getItem
                    System.out.println("Which task will you mark as completed?");

                    Scanner index3 = new Scanner(System.in);
                    int getItem3 = index3.nextInt();

                    TaskList.markItem(getItem3);

                    System.out.println("Task successfully marked!");
                    break;

                case 6: // A user shall be able to unmark an item in the current task list as completed
                    TaskList.printTaskList();
                    // pick an index and takes to the list item referred --> getItem
                    System.out.println("Which task will you unmark as completed?");

                    Scanner index4 = new Scanner(System.in);
                    int getItem4 = index4.nextInt();

                    TaskList.unmarkItem(getItem4);

                    System.out.println("Task successfully unmarked!");
                    break;

                case 7: // A user shall be able to save the current task list
                    // File saving
                    System.out.println("Enter the filename to save as:");

                    System.out.println("Task list has been saved!");
                    break;

                case 8: // exit menu
                    break;
            }

            printOpMenu();
        }

    }

// ------------------------------------------------------------------------------------------------------------------
//                                              Menu Printing
// ------------------------------------------------------------------------------------------------------------------

    private static void printMainMenu()
    {
        System.out.println("Main Menu");
        System.out.println("------------------");

        // A user shall be able to create a new task list
        System.out.println("1. create a new list");

        // A user shall be able to load an existing task list
        System.out.println("2. load an existing list");

        System.out.println("3. quit");
    }

    private static void printOpMenu()
    {
        System.out.println("List Operation Menu");
        System.out.println("------------------");
        System.out.println("1. view the list");
        System.out.println("2. add an item");
        System.out.println("3. edit an item");
        System.out.println("4. remove an item");
        System.out.println("5. mark an item as completed");
        System.out.println("6. unmark an item as completed");
        System.out.println("7. save the current list");
        System.out.println("8. quit to the main menu");
    }

}