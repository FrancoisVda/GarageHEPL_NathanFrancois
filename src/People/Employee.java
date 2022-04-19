package People;

public class Employee extends GarageStaff {

    public Employee(String firstName, String phoneNumber, String id, String password)
    {
        super(firstName, phoneNumber, id, password);
    }

    @Override
    public String toString() {
        return _firstName + " (Employé)";
    }
}