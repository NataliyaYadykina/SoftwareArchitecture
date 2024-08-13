package homework.hw2.builderMethod;

public class ParameterBuilder {
    private String name;
    private double power;
    private double weight;
    private double speed;

    public void setName(String name) {
        this.name = name;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Parameter getResult() {
        return new Parameter(name, power, weight, speed);
    }
}
