import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskItemTest
{
    // must contain JUnit tests

    // new Item("Julia", "Testing Cases", "2020-12-01")
    @Test
    public void constructorFailsWithInvalidDueDate()
    {
        assertThrows(IllegalArgumentException.class, () -> new Item("Julia", "Testing Cases", "20201201"));
    }

    @Test
    public void constructorFailsWithInvalidTitle()
    {
        assertThrows(IllegalArgumentException.class, () -> new Item("", "Testing Cases", "2020-12-01"));
    }

    @Test
    public void constructorSucceedsWithValidDueDate()
    {
        assertDoesNotThrow(() ->new Item("Julia", "Testing Cases", "2020-12-01"));
    }

    @Test
    public void constructorSucceedsWithValidTitle()
    {
        assertDoesNotThrow(() ->new Item("Julia", "Testing Cases", "2020-12-01"));
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Julia", "Testing Cases", "2020-12-01");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,3,"Julia", "Testing Examples", "2020-12-01"));
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Julia", "Testing Cases", "2020-12-01");

        assertThrows(IllegalArgumentException.class,() -> listTest.editItem(0,3,"Silva", "Testing Cases", "20201213"));
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Julia", "Testing Cases", "2020-10-23");

        assertThrows(IllegalArgumentException.class,() -> listTest.editItem(0,3,"Silva", "Testing Cases", "2020-23-10"));
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Julia", "Testing Cases", "2020-12-01");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,3,"Silva", "Testing Cases", "2020-11-02"));
    }

    @Test
    public void editingTitleFailsWithEmptyString()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Julia", "Testing Cases", "2020-12-01");

        assertThrows(IllegalArgumentException.class,() -> listTest.editItem(0,3,"", "Testing Cases", "2020-12-01"));
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Julia", "Testing Cases", "2020-12-01");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,3,"Silva", "Testing Cases", "2020-12-01"));
    }

}
