package People;

public class Mechanic extends GarageStaff {
    String _speciality;

    public Mechanic(String lastName, String FirstName, String address, String phoneNumber, String id, String password, String speciality)
    {
        super(lastName, FirstName, address, phoneNumber, id, password);
        _speciality = speciality;
    }

    @Override
    public String toString() {
        return _firstName + " (" + _speciality + ") ";
    }

}
