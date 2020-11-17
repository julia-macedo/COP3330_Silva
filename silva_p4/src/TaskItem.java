import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.lang.IllegalArgumentException;
import java.util.Date;

// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

// A data model of the items that are going to be stored in the task list
public class TaskItem
{
    /*
    An task item shall contain a title
        A title shall be 1 or more characters in length
    An task item shall contain a description
        A description shall be 0 or more characters in length
    An task item shall contain a due date
        A due date shall be in the format of YYYY-MM-DD
    */

    private String title;
    private String description;
    private String dueDate;
    private boolean complete;

    TaskItem(String title, String description, String dueDate)
    {
        if (isTitleValid(title))
            this.title = title;
        else
            throw new IllegalArgumentException("This title is not valid; must be at least 1 character long!");

        if (isDescriptionValid(description))
            this.description = description;
        else
            throw new IllegalArgumentException("This description is not valid; must be at least 0 character long!");

        if(isDueDateValid(dueDate))
        {
            this.dueDate = dueDate;
        }
        else
            {
                System.out.println("Wrong format, please use YYYY-MM-DD !");
            }

        // this.complete = complete;
    }

// ------------------------------------------------------------------------------------------------------------------
//                                Helper Methods
// ------------------------------------------------------------------------------------------------------------------

    public boolean isDescriptionValid(String description)
    {
        // the only requirement is to be longer than 0
        if (description == null || description.length() < 1)
            return false;
        else
            return true;
    }

    public boolean isTitleValid(String title)
    {
        /*
        String possible = "^[A-Za-z]\\w{5,29}$";
        // Compile the possible patterns
        Pattern p = Pattern.compile(regex);
        // title is empty
        if (title == null)
            return false;
        // matching given title and allowed chars
        Matcher m = p.matcher(title);
        // Return if the title is approved
        return m.matches();
        */

        if (title == null || title.length() < 1)
            return false;
        else
            return true;
    }


    private boolean isDueDateValid(String dueDate)
    {
        if (!dueDate.trim().equals(""))
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setLenient(false);
            try {
                Date realDueDate = format.parse(dueDate);
            } catch (ParseException e)
                {
                    return false;
                }
        }
        return true;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDueDate()
    {
        return this.dueDate;
    }

    public void setDueDate(String dd)
    {
        if(isDueDateValid(dd))
        {
            this.dueDate = dd;
        } else
            {
            System.out.println("Wrong format, please use YYYY-MM-DD !");
        }
    }

    public boolean isComplete()
    {
        return complete;
    }

    public void setComplete(boolean complete)
    {
        this.complete = complete;
    }

    public void printItem()
    {
        if(this.isComplete())
            System.out.println("***[" + dueDate + "] " + title + ": " + description );
        else
            System.out.println("[" + dueDate + "] " + title + ": " + description );
    }

}
