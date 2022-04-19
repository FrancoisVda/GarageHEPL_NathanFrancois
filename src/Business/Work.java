package Business;

import People.Mechanic;
import Vehicle.Car;

public abstract class Work {
    Mechanic _mechanicResponsible ;
    Car _carTreated;
    String _note;

    public Work(Mechanic mechanicResponsible, Car carTreated, String note)
    {
        _mechanicResponsible = mechanicResponsible;
        _carTreated = carTreated;
        _note = note;
    }

}
