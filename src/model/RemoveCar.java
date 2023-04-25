package model;

import java.util.ArrayList;

public class RemoveCar implements Parking{
    @Override
    public void action(ArrayList<Car> cars, ArrayList<Ticket> tickets, String plate) {
        for (int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getPlate().equals(plate)) {
                cars.remove(i);
                
                break;
            }
        }
        
        System.out.println("Car with plate " + plate + " successfully removed.");
    }
}
