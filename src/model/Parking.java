package model;

import java.util.ArrayList;

public interface Parking {
    public void action(ArrayList<Car> cars, ArrayList<Ticket> tickets, String plate);
}
