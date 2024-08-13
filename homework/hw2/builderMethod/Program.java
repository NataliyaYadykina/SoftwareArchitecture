package homework.hw2.builderMethod;

public class Program {
    public static void main(String[] args) {
        // настраиваем билдер
        ParameterBuilder ParameterBuilder = new ParameterBuilder();
        ParameterBuilder.setName("BMW");
        ParameterBuilder.setPower(130);
        ParameterBuilder.getResult();

        ParameterBuilder.setWeight(1250);
        ParameterBuilder.getResult();

        ParameterBuilder.setSpeed(270);
        ParameterBuilder.getResult();
    }
}
