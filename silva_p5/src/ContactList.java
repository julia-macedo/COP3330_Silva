import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

// A class that maintains a collection of these data items
public class ContactList
{
    // A task list shall contain 0 or more task items
    private static ArrayList<ContactItem> myList;

    public ContactList()
    {
        myList = new ArrayList<>();
    }

    public ContactList(String fileName) throws FileNotFoundException
    {
        myList = new ArrayList<>();

        loadList(fileName);
    }

    public ArrayList<ContactItem> getItemList()
    {
        return this.myList;
    }

// ------------------------------------------------------------------------------------------------------------------
//                                      Saving and Loading Methods
// ------------------------------------------------------------------------------------------------------------------

    public void loadList(String fileName)
    {
        ArrayList<ContactItem> loadedList = myList;
        myList = new ArrayList<>();

        try
        {
            Scanner input = new Scanner(new File(fileName));
            String type = input.nextLine();

            if (type.equalsIgnoreCase("ContactList"))
            {
                while (input.hasNext())
                {
                    String firstName = input.nextLine();
                    String lastName = input.nextLine();
                    String phoneNumber = input.nextLine();
                    String email = input.nextLine();

                    ContactItem contactItem = new ContactItem(firstName, lastName, phoneNumber, email);

                    this.addItem(contactItem);
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
    public static void printContactList()
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
                ContactItem itemPrint = myList.get(i);
                itemPrint.printItem();
            }
        }
    }

    // Case 2
    public void addItem(ContactItem newItem)
    {
        myList.add(newItem);
    }

    // Case 3
    public void editItem(int index, int size, String firstName, String lastName, String phoneNumber, String email)
    {
        ContactItem temp = new ContactItem(firstName, lastName, phoneNumber, email);

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

            temp.setFirstName(firstName);
            temp.setLastName(lastName);
            temp.setPhoneNumber(phoneNumber);
            temp.setEmail(email);

            myList.set(index, temp);
        }

        catch (IllegalArgumentException ex)
        {
            System.out.println("Fails to edit!");
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

    // Case 5

    public void saveFile(String fileName)
    {
        try
        {
            Formatter file = new Formatter(fileName);
            for (ContactItem item: myList)
            {
                file.format(item.getFirstName() +"\n" + item.getLastName() +"\n"+ item.getPhoneNumber()+"\n"+ item.getEmail());
            }
            file.close();
        }

        catch (Exception ex)
        {
            System.out.println("Error saving...");
        }

        System.out.println("");
    }

    public ContactItem getItem(int givenIndex)
    {
        return myList.get(givenIndex);
    }

    public int getListSize()
    {
        return myList.size();
    }
}
