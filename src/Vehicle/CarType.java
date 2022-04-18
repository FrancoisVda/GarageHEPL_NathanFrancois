package Vehicle;

import java.util.Objects;

public class CarType {
    String _brand;
    String _type;
    int _nbDoor;


    public static void control(String chaine) throws MissingTradeMarkException {
        if (chaine.equals("") == true)
            throw new MissingTradeMarkException("Erreur : Pas de marque encodée");
    }

    public CarType(String brand, String type, int nbDoor)
    {
        try
        {
            control(brand);
        }   catch (MissingTradeMarkException e){    // TODO Test if exception works
        }
        _brand = brand;
        _type = type;
        _nbDoor = nbDoor;
    }

    public String getBrand()
    {
        return _brand;
    }

    public void setBrand(String brand)
    {
        _brand = brand;
    }

    public String getType()
    {
        return _type;
    }

    public void setType(String type)
    {
        _type = type;
    }

    public int getNbDoor()
    {
        return _nbDoor;
    }

    public void setNbDoor(int nbDoor)
    {
        _nbDoor = nbDoor;
    }
}
