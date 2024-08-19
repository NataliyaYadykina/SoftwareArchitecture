package seminars.sem4.task2;

import java.util.ArrayList;

/**
 * Информация о детали
 */
public class ComponentInfo {

    private int id;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ComponentInfo(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("#%d - %s", id, description);
    }

}

/**
 * Завод по производству деталей
 */
class FactoryProvider {

    private ArrayList<ComponentInfo> components = new ArrayList<>();

    {
        for (int i = 0; i < 10; i++) {
            components.add(new ComponentInfo(i + 900000, "Component description " + (i + 900000)));
        }

        for (int i = 0; i < 5; i++) {
            components.add(new ComponentInfo(i + 1000, "Component description " + (i + 1000)));
        }
    }

    /**
     * * Получить информацию о детали по идентификатору
     * 
     * @param id Идентификатор детали
     * @throws RuntimeException Исключение при обработке операции поиска
     * @return Информация о детали
     */
    public ComponentInfo getComponentInfo(int id) throws RuntimeException {

        // Предусловие
        if (id < 0) {
            throw new RuntimeException("Некорректный номер детали.");
        }

        if (String.valueOf(id).length() < 6) {
            throw new RuntimeException("Некорректный номер детали. Деталь существует, но больше не производится.");
        }

        // Выполнение основного кода подпрограммы

        ComponentInfo searchComponent = null;

        for (ComponentInfo componentInfo : components) {
            if (componentInfo.getId() == id) {
                searchComponent = componentInfo;
                break;
            }
        }

        // Постусловие
        // if (searchComponent == null) {
        // throw new RuntimeException("Деталь не найдена.");
        // }

        return searchComponent;
    }

}

/**
 * Дилер
 */
class DealerProvider {

    private final FactoryProvider factoryProvider;

    public DealerProvider(FactoryProvider factoryProvider) {
        this.factoryProvider = factoryProvider;
    }

    /**
     * * Получить информацию о детали по идентификатору
     * 
     * @param id Идентификатор детали
     * @throws RuntimeException Исключение при обработке операции поиска
     * @return Информация о детали
     */
    public ComponentInfo getComponent(int id) throws RuntimeException {

        // Предусловие

        // if (id < 0 || String.valueOf(id).length() < 6) {
        // throw new RuntimeException("Некорректный номер детали.");
        // }

        // Выполнение основного кода подпрограммы

        ComponentInfo componentInfo = factoryProvider.getComponentInfo(id);

        // Постусловие

        if (componentInfo == null) {
            throw new RuntimeException("Деталь не найдена.");
        }

        return componentInfo;

    }

}