package Business;

import People.Mechanic;
import Vehicle.Car;

public abstract class Work {
    Mechanic _mechanicResponsible ;
    Car _carTreated;

    public Work(Mechanic mechanicResponsible, Car carTreated)
    {
        _mechanicResponsible = mechanicResponsible;
        _carTreated = carTreated;
    }
}
