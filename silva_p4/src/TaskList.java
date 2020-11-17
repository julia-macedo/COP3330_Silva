import java.util.ArrayList;

// A class that maintains a collection of these data items
public class TaskList
{

    // A task list shall contain 0 or more task items
    private static ArrayList<TaskItem> list;

    TaskList()
    {
        list = new ArrayList<>();
    }


    public static void loadExistingList()
    {

    /*
        TaskList list = new TaskList();

        System.out.println("Enter the filename to load: ");
        String filePath = scanner.nextLine();

        if(list.loadList(filePath)){
            listMenu(list);

     */
    }

// ------------------------------------------------------------------------------------------------------------------
//                                      Operational Menu Functions
// ------------------------------------------------------------------------------------------------------------------

    // Case 1
    public static void printTaskList()
    {
        if(list.size() < 1)
            System.out.println("");
        else
        {
            for(int i = 0; i < list.size(); i++)
            {
                System.out.println(i + ")");
                TaskItem itemPrint = list.get(i);
                itemPrint.printItem();
            }
        }
    }

    // Case 2
    public void addItem(String title, String description, String dueDate)
    {
        TaskItem item = new TaskItem(title,description,dueDate);
        list.add(item);
    }

    // Case 3
    public static void editItem(int getItem, String newTitle, String newDescription, String newDueDate)
    {
        if(getItem < 0 || getItem >= list.size())
            list.get(getItem);

        TaskItem replaceItem = new TaskItem(newTitle,newDescription,newDueDate);
        list.add(getItem, replaceItem);
    }

    // Case 4
    public static void deleteItem(int getItem2)
    {
        list.remove(getItem2);
    }

    // Case 5
    public static void markItem(int getItem3)
    {
        if(getItem3 < 0 || getItem3 >= list.size())
        // TODO: include "***" before printing item
            list.get(getItem3).setComplete(true);
    }

    // Case 6
    public static void unmarkItem(int getItem4)
    {
        // TODO: remove "***" before printing item
        if(getItem4 < 0 || getItem4 >= list.size())
            list.get(getItem4).setComplete(false);
        else
            System.out.println("Out of bounds, please pick between the available options");
    }

    public TaskItem getItem(int givenIndex)
    {
        return list.get(givenIndex);
    }

    public int getListSize()
    {
        return list.size();
    }

}
