// A data model of the items that are going to be stored in the task list
public class ContactItem extends Item // Inheritance
{
    public ContactItem(String firstName, String lastName, String phoneNumber, String email)
    {
        super(firstName, lastName, phoneNumber, email);
    }
}
