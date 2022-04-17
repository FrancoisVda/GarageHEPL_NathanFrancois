package People;

import Authenticate.AValider;
import Authenticate.Identifiable;

/*
 * @author Nathan Et Francois
 */
public abstract class GarageStaff extends Person implements Identifiable, AValider{
    String _id;
    String _password;

    public GarageStaff(String phoneNumber, String id)
    {
        super(phoneNumber);
        _id = id;
        _password = "";
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
}