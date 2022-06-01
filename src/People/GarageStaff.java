package People;

import Authenticate.AValider;
import Authenticate.Identifiable;


public abstract class GarageStaff extends Person implements Identifiable, AValider{
    String _id;
    String _password;

    public GarageStaff(String lastName, String FirstName, String address, String phoneNumber, String id, String password)
    {
        super(lastName, FirstName, address, phoneNumber);
        _id = id;
        _password = password;
    }


    @Override
    public String getId()
    {
        return _id;
    }

    @Override
    public void setId(String id)
    {
        _id = id;
    }

    @Override
    public Boolean isValid(String element)
    {
        if(_password == element)
            return true;
        return false;
    }

    @Override
    public Boolean validate()
    {
        return true; // TODO search what we need to validate
    }

    public abstract String toString();
}