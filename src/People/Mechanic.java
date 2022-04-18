package People;

public class Mechanic extends GarageStaff {
    String _speciality;

    public Mechanic(String firstName, String phoneNumber, String id, String password)
    {
        super(firstName, phoneNumber, id, password);
        _speciality = "";
    }

    /* // ? TO WRITE IF NEEDS ?
    public String toString()
    {
        return _libelle + " (" + this.getPrix()  + " EUR)";
    }
    */
}
