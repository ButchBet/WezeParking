package wezeparking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class VectorsManipulation {
    private  ArrayList<Integer> numbers = new ArrayList<Integer>();
    
    Scanner cmd = new Scanner(System.in);
    
    VectorsManipulation(){}
    
    public void main(boolean choose) {
        numbers.removeAll(numbers); // Assuring that we are not using previus array.
        
        char op;
        
        String number;
        
        String proveOp;
        
        do {
            System.out.println("");
            
            System.out.println("Do you want to enter a value?.");
        
            System.out.println("1. Yes.");
            
            System.out.println("2. No.");
            
            System.out.println("Other. Go to main menu.");
            
            proveOp = cmd.nextLine();
            
            if(proveOp.length() == 1) {
                op = proveOp.charAt(0);
            } else {
                op = 'e';                
            }
            
            if(op == '1') {
                System.out.println("Pelase enter one number: ");
                
                number = cmd.nextLine();
                
                if(isNumber(number)) {
                    numbers.add(Integer.parseInt(number));
                } else {
                    System.out.println("This is not a number.");
                }
            } else if(op == '2') {
                if(numbers.isEmpty()) {
                    System.out.println("We are unable to continue, the ArrayList is empty.");
                } else if(choose) {
                    indexEvenOddAddition();
                } else {
                    countRepeatsOfNumbers();
                }
            }
        }while(op == '1' || op == '2');
    }
    
    private boolean isNumber(String number) {	
        try {
            Integer.parseInt(number);
		
            return true;
        } catch (NumberFormatException e) {		
            return false;	
        }
	
    }
    
    private void indexEvenOddAddition() {
        int even = 0, odd = 0;
        
        for(int i = 0; i < numbers.size(); i++) {
            if((i + 1) % 2 == 0) {
                even += numbers.get(i);
            } else {
                odd += numbers.get(i);
            }
        }
        
        System.out.println("Even: " + even + ".\nOdd: " + odd + ".");
    }
    
    private void countRepeatsOfNumbers() {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < numbers.size(); i++) {
            int key = numbers.get(i);
        
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                 map.put(key, 1);
            }
        }
  
        for (int key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
