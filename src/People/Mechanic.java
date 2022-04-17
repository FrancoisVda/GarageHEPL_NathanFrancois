package People;

/*
 * @author Nathan Et Francois
 */
public class Mechanic extends GarageStaff {
    String _speciality;

    public Mechanic(String phoneNumber, String id)
    {
        super(phoneNumber, id);
        _speciality = "";
    }

    /* // ? TO WRITE IF NEEDS ?
    public String toString()
    {
        return _libelle + " (" + this.getPrix()  + " EUR)";
    }
    */
}
