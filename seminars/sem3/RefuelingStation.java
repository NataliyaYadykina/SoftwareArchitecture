package seminars.sem3;

public class RefuelingStation implements Refueling {

    @Override
    public void fuel(FuelType fuelType) {

        switch (fuelType) {
            case Diesel -> System.out.println("Заправка дизельным топливом.\n");
            case GaseLine -> System.out.println("Заправка бензином.\n");
        }

    }

}
