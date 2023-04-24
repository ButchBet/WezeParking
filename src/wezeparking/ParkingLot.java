package wezeparking;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ParkingLot {
    private Car carsIn[] = new Car[2];
    
    private int carCount = 0;
    
    private ArrayList<Car> carsOut = new ArrayList<Car>();
    
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    
    Random random = new Random();
    
    Scanner cmd = new Scanner(System.in);
    
    ParkingLot(){}
    
     public void main () {
        char op;
        
        do {      
            System.out.println("");
            
            // Show possible options
            System.out.println("What do you want to do?.");
            
            System.out.println("1: Add car in the parking lot.");
            
            System.out.println("2. Remove car from the parking lot.");
            
            System.out.println("3. Create cinema ticket");
            
            System.out.println("4. Show number of tickes and cars out of the parking lot.");
            
            System.out.println("Other. Exit.");
            
            String proveOp = cmd.nextLine();
            
            if(proveOp.length() == 1) {
                op = proveOp.charAt(0);
            } else {
                op = 'e';                
            }
            
            // Validate user option
            switch(op) {
                case '1':
                    // Check that the parking lot is not full
                    if (carCount == carsIn.length) {
                        System.out.println("Parking lot full.");
        
                    }else {
                        String plate = requestPlate(false);
                   
                        addCarIn(plate);
                    } 
                    break;
                case '2':
                    // checking if the parking lot has cars
                    if(carCount == 0) {
                        System.out.println("Parking lot empty.");
                    } else {
                        String plate = requestPlate(true);
                        
                        if(plateExists(plate)) {                                             
                            removeCarIn(plate);
                        } else {
                            System.out.println("The car with plate " + plate + " was not found in the system.");
                        }
                        
                    }
                    break;
                case '3':
                    createTicket();
                    
                    System.out.println("Ticket " + tickets.get(tickets.size() - 1).getNumber() + " created successfully");
                    break;
                case '4': 
                    System.out.println("The quantity of tickets is: " + tickets.size());
                    
                    System.out.println("The quantity of cars out is: " + carsOut.size());
                    break;
                default:
                    System.out.println("Getting back...");
            }
            
        } while(op == '1' || op == '2' || op == '3' || op == '4');
    }
     
    private String requestPlate(boolean removing) { 
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
                plateExists = plateExists(plate);
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
	
    private boolean plateExists(String plate) {
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
    
    private void addCarIn(String plate) {
        Car car = new Car(plate);
        
        carsIn[carCount] = car;
            
        carCount++;
            
        System.out.println("The car with plate " + car.getPlate() + " has been successfully added.");
    }
    
    private void removeCarIn(String plate) {
        for (int i = 0; i < carsIn.length; i++) {
            if (carsIn[i] != null) { // If the position has a car
                if (carsIn[i].getPlate().equals(plate)) {          
                    for (int j = i; j < carsIn.length - 1; j++) {
                        carsIn[j] = carsIn[j + 1];
                    }
                
                carsIn[carsIn.length - 1] = null;
                
                carCount--; 
                
                    System.out.println("Car with plate " + plate + " successfully removed.");
                
                break;
                }
            }
        }
        
        addCarOut(plate);
    }
    
    private void addCarOut(String plate) {
        Car car = new Car(plate);
        
        carsOut.add(car);
    }
    
    private void createTicket() {
        long number = random.nextInt(1000000) + 1;
        
        Ticket ticket = new Ticket(number);
        
        if (tickets.contains(ticket)) {
            createTicket();
        } else {
            tickets.add(ticket);
        }
    }
}
