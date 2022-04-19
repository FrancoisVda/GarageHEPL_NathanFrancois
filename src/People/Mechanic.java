package People;

public class Mechanic extends GarageStaff {
    String _speciality;

    public Mechanic(String firstName, String phoneNumber, String id, String password)
    {
        super(firstName, phoneNumber, id, password);
        _speciality = "";
    }

    @Override
    public String toString() {
        return _firstName + " (" + _speciality + ") ";
    }

}
