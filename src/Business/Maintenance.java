package Business;

import People.Mechanic;
import Vehicle.Car;

public class Maintenance extends Work{
    String _type;

    public Maintenance(Mechanic mechanicResponsible, Car carTreated, String type)
    {
        super(mechanicResponsible, carTreated);
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
