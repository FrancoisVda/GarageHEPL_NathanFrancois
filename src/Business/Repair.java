package Business;

import People.Mechanic;
import Vehicle.Car;

public class Repair extends Work{
    String _area;

    public Repair(Mechanic mechanicResponsible, Car carTreated, String area)
    {
        super(mechanicResponsible, carTreated);
    }
}
