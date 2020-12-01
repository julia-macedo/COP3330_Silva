import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp
{
    private static final Scanner userInput = new Scanner(System.in);// handles user's input
    private static TaskList taskList; // = new TaskList();

// ------------------------------------------------------------------------------------------------------------------
//                                     Main Task Menu Functions
// ------------------------------------------------------------------------------------------------------------------

    static void printMainMenuTask()
    {
        boolean makeMainTaskAction = true;

        while(makeMainTaskAction)
        {
            System.out.println("Main Menu");
            System.out.println("------------------");
            System.out.println("1. create a new task list");
            System.out.println("2. load en existing task list");
            System.out.println("3. quit");

            makeMainTaskAction = makeMainTaskAction();
        }

        System.out.println("See you later!! :)");
    }

    private static boolean makeMainTaskAction()
    {
        System.out.println("Pick one option from above:");

        try
        {
            int action = userInput.nextInt();

            // create new list
            if (action == 1)
            {
                taskList =  new TaskList();
                System.out.println("New task list created!");
                printOperationalMenu();
                return true;
            }

            // load an existing list
            else if (action == 2)
            {
                userInput.nextLine();


                taskList = new TaskList();
                System.out.println("Enter the name of the file: ");
                String fileName = userInput.nextLine();

                taskList.loadList(fileName);
                System.out.println(fileName + " has been loaded.");

                printOperationalMenu();
                return true;
            }

            // quit --> make while false
            else if (action == 3) {return false;}

            // if user press any other integer other than 1-3
            else
            {
                System.out.println("Invalid Entry! Please use the keys 1-3");
                userInput.nextLine();
                return true;
            }
        }

        catch(NullPointerException ex)
        {
            System.out.println("FLAG Invalid entry! Please use the keys 1-3");
            userInput.nextLine();
            return true;
        }
        // if user press anything that is not the integers 1-3
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
            System.out.println("7. mark an item");
            System.out.println("8. unmark an item");


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
                TaskList.printTaskList();
                return true;
            }

            // add item
            else if (option == 2)
            {

                taskList.printTaskList();

                Scanner input = new Scanner(System.in);

                String title;
                String description;
                String dueDate;

                System.out.print("Task title: ");
                title = input.nextLine();
                System.out.print("Task description: ");
                description = input.nextLine();
                System.out.print("Task due date (YYYY-MM-DD): ");
                dueDate = input.nextLine();

                TaskItem newTask = new TaskItem(title, description, dueDate);

                taskList.addItem(newTask);

                System.out.println("Item successfully added to your list!");
                return true;
            }

            // edit item
            else if (option == 3)
            {
                taskList.printTaskList();

                try
                {
                    Scanner scan = new Scanner(System.in);
                    int index;
                    String title;
                    String description;
                    String dueDate;

                    System.out.print("Which task will you edit? ");
                    index = scan.nextInt();
                    scan.nextLine();

                    System.out.printf("Enter a new title for task " + index + ": ");
                    title = scan.nextLine();
                    System.out.printf("Enter a new description for task" + index + ": ");
                    description = scan.nextLine();
                    System.out.printf("Enter a new task due date (YYYY-MM-DD) for task " + index + ": ");
                    dueDate = scan.nextLine();

                    taskList.editItem(index, taskList.getItemList().size(), title, description, dueDate);
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
                taskList.printTaskList();

                int size = taskList.getItemList().size();

                // pick an index and takes to the list item referred --> getItem
                System.out.println("Which task will you remove?");
                Scanner index2 = new Scanner(System.in);
                int getItem2 = index2.nextInt();

                // delete the task from the array list
                taskList.removeItem(getItem2, size);

                System.out.println("Task successfully deleted!");
                return true;
            }

            // mark item
            else if (option == 7)
            {
                taskList.printTaskList();

                int size = taskList.getItemList().size();
                int userInput;
                int uncompletedListSize = 0;
                Scanner input = new Scanner(System.in);

                System.out.println("Uncompleted Tasks");
                System.out.println("----------------");

                for (int i = 0; i < size; i++) {
                    if(!taskList.getItemList().get(i).isComplete()) {
                        System.out.printf("%d) [%s] %s: %s%n", i,
                                taskList.getItemList().get(i).getDueDate(),
                                taskList.getItemList().get(i).getTitle(),
                                taskList.getItemList().get(i).getDescription());
                        uncompletedListSize++;
                    }
                }
                userInput = input.nextInt();
                taskList.markItem(userInput, uncompletedListSize);

                System.out.println("Task successfully marked!");
                return true;
            }

            // unmark item
            else if (option == 8)
            {
                taskList.printTaskList();

                int size = taskList.getItemList().size();
                int userInput;
                int completedListSize = 0;

                Scanner input = new Scanner(System.in);

                System.out.println("Completed Tasks");
                System.out.println("----------------");

                for (int i = 0; i < size; i++) {
                    if(taskList.getItemList().get(i).isComplete())
                    {
                        System.out.printf("%d) [%s] %s: %s%n", i,
                                taskList.getItemList().get(i).getDueDate(),
                                taskList.getItemList().get(i).getTitle(),
                                taskList.getItemList().get(i).getDescription());
                        completedListSize++;
                    }
                }
                userInput = input.nextInt();
                taskList.unmarkItem(userInput, completedListSize);

                System.out.println("Task successfully unmarked!");
                return true;
            }

            // save list
            else if (option == 5)
            {
                String fileName;
                Scanner input = new Scanner(System.in);

                System.out.print("Enter the filename to save as: ");
                fileName = input.nextLine();
                taskList.saveFile(fileName);

                System.out.println("List successfully saved!");
                return true;
            }

            // quit and go back to main menu
            else if (option == 6)
            {
                // TODO: printMainMenu() instead
                printMainMenuTask();
                return false;
            }

            // default error --> wrong integer
            else
            {
                System.out.println("Invalid Entry! Please use the keys 1-6");
                return true;
            }
        }

        // any key besides an integer
        catch(InputMismatchException ex)
        {
            System.out.println("Invalid entry! Please use the keys 1-6");
            userInput.nextLine();
            return true;
        }
    }
}
