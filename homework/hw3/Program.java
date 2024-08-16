package homework.hw3;

import java.awt.*;

/**
 * 1. Спроектировать абстрактный класс «Car» у которого должны быть свойства:
 * марка, модель, цвет, тип кузова, число колёс, тип топлива, тип коробки
 * передач, объём двигателя; методы: движение, обслуживание, переключение
 * передач, включение фар, включение дворников.
 * 
 * 2. Создать конкретный автомобиль путём наследования класса «Car».
 * 
 * 3. Расширить абстрактный класс «Car», добавить метод: подметать улицу.
 * 4. Создать конкретный автомобиль путём наследования класса «Car». Провести
 * проверку принципа SRP.
 * 
 * 5. Создать конкретный автомобиль путём наследования класса «Car», определить
 * число
 * колёс = 3. Провести проверку принципа LSP.
 * 
 * 6. Создать конкретный автомобиль путём наследования класса «Car», определить
 * метод
 * «движение» - «полёт». Провести проверку принципа LSP.
 * 
 * 7. Создать интерфейс «Заправочная станция», создать метод: заправка топливом.
 * 
 * 8. Имплементировать метод интерфейса «Заправочная станция» в конкретный класс
 * «Car».
 * 
 * 9. Добавить в интерфейс «Заправочная станция» методы: протирка лобового
 * стекла,
 * протирка фар, протирка зеркал.
 * 
 * 10. Имплементировать все методы интерфейса «Заправочная станция» в конкретный
 * класс
 * «Car». Провести проверку принципа ISP. Создать дополнительный/е интерфейсы и
 * имплементировать их в конкретный класс «Car». Провести проверку принципа ISP.
 * 
 * 11. Создать путём наследования класса «Car» два автомобиля: с бензиновым и
 * дизельным
 * двигателями, имплементировать метод «Заправка топливом» интерфейса
 * «Заправочная
 * станция». Реализовать заправку каждого автомобиля подходящим топливом.
 * Провести
 * проверку принципа DIP.
 * 
 */
public class Program {

    public static void main(String[] args) {
        // Запуск приложения
        Harvester harvester = new Harvester("A", "B", Color.BLACK);

        Refueling refuelingStation = new RefuelingStation();

        harvester.setRefueling(refuelingStation);

        harvester.fuel(FuelType.Diesel);

        WipingStation wipingStation = new WipingStation();

        harvester.setIWiping(wipingStation);

        harvester.wipMirrors();
        harvester.wipWindshield();
        harvester.wipHeadLights();
    }

    public static double calculateMaintenance(Car car) {
        if (car.getWheelsCount() == 6) {
            return 1500 * 6;
        } else {
            return 1200 * 4;
        }
    }

}
