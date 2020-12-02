import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest
{
    @Test
    public void addingItemsIncreasesSize()
    {
        TaskList listTest = new TaskList();

        int size = listTest.getListSize();

        Item newItem = new Item("Julia", "Testing Cases", "2020-12-01");

        listTest.addItem(newItem);

        assertEquals(listTest.getListSize(), size + 1);
    }

    @Test
    public void completingTaskItemChangesStatus()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny", "2020-12-01");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.markItem(0,1));
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny", "2020-12-01");
        listTest.addItem(newItem);

        assertThrows(IndexOutOfBoundsException.class,() -> listTest.markItem(2,1));
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny", "2020-12-01");
        listTest.addItem(newItem);

        assertThrows(IllegalArgumentException.class,() -> listTest.editItem(4,1, "Julia", "Silva", "2020-12-02"));
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Julia", "Testing Cases", "2020-12-01");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,1,"Julia", "Silva", "2020-12-01"));
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Julia", "Testing Cases", "2020-12-01");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,1,"Julia", "Testing Cases", "2020-11-02"));
    }

    @Test
    public void editingItemTitleFailsWithEmptyString()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny","2020-12-01");
        listTest.addItem(newItem);

        assertThrows(IllegalArgumentException.class,() -> listTest.editItem(0,1, "", "Bunny", "2020-12-01"));
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny","2020-12-01");
        listTest.addItem(newItem);

        assertThrows(IllegalArgumentException.class,() -> listTest.editItem(4,1, "Bud", "Bunny", "2020-12-01"));
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Julia", "Testing Cases", "2020-12-01");
        listTest.addItem(newItem);

        assertDoesNotThrow(() -> listTest.editItem(0,1,"Silva", "Testing Cases", "2020-12-01"));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny", "2020-12-01");
        listTest.addItem(newItem);

        assertThrows(IllegalArgumentException.class,() -> listTest.editItem(0,0, "Bad", "Bunny", "15122020"));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny","2020-12-01");
        listTest.addItem(newItem);

        assertThrows(IllegalArgumentException.class,() -> listTest.editItem(5,1, "Bad", "Bunny", "2020-12-02"));
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny", "2020-12-01");
        listTest.addItem(newItem);

        assertThrows(IllegalArgumentException.class,() -> listTest.editItem(0,1, "Bad", "Bunny", "18202015"));
    }

    @Test
    public void gettingItemDescriptionFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny", "2020-12-01");
        listTest.addItem(newItem);

        assertThrows(IndexOutOfBoundsException.class,() ->  listTest.getDescriptionWithIndex(5));
    }

    @Test
    public void gettingItemDescriptionSucceedsWithValidIndex()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny", "2020-12-01");
        listTest.addItem(newItem);

        assertDoesNotThrow(() ->  listTest.getDescriptionWithIndex(0));
    }

    @Test
    public void  gettingItemDueDateFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny", "2020-12-01");
        listTest.addItem(newItem);

        assertThrows(IndexOutOfBoundsException.class,() ->  listTest.getDueDateWithIndex(5));
    }

    @Test
    public void gettingItemDueDateSucceedsWithValidIndex()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny", "2020-12-01");
        listTest.addItem(newItem);

        assertDoesNotThrow(() ->  listTest.getDueDateWithIndex(0));
    }

    @Test
    public void gettingItemTitleFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny", "2020-12-01");
        listTest.addItem(newItem);

        assertThrows(IndexOutOfBoundsException.class,() ->  listTest.getTitleWithIndex(5));
    }

    @Test
    public void gettingItemTitleSucceedsWithValidIndex()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny", "2020-12-01");
        listTest.addItem(newItem);

        assertDoesNotThrow(() ->  listTest.getTitleWithIndex(0));
    }

    @Test
    public void newListIsEmpty()
    {
        TaskList listTest = new TaskList();
        int size = listTest.getListSize();
        assertEquals(listTest.getListSize(), 0);
    }

    @Test
    public void removingItemsDecreasesSize()
    {
        TaskList listTest = new TaskList();

        Item newItem1 = new Item("Julia", "Testing Cases", "2020-12-01");
        Item newItem2 = new Item("Julian", "Testing Case", "2020-12-02");
        Item newItem3 = new Item("Julie", "Testing Casos", "2020-12-03");

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
        TaskList listTest = new TaskList();

        Item newItem1 = new Item("Julia", "Testing Cases", "2020-12-01");
        Item newItem2 = new Item("Julian", "Testing Case", "2020-12-02");
        Item newItem3 = new Item("Julie", "Testing Casos", "2020-12-03");

        listTest.addItem(newItem1);
        listTest.addItem(newItem2);
        listTest.addItem(newItem3);

        int size = listTest.getListSize();

        assertThrows(IllegalArgumentException.class,() ->  listTest.removeItem(5,size));
    }

    @Test
    public void savedTaskListCanBeLoaded()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Julia", "Testing Cases", "2020-12-01");
        Item newItem2 = new Item("Julian", "Testing Case", "2020-12-02");
        listTest.addItem(newItem);
        listTest.addItem(newItem2);

        listTest.saveFile("juju.txt");

        assertDoesNotThrow(() -> listTest.loadList("juju.txt"));
    }

    @Test
    public void uncompletingTaskItemChangesStatus()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny", "2020-12-01");
        listTest.addItem(newItem);
        listTest.markItem(0,1);

        assertDoesNotThrow(() -> listTest.unmarkItem(0,1));
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        Item newItem = new Item("Bad", "Bunny", "2020-12-01");
        listTest.addItem(newItem);
        listTest.markItem(0,1);

        assertThrows(IllegalArgumentException.class, () -> listTest.unmarkItem(2,1));
    }

}
