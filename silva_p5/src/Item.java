import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item
{
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    private String title;
    private String description;
    private String dueDate;
    private boolean complete;
// ------------------------------------------------------------------------------------------------------------------
//                                            Class Constructors Polymorphism
// ------------------------------------------------------------------------------------------------------------------
    public Item(String firstName, String lastName, String phoneNumber, String email)
    {
        if (isInputValid(firstName) || isInputValid(lastName) || isInputValid(phoneNumber) || isInputValid(email) )
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        else
        {
            throw new IllegalArgumentException("Not all your field can be empty!");
        }
    }

    public Item(String title, String description, String dueDate)
    {
        if (isTitleValid(title))
        {
            this.title = title;
        }
        else
        {
            throw new IllegalArgumentException("This title is not valid; must be at least 1 character long!");
        }

        if (isInputValid(description))
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
            throw new IllegalArgumentException("Wrong format, please use YYYY-MM-DD !");
        }

        //this.complete = true;
    }

// ------------------------------------------------------------------------------------------------------------------
//                                               Checker Methods
// ------------------------------------------------------------------------------------------------------------------
    public boolean isInputValid(String userInput) { return userInput.length() > 0 ;}

    public boolean isTitleValid(String title)
    {
        return title.length() > 1 ;
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
//                                           Getters and Setters Methods
// ------------------------------------------------------------------------------------------------------------------

    public String getFirstName() {return this.firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return this.lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getPhoneNumber() {return this.phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getEmail() {return this.email; }

    public void setEmail(String email) {this.email = email;}

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
//                                           Printing Methods --> Polymorphism
// ------------------------------------------------------------------------------------------------------------------

    public void printItem(String firstName, String lastName, String phoneNumber, String email)
    {
        System.out.println("First Name:" + firstName);
        System.out.println("Last Name:" + lastName);
        System.out.println("Phone Number:" + phoneNumber);
        System.out.println("Email Address:" + email);
    }

    public void printItem(String title, String description, String dueDate)
    {
        if(this.isComplete())
            System.out.println("***[" + dueDate + "] " + title + ": " + description);
        else
            System.out.println("[" + dueDate + "] " + title + ": " + description);
    }
}
