package People;

public class Employee extends GarageStaff {

    public Employee(String lastName, String FirstName, String address, String phoneNumber, String id, String password, String speciality)
    {
        super(lastName, FirstName, address, phoneNumber, id, password);
    }

    @Override
    public String toString() {
        return _firstName + " (Employé)";
    }
}