import java.lang.IllegalArgumentException;

// A data model of the items that are going to be stored in the task list
public class ContactItem
{
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    // private boolean complete;

    public ContactItem(String firstName, String lastName, String phoneNumber, String email)
    {
        if (isFirstNameValid(firstName) || isLastNameValid(lastName) || isPhoneNumberValid(phoneNumber) || isEmailValid(email) )
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
//                                            Helper Methods
// ------------------------------------------------------------------------------------------------------------------

    public boolean isFirstNameValid(String firstName)
    {
        return firstName.length() > 0 ;
    }

    public boolean isLastNameValid(String lastName)
    {
        return lastName.length() > 0 ;
    }

    private boolean isPhoneNumberValid(String phoneNumber)
    {
        /*
        try {
            validatePhoneNumber(phone);
            //more code maybe update the database
        } catch(PhoneNotValidException pe) {
            JOptionPane.showMessageDialog(null,"Please enter a valid phone number");
        } catch(Exception ex) {
            System.err.println("Other error different that Phone not valid");
        }
        */
        return phoneNumber.length() > 0;
    }

    private boolean isEmailValid(String email)
    {
        return email.length() >0;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void printItem()
    {
        System.out.println("First Name:" + firstName);
        System.out.println("Last Name:" + lastName);
        System.out.println("Phone Number:" + phoneNumber);
        System.out.println("Email Address:" + email);
    }

}
