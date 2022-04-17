package People;

/*
 * @author Nathan Et Francois
 */
public class Person {
    protected String _lastName;
    protected String _firstName;
    protected String _address;
    protected String _phoneNumber;

    public Person(String phoneNumber)
    {
        _phoneNumber = phoneNumber;
    }

    public Person( String lastName, String FirstName, String address, String phoneNumber)
    {
        _lastName = lastName;
        _firstName = FirstName;
        _address = address;
        _phoneNumber = phoneNumber;
    }

    public String getLastName()
    {
        return _lastName;
    }

    public String getFirstName()
    {
        return _firstName;
    }

    public String getAddress()
    {
        return _address;
    }

    public String getPhoneNumber()
    {
        return _phoneNumber;
    }

    public void setLastName(String lastName)
    {
        _lastName = lastName;
    }

    public void setFirstName(String firstName)
    {
        _firstName = firstName;
    }

    public void setAddress(String address)
    {
        _address = address;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        _phoneNumber = phoneNumber;
    }
}

