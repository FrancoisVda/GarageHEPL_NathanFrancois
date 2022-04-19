package Vehicle;

import People.Customer;

public class Car extends Vehicle {
    String _registration;
    Boolean _belgianRegistration;
    CarType _carType;
    Customer _priorityCustomer;

    public Car(String registration, Boolean belgianRegistration, CarType carType, Customer priorityCustomer)
    {
        _registration = registration;
        _belgianRegistration = belgianRegistration;
        _carType = carType;
        _priorityCustomer = priorityCustomer;
    }

    public String getRegistration()
    {
        return _registration;
    }

    public void setRegistration(String registration)
    {
        _registration = registration;
    }

}
