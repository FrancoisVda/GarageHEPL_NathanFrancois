package Business;

import People.Mechanic;
import Vehicle.Car;

public class Repair extends Work{
    String _area;

    public Repair(Mechanic mechanicResponsible, Car carTreated, String area, String note)
    {
        super(mechanicResponsible, carTreated, note);
        _area = area;
    }

    public String getArea()
    {
        return _area;
    }

    public void setArea(String area)
    {
        _area = area;
    }

    @Override
    public String toString() {
        return _note + " (Réparation)";
    }
}
