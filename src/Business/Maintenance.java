package Business;

import People.Mechanic;
import Vehicle.Car;

public class Maintenance extends Work{
    String _type;

    public Maintenance(Mechanic mechanicResponsible, Car carTreated, String note, String type)
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

    @Override
    public String toString() {
        return _note + " (Entretien)";
    }
}
