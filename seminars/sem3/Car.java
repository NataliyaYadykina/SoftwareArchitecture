package seminars.sem3;

import java.awt.*;

public abstract class Car {

    // #region

    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    // #endregion

    // #region Public Abstract Methods

    // Движение
    public abstract void movement();

    // Обслуживание
    public abstract void maintenance();

    // Переключение передач
    public abstract boolean gearShifting();

    // Включение фар
    public abstract boolean switchHeadLights();

    // Включение дворников
    public abstract boolean switchWipers();

    // #endregion

    // #region Public Methods

    public boolean switchForLights() {
        fogLights = !fogLights;
        return fogLights;
    }

    protected void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    // #endregion

    // #region Private Fields

    // Марка автомобиля
    private String make;

    // Модель автомобиля
    private String model;

    // Цвет
    private Color color;

    // Тип
    private CarType type;

    // Число колес
    private int wheelsCount;

    // Тип топлива
    protected FuelType fuelType;

    // Тип коробки передач
    private GearboxType gearboxType;

    // Объем двигателя
    private double engineCapacity;

    // Состояние противотуманных фар
    private boolean fogLights;

    // #endregion

}
