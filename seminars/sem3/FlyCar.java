package seminars.sem3;

import java.awt.Color;

public class FlyCar extends Car {

    public FlyCar(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(4);
    }

    public void fly() {
        System.out.println("FlyCar is flying");
    }

    @Override
    public void movement() {
        fly();
    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadLights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }

}
