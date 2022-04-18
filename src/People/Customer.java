package People;

public class Customer extends Person{
    int _idClient;

    public Customer(String firstName, String phoneNumber, int idClient)
    {
        super(firstName, phoneNumber);
        _idClient = idClient;
    }

    public int getIdClient()
    {
        return _idClient;
    }

    public void setIdClient(int idClient)
    {
        _idClient = idClient;
    }

}