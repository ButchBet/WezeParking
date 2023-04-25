package model;

import model.Car;
import model.Ticket;
import model.Parking;
import model.RemoveCar;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Context {    
    Parking parkingAction = null;
    public void operation(char op, ArrayList<Car> carsIn, ArrayList<Car> carsOut, ArrayList<Ticket>tickets) {
         // Validate user option
            switch(op) {
                case '1':
                    // Check that the parking lot is not full
                    if (10 == carsIn.size()) {
                        System.out.println("Parking lot full.");
        
                    }else {
                        String plate = requestPlate(carsIn, false);
                        
                        parkingAction = new AddCar();
                   
                        parkingAction.action(carsIn, null, plate);
                    } 
                    break;
                case '2':
                    // checking if the parking lot has cars
                    if(carsIn.size() == 0) {
                        System.out.println("Parking lot empty.");
                    } else {
                        String plate = requestPlate(carsIn, true);
                        
                        if(plateExists(carsIn, plate)) {
                            parkingAction = new RemoveCar();
                            parkingAction.action(carsIn, null, plate);
                            
                            parkingAction = new AddCar();
                            parkingAction.action(carsOut, null, plate);
                        } else {
                            System.out.println("The car with plate " + plate + " was not found in the system.");
                        }
                        
                    }
                    break;
                case '3':
                    parkingAction = new CreateTicket();
                    
                    parkingAction.action(null, tickets, null);
                    
                    System.out.println("Ticket " + tickets.get(tickets.size() - 1).getNumber() + " created successfully");
                    break;
                case '4': 
                    System.out.println("The quantity of tickets is: " + tickets.size());
                    
                    System.out.println("The quantity of cars out is: " + carsOut.size());
                    break;
                default:
                    System.out.println("Exiting...");
            }        
    }
    
    private String requestPlate(ArrayList<Car> carsIn, boolean removing) { 
        Scanner sc = new Scanner(System.in);
                
        // Booleans used to check that the input is the right
        boolean plateExists = false;
                
        boolean isNumber = false;
		
        boolean isThreeDigits = false;
		
        String plate = "";
               
        // Getting input and checking every condition
        do {
            System.out.println("");
        
            System.out.println("Please enter the plate of the car.");
        
            plate = sc.nextLine();
        
            isNumber = isNumber(plate);
        
            isThreeDigits = isThreeDigits(plate);
            
            // This will help us to avoind repeating the reading of the input in case that we want to remove the car
            if(removing) {
                plateExists = false;
            } else {
                plateExists = plateExists(carsIn, plate);
            }	
        } while (!isNumber || !isThreeDigits || plateExists);
        
        return plate;
     }
	
    private boolean isNumber(String plate) {	
        try {
            Integer.parseInt(plate);
		
            return true;
        } catch (NumberFormatException e) {		
            return false;	
        }
	
    }
	
    private boolean isThreeDigits(String plate) {
        return plate.length() == 3;	
    }
	
    private boolean plateExists(ArrayList<Car> carsIn,String plate) {
        for (Car carsIn1 : carsIn) {
            if (carsIn1 != null) {
                // If the position has a car
                if (carsIn1.getPlate().equals(plate)) {
                    return true;
                }
            }
        }	
        
        return false;	
    }
}
