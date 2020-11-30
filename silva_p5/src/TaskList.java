import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// A class that maintains a collection of these data items
public class TaskList
{
    // A task list shall contain 0 or more task items
    private static ArrayList<TaskItem> myList;

    public TaskList()
    {
        myList = new ArrayList<>();
    }

    public TaskList(String fileName) throws FileNotFoundException
    {
        myList = new ArrayList<>();

        loadList(fileName);
    }

    public ArrayList<TaskItem> getItemList()
    {
        return this.myList;
    }

    public void loadList(String fileName)
    {
        ArrayList<TaskItem> loadedList = myList;
        myList = new ArrayList<>();

        try
        {
            Scanner input = new Scanner(new File(fileName));
            String type = input.nextLine();

            if (type.equalsIgnoreCase("TaskList"))
            {
                while (input.hasNext())
                {
                    String title = input.nextLine();
                    String description = input.nextLine();
                    String dueDate = input.nextLine();

                    TaskItem taskItem = new TaskItem(title, description, dueDate);

                    this.addItem(taskItem);
                }
            }

            else
            {
                myList = loadedList;
                throw new InputMismatchException("Filename entered is invalid.");
            }
        }
        catch (FileNotFoundException ex)
        {
            myList = loadedList;
            throw new InputMismatchException("There are no files with that name.");

        }
    }
// ------------------------------------------------------------------------------------------------------------------
//                                      Operational Menu Functions
// ------------------------------------------------------------------------------------------------------------------

    // Case 1
    public static void printTaskList()
    {
        if(myList.size() < 1)
            System.out.println("empty list");
        else
        {
            System.out.println("Current Tasks");
            System.out.println("-------------");
            for(int i = 0; i < myList.size(); i++)
            {
                System.out.printf(i+")");
                TaskItem itemPrint = myList.get(i);
                itemPrint.printItem();
            }
        }
    }

    // Case 2
    public void addItem(TaskItem newItem)
    {
        myList.add(newItem);
    }

    // Case 3
    public void editItem(int index, int size, String title, String description, String dueDate)
    {
        TaskItem temp = new TaskItem(title, description, dueDate);

        try
        {
            if (size == 0)
            {
                throw new IllegalArgumentException("ERROR: No existing tasks");
            }

            if(index > size || index < 0)
            {
                throw new IllegalArgumentException("ERROR: Choose an available index");
            }

            temp.setTitle(title);
            temp.setDescription(description);
            temp.setDueDate(dueDate);

            myList.set(index, temp);
        }

        catch (IllegalArgumentException ex)
        {
            System.out.println("Failed to edit item!");
        }
    }

    // Case 4
    public void removeItem(int index, int size)
    {
        try
        {
            if (size == 0)
            {
                throw new IllegalArgumentException("ERROR: No existing tasks");
            }
            if(index > size || index < 0)
            {
                throw new IllegalArgumentException("ERROR: Choose an available index");
            }
            myList.remove(index);
        }

        catch (Exception ex)
        {
            System.out.println("Enter proper index or no tasks available to remove");
        }
    }

    // Case 7
    public void markItem(int index, int uncompletedListSize)
    {
        try
        {
            if(uncompletedListSize == 0)
            {
                throw new IllegalArgumentException("ERROR: There are no uncompleted tasks");
            }
            if(index > uncompletedListSize || index < 0)
            {
                throw new IllegalArgumentException("ERROR: Choose an existing task");
            }
            myList.get(index).setComplete(true);
        }

        catch (IllegalArgumentException ex)
        {
            System.out.println("ERROR marking item");
        }
    }

    // Case 8
    public void unmarkItem(int index, int completedListSize)
    {
        try
        {
            if(completedListSize == 0)
            {
                throw new IllegalArgumentException("ERROR: There are no Completed tasks");
            }
            if(index > completedListSize || index < 0)
            {
                throw new IllegalArgumentException("ERROR: Choose an existing task");
            }
            myList.get(index).setComplete(false);
        }

        catch (IllegalArgumentException ex)
        {
            System.out.println("ERROR unmarking item");
        }
    }

    // Case 5
    public void saveFile(String fileName)
    {
        try
        {
            Formatter file = new Formatter(fileName);
            for (TaskItem item: myList)
            {
                file.format(item.getTitle() +"\n" + item.getDescription() +"\n"+ item.getDueDate());
            }
            file.close();
        }

        catch (Exception ex)
        {
            System.out.println("Error saving...");
        }

        System.out.println("");
    }

    public TaskItem getItem(int givenIndex)
    {
        return myList.get(givenIndex);
    }

    public int getListSize()
    {
        return myList.size();
    }
}
