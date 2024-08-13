package homework.hw2.builderMethod;

public class Parameter {
    private String name;
    private double power;
    private double weight;
    private double speed;

    public Parameter(String name, double power, double weight, double speed) {
        this.name = name;
        this.power = power;
        this.weight = weight;
        this.speed = speed;

        System.out.println(this.toString());
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public double getWeight() {
        return weight;
    }

    public Double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "parameter{" +
                "name='" + name + '\'' +
                ", power='" + power + '\'' +
                ", weight='" + weight + '\'' +
                ", speed=" + speed + '\'' +
                '}';
    }
}
