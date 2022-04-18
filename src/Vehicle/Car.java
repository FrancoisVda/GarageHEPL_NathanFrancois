package Vehicle;

import People.Customer;

public class Car extends Vehicle {
    CarType _carType;
    Customer _priorityCustomer;

    public Car(CarType carType, Customer priorityCustomer)
    {
        _carType = carType;
        _priorityCustomer = priorityCustomer;
    }
}
