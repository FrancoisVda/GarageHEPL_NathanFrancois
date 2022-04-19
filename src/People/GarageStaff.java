package People;

import Authenticate.AValider;
import Authenticate.Identifiable;


public abstract class GarageStaff extends Person implements Identifiable, AValider{
    String _id;
    String _password;

    public GarageStaff(String firstName, String phoneNumber, String id, String password)
    {
        super(firstName, phoneNumber);
        _id = id;
        _password = password;
    }

    public String getPassword()
    {
        return _password;
    }

    public void setPassword(String password)
    {
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
    public Boolean isValid()
    {
        return true; // TODO search what we need to know if valid
    }

    @Override
    public Boolean validate()
    {
        return true; // TODO search what we need to validate
        // HASTABLE statique
    }

    public abstract String toString();
}