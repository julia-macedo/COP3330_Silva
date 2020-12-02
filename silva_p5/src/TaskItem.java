// A data model of the items that are going to be stored in the task list
public class TaskItem extends Item // Inheritance
{
    public TaskItem(String title, String description, String dueDate)
    {
        super(title, description, dueDate);
    }
}
