import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest // all good
{
    // must contain JUnit tests

    // ContactItem itemTest = new ContactItem("Julia", "Silva", "4074440000", "juju@gmail.com");
    @Test
    public void creationFailsWithAllBlankValues()
    {
        assertThrows(IllegalArgumentException.class, () -> new ContactItem("", "", "", ""));
    }

    @Test
    public void creationSucceedsWithBlankEmail()
    {
        assertDoesNotThrow(() -> new Item("Julia", "Silva", "4074440000", ""));
    }

    @Test
    public void creationSucceedsWithBlankFirstName()
    {
        assertDoesNotThrow(() -> new Item("", "Silva", "4074440000", "juju@gmail.com"));
    }

    @Test
    public void creationSucceedsWithBlankLastName()
    {
        assertDoesNotThrow(() -> new Item("Julia", "", "4074440000", "juju@gmail.com"));
    }

    @Test
    public void creationSucceedsWithBlankPhone()
    {
        assertDoesNotThrow(() -> new Item("Julia", "Silva", "", "juju@gmail.com"));
    }

    @Test
    public void creationSucceedsWithNonBlankValues()
    {
        assertDoesNotThrow(() ->new Item("Julia", "Silva", "4074440000", "juju@gmail.com"));
    }

    @Test
    public void editingFailsWithAllBlankValues()
    {
        ContactList listTest = new ContactList();
        Item newItem = new Item("Bad", "Bunny", "3059990000","badbunnybaby@miami.com");
        listTest.addItem(newItem);

        assertThrows(IllegalArgumentException.class,() -> listTest.editItem(0,1, "", "", "", ""));
    }

    @Test
    public void editingSucceedsWithBlankEmail()
    {
        ContactList listTest = new ContactList();
        Item newItem = new Item("Bad", "Bunny", "3059990000","");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,4, "Baddy", "Bun", "3050009999", ""));
    }

    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        ContactList listTest = new ContactList();
        Item newItem = new Item("", "Bunny", "3059990000","badbunnybaby@miami.com");
        listTest.addItem(newItem);

        assertDoesNotThrow(() ->listTest.editItem(0,4, "", "Bun", "3050009999", "miamibad@bunny.com"));
    }

    @Test
    public void editingSucceedsWithBlankLastName()
    {
        ContactList listTest = new ContactList();
        Item newItem = new Item("Bad", "", "3059990000","badbunnybaby@miami.com");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,4, "Baddy", "", "3050009999", "miamibad@bunny.com"));
    }

    @Test
    public void editingSucceedsWithBlankPhone()
    {
        ContactList listTest = new ContactList();
        Item newItem = new Item("Bad", "Bunny", "","badbunnybaby@miami.com");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,4, "Baddy", "Bun", "", "miamibad@bunny.com"));
    }

    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        ContactList listTest = new ContactList();
        Item newItem = new Item("Bad", "Bunny", "3059990000","badbunnybaby@miami.com");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,4, "Baddy", "Bun", "3050009999", "miamibad@bunny.com"));
    }

    @Test
    public void testToString()
    {

    }
}
