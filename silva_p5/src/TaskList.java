import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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

    public ArrayList<TaskItem> getItemList()
    {
        return this.myList;
    }
// ------------------------------------------------------------------------------------------------------------------
//                                      Saving and Loading Methods
// ------------------------------------------------------------------------------------------------------------------

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

    public void loadList(String fileName)
    {
        try
        {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }

        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
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

    /*
    public TaskItem getItem(int givenIndex)
    {
        return myList.get(givenIndex);
    }

    public int getListSize()
    {
        return myList.size();
    }
    */
}
