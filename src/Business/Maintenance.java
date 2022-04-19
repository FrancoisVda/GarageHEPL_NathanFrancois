package Business;

import People.Mechanic;
import Vehicle.Car;

public class Maintenance extends Work{
    String _type;

    public Maintenance(Mechanic mechanicResponsible, Car carTreated, String type, String note)
    {
        super(mechanicResponsible, carTreated, note);
        _type = type;
    }

    public String getType()
    {
        return _type;
    }

    public void setType(String type)
    {
        _type = type;
    }
}
