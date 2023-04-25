package model;

import model.Car;
import model.Ticket;
import model.Parking;
import java.util.ArrayList;

public class AddCar implements Parking{
    @Override
    public void action(ArrayList<Car> cars, ArrayList<Ticket> tickets, String plate) {
        Car car = new Car(plate);
        
        cars.add(car);
            
        System.out.println("The car with plate " + car.getPlate() + " has been successfully added.");
    }
}
