package Vehicle;

import People.Customer;

public class Car extends Vehicle {
    String _id;
    CarType _carType;
    Customer _priorityCustomer;

    public Car(String id, CarType carType, Customer priorityCustomer)
    {
        _id = id;
        _carType = carType;
        _priorityCustomer = priorityCustomer;
    }

    public String getId()
    {
        return _id;
    }

    public void setId(String id)
    {
        _id = id;
    }

}
