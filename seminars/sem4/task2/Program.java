package seminars.sem4.task2;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        FactoryProvider factoryProvider = new FactoryProvider();
        DealerProvider dealerProvider = new DealerProvider(factoryProvider);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Укажите номер детали: #");
            int id = Integer.parseInt(scanner.nextLine());
            if (id < 0) {
                System.out.println("Укажите корректный номер детали. Номер детали должен быть больше 0.");
                continue;
            }
            try {
                ComponentInfo componentInfo = dealerProvider.getComponent(id);
                System.out.println(componentInfo);
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }

        scanner.close();

    }
}
