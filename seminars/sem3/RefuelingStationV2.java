package seminars.sem3;

public class RefuelingStationV2 implements Refueling {

    @Override
    public void fuel(FuelType fuelType) {

        switch (fuelType) {
            case Diesel -> System.out.println("Запрвка дизельным топливом.\n");
            case GaseLine -> System.out.println("Заправка бензином.\n");
        }

    }
    
}
