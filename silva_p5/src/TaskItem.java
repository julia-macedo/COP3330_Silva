import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.IllegalArgumentException;
import java.util.Date;

// A data model of the items that are going to be stored in the task list
public class TaskItem extends Item // Inheritance
{
    public TaskItem(String title, String description, String dueDate)
    {
        super(title, description, dueDate);
    }

    /*
    private String title;
    private String description;
    private String dueDate;
    private boolean complete;

// ------------------------------------------------------------------------------------------------------------------
//                                            Class Constructor
// ------------------------------------------------------------------------------------------------------------------

    public TaskItem(String title, String description, String dueDate)
    {
        if (isTitleValid(title))
        {
            this.title = title;
        }
        else
        {
            throw new IllegalArgumentException("This title is not valid; must be at least 1 character long!");
        }

        if (isDescriptionValid(description))
        {
            this.description = description;
        }
        else
        {
            throw new IllegalArgumentException("This description is not valid; must be at least 0 character long!");
        }

        if (isDueDateValid(dueDate))
        {
            this.dueDate = dueDate;
        }
        else
        {
            System.out.println("Wrong format, please use YYYY-MM-DD !");
        }
    }

// ------------------------------------------------------------------------------------------------------------------
//                                            Checker Methods
// ------------------------------------------------------------------------------------------------------------------

    public boolean isTitleValid(String title)
    {
        return title.length() > 1 ;
    }

    public boolean isDescriptionValid(String description)
    {
        return description.length() > 0 ;
    }

    private boolean isDueDateValid(String dueDate)
    {
        if (!dueDate.trim().equals(""))
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setLenient(false);
            try
            {
                Date realDueDate = format.parse(dueDate);
            }

            catch (ParseException e)
            {
                return false;
            }
        }
        return true;
    }

// ------------------------------------------------------------------------------------------------------------------
//                                            Getters and Setters Methods
// ------------------------------------------------------------------------------------------------------------------
    public String getTitle() {return this.title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return this.description;}

    public void setDescription(String description) {this.description = description;}

    public String getDueDate() {return this.dueDate;}

    public void setDueDate(String dueDate)
    {
        if(isDueDateValid(dueDate))
        {
            this.dueDate = dueDate;
        }

        else
        {
            System.out.println("Wrong format, please use YYYY-MM-DD !");
        }
    }

    public boolean isComplete() {return this.complete;}

    public void setComplete(boolean complete) {this.complete = complete;}

// ------------------------------------------------------------------------------------------------------------------
//                                            Printing Methods
// ------------------------------------------------------------------------------------------------------------------

    public void printItem()
    {
        if(this.isComplete())
            System.out.println("***[" + dueDate + "] " + title + ": " + description);
        else
            System.out.println("[" + dueDate + "] " + title + ": " + description);
    }
  */
}
