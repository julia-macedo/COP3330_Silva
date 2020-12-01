import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// A class that maintains a collection of these data items
public class ContactList
{
    // A task list shall contain 0 or more task items
    private static ArrayList<ContactItem> myList;

// ------------------------------------------------------------------------------------------------------------------
//                                            Class Constructor
// ------------------------------------------------------------------------------------------------------------------
    public ContactList()
    {
        myList = new ArrayList<>();
    }

    public ArrayList<ContactItem> getItemList() {return this.myList;}

// ------------------------------------------------------------------------------------------------------------------
//                                      Saving and Loading Methods
// ------------------------------------------------------------------------------------------------------------------

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
    public static void printContactList()
    {
        if(myList.size() < 1)
            System.out.println("~empty list~");
        else
        {
            System.out.println("Current Items");
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
    public void addItem(ContactItem newItem) {myList.add(newItem);}

    // Case 3
    public void editItem(int index, int size, String firstName, String lastName, String phoneNumber, String email)
    {
        ContactItem temp = new ContactItem(firstName, lastName, phoneNumber, email);

        try
        {
            if (size == 0)
            {
                throw new IllegalArgumentException("ERROR: No existing");
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
                throw new IllegalArgumentException("ERROR: Non existing");
            }
            if (index > size || index < 0)
            {
                throw new IllegalArgumentException("ERROR: Choose an available index");
            }

            myList.remove(index);
        }

        catch (Exception ex)
        {
            System.out.println("Enter proper index or empty list!");
        }
    }
}
