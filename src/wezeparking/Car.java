package wezeparking;

public class Car {
    private String plate;
    
    Car(String plate) {
        this.plate = plate;
    }
    
    Car(){}
    
    public String getPlate() {
        return this.plate;
    }
}
