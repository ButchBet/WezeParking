package model;

import model.Car;
import model.Ticket;
import model.Parking;
import java.util.ArrayList;
import java.util.Random;

public class CreateTicket implements Parking {
    Random random = new Random();
    
    @Override
    public void action(ArrayList<Car> cars, ArrayList<Ticket> tickets, String plate) {
        long number = random.nextInt(1000000) + 1;
        
        Ticket ticket = new Ticket(number);
        
        if (tickets.contains(ticket)) {
            action(cars, tickets, plate);
        } else {
            tickets.add(ticket);
        }
    }
}
