package model;

import java.util.ArrayList;
import java.util.Scanner;

public class ParkingLot {
    private ArrayList<Car> carsIn = new ArrayList<Car>();
    
    private ArrayList<Car> carsOut = new ArrayList<Car>();
    
    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    
    Scanner cmd = new Scanner(System.in);
    
    public ParkingLot(){}
    
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

            Context parkinglot = new Context();
            
            parkinglot.operation(op, carsIn, carsOut, tickets);
        } while(op == '1' || op == '2' || op == '3' || op == '4');
    }

}
