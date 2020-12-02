import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest
{
    @Test
    public void addingItemsIncreasesSize()
    {
        ContactList listTest = new ContactList();

        int size = listTest.getListSize();

        Item newItem =  new Item("Bad", "Bunny", "3059990000","badbunnybaby@miami.com");

        listTest.addItem(newItem);

        assertEquals(listTest.getListSize(), size + 1);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues()
    {
        ContactList listTest = new ContactList();
        Item newItem = new Item("Bad", "Bunny", "3059990000","badbunnybaby@miami.com");
        listTest.addItem(newItem);

        assertThrows(IllegalArgumentException.class,() -> listTest.editItem(0,1, "", "", "", ""));
    }

    @Test
    public void editingItemsFailsWithInvalidIndex()
    {
        ContactList listTest = new ContactList();
        Item newItem = new Item("Bad", "Bunny", "3059990000","badbunnybaby@miami.com");
        listTest.addItem(newItem);

        assertThrows(IllegalArgumentException.class,() -> listTest.editItem(6,1, "Julia", "Silva", "4078888777", "jujuonthebeat@gmail.com"));
    }

    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        ContactList listTest = new ContactList();
        Item newItem = new Item("Bad", "Bunny", "3059990000","julia@hotmail.com");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,1, "", "Bunny", "3059990000", "julia@hotmail.com"));
    }

    @Test
    public void editingSucceedsWithBlankLastName()
    {
        ContactList listTest = new ContactList();
        Item newItem = new Item("Bad", "Bunny", "3059990000","julia@hotmail.com");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,1, "Bad", "", "3059990000", "julia@hotmail.com"));
    }

    @Test
    public void editingSucceedsWithBlankPhone()
    {
        ContactList listTest = new ContactList();
        Item newItem = new Item("Bad", "Bunny", "3059990000","julia@hotmail.com");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,1, "Bad", "Bunny", "", "julia@hotmail.com"));
    }

    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        ContactList listTest = new ContactList();
        Item newItem = new Item("Bad", "Bunny", "3059990000","julia@hotmail.com");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,1, "Julia", "Silva", "4074079999", "badbunny@baby.com"));
    }

    @Test
    public void newListIsEmpty()
    {
        ContactList listTest = new ContactList();
        int size = listTest.getListSize();
        assertEquals(listTest.getListSize(), 0);
    }

    @Test
    public void removingItemsDecreasesSize()
    {
        ContactList listTest = new ContactList();

        Item newItem1 = new Item("Julia", "Testing Cases", "7776668888", "juju@ucf.edu");
        Item newItem2 = new Item("Julian", "Testing Case", "1112223333","juju@ucf.edu");
        Item newItem3 = new Item("Julie", "Testing Casos", "5554449999","juju@ucf.edu");

        listTest.addItem(newItem1);
        listTest.addItem(newItem2);
        listTest.addItem(newItem3);

        int size = listTest.getListSize();

        listTest.removeItem(2,size);

        assertEquals(listTest.getListSize(), size - 1);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        ContactList listTest = new ContactList();

        Item newItem1 = new Item("Julia", "Testing Cases", "7776668888", "juju@ucf.edu");
        Item newItem2 = new Item("Julian", "Testing Case", "1112223333","juju@ucf.edu");
        Item newItem3 = new Item("Julie", "Testing Casos", "5554449999","juju@ucf.edu");

        listTest.addItem(newItem1);
        listTest.addItem(newItem2);
        listTest.addItem(newItem3);

        int size = listTest.getListSize();

        assertThrows(IllegalArgumentException.class,() ->  listTest.removeItem(8,size));
    }

    @Test
    public void savedContactListCanBeLoaded()
    {
        ContactList listTest = new ContactList();
        Item newItem = new Item("Julia", "Testing Cases", "1112223333", "juju@ucf.edu");
        Item newItem2 = new Item("Julian", "Testing Case", "8889997777","juju@ucf.eud");
        listTest.addItem(newItem);
        listTest.addItem(newItem2);

        listTest.saveFile("juju1.txt");

        assertDoesNotThrow(() -> listTest.loadList("juju1.txt"));
    }
}
