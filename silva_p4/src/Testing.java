import org.junit.jupiter.api.Test;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Testing
{

// ------------------------------------------------------------------------------------------------------------------
//                                Testing Task Item
// ------------------------------------------------------------------------------------------------------------------

    @Test // ok
    public void creatingTaskItemFailsWithInvalidDueDate()
    {
        TaskItem itemTest = new TaskItem("One direction", "yellow submarine", "2020-13-37");
    }

    @Test // ok
    public void creatingTaskItemFailsWithInvalidTitle()
    {
        TaskItem itemTest = new TaskItem("", "yellow submarine", "2020-11-16");
    }

    @Test // ok
    public void creatingTaskItemSucceedsWithValidDueDate()
    {
        TaskItem itemTest = new TaskItem("One direction", "yellow submarine", "2020-11-16");
        assertEquals("2020-11-16", itemTest.getDueDate());
    }

    @Test // ok
    public void creatingTaskItemSucceedsWithValidTitle()
    {
        TaskItem itemTest = new TaskItem("One", "yellow submarine", "2020-11-16");
        assertEquals("One", itemTest.getTitle());
    }

    @Test // ok
    public void settingTaskItemDueDateFailsWithInvalidDate()
    {
        TaskItem itemTest = new TaskItem("One", "yellow submarine", "jan - 09 - 1998");
        itemTest.setDueDate("jan - 09 - 1998");
    }

    @Test // ok
    public void settingTaskItemDueDateSucceedsWithValidDate()
    {
        TaskItem itemTest = new TaskItem("One", "yellow submarine", "2020-11-16");
        itemTest.setDueDate("2020-11-16");
    }

    @Test // ok
    public void settingTaskItemTitleFailsWithInvalidTitle()
    {
        TaskItem itemTest = new TaskItem("", "yellow submarine", "2020-11-16");
        itemTest.setTitle("");
    }

    @Test // ok
    public void settingTaskItemTitleSucceedsWithValidTitle()
    {
        TaskItem itemTest = new TaskItem("One", "yellow submarine", "2020-11-16");
        itemTest.setTitle("One");
    }

// ------------------------------------------------------------------------------------------------------------------
//                                        Testing Task List
// ------------------------------------------------------------------------------------------------------------------

    @Test // ok
    public void addingTaskItemsIncreasesSize()
    {
        TaskList listTest = new TaskList();
        int size = listTest.getListSize();
        listTest.addItem("Julia", "Silva", "2020-10-06");
        assertEquals(listTest.getListSize(), size + 1);
    }

    @Test // ok
    public void completingTaskItemChangesStatus()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("Shawn", "Mendes", "2020-10-02");
        listTest.addItem("Camilla", "Cabello", "2020-09-01");
        listTest.markItem(0);
    }

    @Test // ok
    public void completingTaskItemFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("Shawn", "Mendes", "2020-10-02");
        listTest.addItem("Camilla", "Cabello", "2020-09-01");
        listTest.markItem(7);
    }

    @Test // ok
    public void editingTaskItemChangesValues()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("BadBunny", "1", "2020-01-18");
        String title = listTest.getItem(0).getTitle();
        String description = listTest.getItem(0).getDescription();
        String dueDate = listTest.getItem(0).getDueDate();
        listTest.editItem(0,"JBalvin", "2", "2020-01-19");
        assert(!listTest.getItem(0).getTitle().equals(title));
        assert(!listTest.getItem(0).getDescription().equals(description));
        assert(!listTest.getItem(0).getDueDate().equals(dueDate));
    }

    @Test // ok
    public void editingTaskItemDescriptionChangesValue()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("BadBunny", "1", "2020-01-18");
        String description = listTest.getItem(0).getDescription();
        listTest.editItem(0,"BadBunny", "2", "2020-01-18");
        assert(!listTest.getItem(0).getDescription().equals(description));
    }

    @Test // ok
    public void editingTaskItemDescriptionFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("BadBunny", "1", "2020-01-18");
        String description = listTest.getItem(0).getDescription();
        listTest.editItem(9,"BadBunny", "2", "2020-01-18");
        assert(!listTest.getItem(9).getDescription().equals(description));
    }

    @Test // ok
    public void editingTaskItemDueDateChangesValue()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("BadBunny", "1", "2020-01-18");
        String description = listTest.getItem(0).getDescription();
        listTest.editItem(0,"BadBunny", "1", "2020-01-17");
        assert(!listTest.getItem(0).getDescription().equals(description));
    }

    @Test // ok
    public void editingTaskItemDueDateFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("BadBunny", "1", "2020-01-18");
        String description = listTest.getItem(0).getDescription();
        listTest.editItem(9,"BadBunny", "1", "2020-01-17");
        assert(!listTest.getItem(9).getDescription().equals(description));
    }

    @Test // ok
    public void editingTaskItemTitleChangesValue()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("BadBunny", "1", "2020-01-18");
        String description = listTest.getItem(0).getDescription();
        listTest.editItem(0,"JBalvin", "1", "2020-01-18");
        assert(!listTest.getItem(0).getDescription().equals(description));
    }

    @Test // ok
    public void editingTaskItemTitleFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("BadBunny", "1", "2020-01-18");
        String description = listTest.getItem(0).getDescription();
        listTest.editItem(9,"JBalvin", "1", "2020-01-18");
        assert(!listTest.getItem(9).getDescription().equals(description));
    }

    @Test // ok
    public void gettingTaskItemDescriptionFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("Thomaz", "HSI", "2020-07-04");
        String description = listTest.getItem(9).getDescription();
        assert(description == null);
    }

    @Test // ok
    public void gettingTaskItemDescriptionSucceedsWithValidIndex()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("Nat", "HSI", "2020-07-04");
        String description = listTest.getItem(0).getDescription();
        assert(description == null);
    }

    @Test // ok
    public void gettingTaskItemDueDateFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("Maria", "HSI", "2020-07-04");
        String description = listTest.getItem(9).getDueDate();
        assert(description == null);
    }

    @Test // ok
    public void gettingTaskItemDueDateSucceedsWithValidIndex()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("Juan", "HSI", "2020-07-04");
        String description = listTest.getItem(0).getDueDate();
        assert(description == null);
    }

    @Test // ok
    public void gettingTaskItemTitleFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("Juan", "HSI", "2020-07-04");
        String description = listTest.getItem(9).getTitle();
        assert(description == null);
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("Karen", "HSI", "2020-07-04");
        String description = listTest.getItem(0).getTitle();
        assert(description == null);
    }

    @Test // ok
    public void newTaskListIsEmpty()
    {
        TaskList listTest = new TaskList();
        assertEquals(listTest.getListSize(), 0);
    }

    // check list size and delete success
    @Test // ok
    public void removingTaskItemsDecreasesSize()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("Julia", "Silva", "2020-10-06");
        int size = listTest.getListSize();
        listTest.deleteItem(7);
        assertEquals(listTest.getListSize(), size - 1);
    }

    // invalid index --> delete
    @Test // ok
    public void removingTaskItemsFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("Justin", "Bieber", "2020-11-16");
        listTest.addItem("Selena", "Gomez", "2020-12-16");
        int size = listTest.getListSize();
        listTest.deleteItem(1);
        assertEquals(listTest.getListSize(), size);
    }

    @Test // don't have the method sorry
    public void savedTaskListCanBeLoaded()
    {

    }

    // unmark success
    @Test // ok
    public void uncompletingTaskItemChangesStatus()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("Shawn", "Mendes", "2020-10-02");
        listTest.addItem("Camilla", "Cabello", "2020-09-01");
        listTest.markItem(0);
        listTest.unmarkItem(0);
    }

    // invalid index --> unmark
    @Test // ok
    public void uncompletingTaskItemFailsWithInvalidIndex()
    {
        TaskList listTest = new TaskList();
        listTest.addItem("Shawn", "Mendes", "2020-10-02");
        listTest.addItem("Camilla", "Cabello", "2020-09-01");
        listTest.markItem(0);
        listTest.unmarkItem(8);
    }
}
