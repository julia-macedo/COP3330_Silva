import java.lang.IllegalArgumentException;

// A data model of the items that are going to be stored in the task list
public class ContactItem extends Item // Inheritance
{
    public ContactItem(String firstName, String lastName, String phoneNumber, String email)
    {
        super(firstName, lastName, phoneNumber, email);
    }

    /*
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

// ------------------------------------------------------------------------------------------------------------------
//                                            Class Constructor
// ------------------------------------------------------------------------------------------------------------------

    public ContactItem(String firstName, String lastName, String phoneNumber, String email)
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

// ------------------------------------------------------------------------------------------------------------------
//                                               Checker Methods
// ------------------------------------------------------------------------------------------------------------------

    public boolean isInputValid(String userInput) { return userInput.length() > 0 ;}

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

// ------------------------------------------------------------------------------------------------------------------
//                                           Printing Methods
// ------------------------------------------------------------------------------------------------------------------

   public void printItem()
    {
        System.out.println("First Name:" + firstName);
        System.out.println("Last Name:" + lastName);
        System.out.println("Phone Number:" + phoneNumber);
        System.out.println("Email Address:" + email);
    }
    */
}
