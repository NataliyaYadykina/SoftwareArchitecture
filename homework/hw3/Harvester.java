package homework.hw3;

import java.awt.*;

public class Harvester extends Car implements Fueling, Wiping {

    private Refueling refueling;

    private IWiping iWiping;

    public Harvester(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(6);
    }

    public void setRefueling(Refueling refueling) {
        this.refueling = refueling;
    }

    public void setIWiping(IWiping iWiping) {
        this.iWiping = iWiping;
    }

    @Override
    public boolean gearShifting() {
        return false;

    }

    @Override
    public void maintenance() {

    }

    @Override
    public void movement() {

    }

    @Override
    public boolean switchHeadLights() {
        return false;

    }

    @Override
    public boolean switchWipers() {
        return false;
    }

    public void swepping() {
        System.out.println("Автомобиль метет улицу.");
    }

    /**
     * Заправить автомобиль
     */
    @Override
    public void fuel(FuelType fuelType) {
        if (refueling != null) {
            refueling.fuel(fuelType);
        }
    }

    @Override
    public void wipMirrors() {
        if (iWiping != null) {
            iWiping.wipMirrors();
        }
    }

    @Override
    public void wipWindshield() {
        if (iWiping != null) {
            iWiping.wipWindshield();
        }
    }

    @Override
    public void wipHeadLights() {
        if (iWiping != null) {
            iWiping.wipHeadlights();
        }
    }

}
