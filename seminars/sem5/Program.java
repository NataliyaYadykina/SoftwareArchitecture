package seminars.sem5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

/**
 * Необходимо разделить на горизонтальные уровни "Редактор 3D графики.
 * Один пользователь. Программа работает на одном компьютере без выхода в сеть.
 * 
 * Что видит пользователь, как взаимодействует? (Панель загрузки, блок
 * редактирования, блок просмотра).
 * Какие задачи можно делать - функции системы? (Загрузить 3D-модель,
 * рассмотреть 3D модель, создать новую, редактировать вершины, текстуры,
 * сделать рендер, сохранить рендер).
 * Какие и где хранятся данные? (файлы 3D моделей, рендеры, анимация..., в
 * файловой системе компьютера).
 * 
 * Предложить варианты связывания всех уровней - сценарии использования, 3-4
 * сценария.
 * Сквозная функция - создать новую 3D модель, сделать рендер для печати на
 * принтере."
 */
class Program {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Запуск приложения
        Editor3D editor3D = new Editor3D();

        boolean f = true;

        while (f) {
            System.out.println("*** МОЙ 3D РЕДАКТОР ***");
            System.out.println("=======================");
            System.out.println("1. Открыть проект");
            System.out.println("2. Сохранить проект");
            System.out.println("3. Отобразить параметры проекта");
            System.out.println("4. Отобразить все модели проекта");
            System.out.println("5. Отобразить все текстуры проекта");
            System.out.println("6. Выполнить рендер всех моделей");
            System.out.println("7. Выполнить рендер модели");
            System.out.println("8. Добавить новую модель");
            System.out.println("9. Добавить текстуру к модели");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
            System.out.print("Пожалуйста, выберите пункт меню: ");

            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Завершение работы приложения");
                            f = false;
                            break;
                        case 1:
                            System.out.print("Укажите наименование файла проекта: ");
                            String fileName = scanner.nextLine();
                            editor3D.openProject(fileName);
                            System.out.println("Проект успешно открыт.");
                            break;
                        case 2:
                            editor3D.saveProject();
                            break;
                        case 3:
                            editor3D.showProjectSettings();
                            break;
                        case 4:
                            editor3D.printAllModels();
                            break;
                        case 5:
                            editor3D.printAllTextures();
                            break;
                        case 6:
                            editor3D.renderAll();
                            break;
                        case 7:
                            System.out.print("Укажите номер модели: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.renderModel(modelNo);
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;
                        case 8:
                            editor3D.addModel();
                            break;
                        case 9:
                            System.out.print("Укажите номер модели: ");
                            if (scanner.hasNextInt()) {
                                int modelId = scanner.nextInt();
                                scanner.nextLine();
                                editor3D.addTextureToModel(modelId);
                            } else {
                                System.out.println("Номер модели указан некорректно.");
                            }
                            break;
                        default:
                            System.out.println("Неверный пункт меню.");

                    }
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.nextLine(); // Очистка ввода
            }

        }

    }

}

class Editor3D implements UILayer {

    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;
    private DatabaseAccess databaseAccess;
    private Database database;

    public void initialize() {

        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);

    }

    @Override
    public void openProject(String fileName) {
        projectFile = new ProjectFile(fileName);
        initialize();
    }

    @Override
    public void showProjectSettings() {

        // Предусловие
        checkProjectFile();

        System.out.println("**** Project v1 **");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", projectFile.getFileName());
        System.out.printf("setting1: %d\n", projectFile.getSetting1());
        System.out.printf("setting2: %s\n", projectFile.getSetting2());
        System.out.printf("setting3: %s\n", projectFile.getSetting3());
        System.out.println("******************");

    }

    private void checkProjectFile() {
        if (projectFile == null) {
            throw new RuntimeException("Файл проекта не определен.");
        }
    }

    @Override
    public void saveProject() {

        // Предусловие
        checkProjectFile();

        database.save();
        System.out.println("Изменения успешно изменены.");

    }

    @Override
    public void printAllModels() {

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        System.out.println("**** Models **");
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(models.get(i));
            for (Texture texture : models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }

    }

    @Override
    public void printAllTextures() {

        // Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>) businessLogicalLayer.getAllTextures();
        System.out.println("**** Textures **");
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("===%d===\n", i);
            System.out.println(textures.get(i));
        }

    }

    @Override
    public void renderAll() {

        // Предусловие
        checkProjectFile();

        System.out.println("Подождите...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModel();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Рендер завершен за %d миллисекунд.\n", endTime);

    }

    @Override
    public void renderModel(int i) {

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1) {
            throw new RuntimeException("Индекс модели выходит за границы.");
        }
        System.out.println("Подождите...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Рендер модели %d завершен за %d миллисекунд.\n", i, endTime);

    }

    @Override
    public void addModel() {
        // Предусловие
        checkProjectFile();

        // Создание новой модели
        Model3D newModel = new Model3D();

        // Добавление модели в бизнес-логику
        businessLogicalLayer.addModel(newModel);

        // Добавление текстуры к новой модели
        addTextureToModel(newModel.getId());

        System.out.println("Новая модель успешно добавлена.");
    }

    @Override
    public void addTextureToModel(int modelId) {
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>) businessLogicalLayer.getAllModels();
        if (modelId < 10000 || modelId > (10000 + models.size() - 1)) {
            throw new RuntimeException("Индекс модели выходит за границы.");
        }

        Texture newTexture = new Texture();
        models.get(modelId - 10000).getTextures().add(newTexture);
        System.out.println("Новая текстура успешно добавлена к модели.");
    }

}

/**
 * Интерфейс UI
 */
interface UILayer {

    void openProject(String fileName);

    void showProjectSettings();

    void saveProject();

    void printAllModels();

    void printAllTextures();

    void renderAll();

    void renderModel(int i);

    void addModel();

    void addTextureToModel(int modelId);

}

/**
 * Реализация Business Logical Layer
 */
class EditorBusinessLogicalLayer implements BusinessLogicalLayer {

    private DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModel() {
        for (Model3D model : getAllModels()) {
            processRender(model);
        }
    }

    private Random random = new Random();

    private void processRender(Model3D model) {
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addModel(Model3D model) {
        databaseAccess.addEntity(model);
    }

    public void addTextureToModel(Model3D model, Texture texture) {
        model.getTextures().add(texture);
        databaseAccess.addEntity(texture);
    }

}

/**
 * Интерфейс BLL (Business Logical Layer)
 */
interface BusinessLogicalLayer {

    Collection<Model3D> getAllModels();

    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);

    void renderAllModel();

    void addModel(Model3D model);

}

/**
 * Реализация DAC
 */
class EditorDatabaseAccess implements DatabaseAccess {

    private final Database editorDatabase;

    public EditorDatabaseAccess(Database editorDatabase) {
        this.editorDatabase = editorDatabase;
    }

    @Override
    public void addEntity(Entity entity) {
        editorDatabase.getAll().add(entity);
    }

    @Override
    public void removeEntity(Entity entity) {
        editorDatabase.getAll().remove(entity);
    }

    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> textures = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Texture) {
                textures.add((Texture) entity);
            }
        }
        return textures;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entity entity : editorDatabase.getAll()) {
            if (entity instanceof Model3D) {
                models.add((Model3D) entity);
            }
        }
        return models;
    }

    public void addModel(Model3D model) {
        addEntity(model);
    }

    public void addTextureToModel(Model3D model, Texture texture) {
        model.getTextures().add(texture);
        addEntity(texture);
    }

}

/**
 * Интерфейс DAC
 */
interface DatabaseAccess {

    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    Collection<Texture> getAllTextures();

    Collection<Model3D> getAllModels();

}

/**
 * Database
 */
class EditorDatabase implements Database {

    private Random random = new Random();
    private final ProjectFile projectFile;
    private Collection<Entity> entities;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {
        // TODO Загрузка всех сущностей проекта (модели, текстуры и т.д.)
    }

    @Override
    public void save() {
        // TODO Сохранение текущего состояния всех сущностей проекта
    }

    // @Override
    public Collection<Entity> getAll() {
        if (entities == null) {
            entities = new ArrayList<>();
            int entCount = random.nextInt(5, 11);
            for (int i = 0; i < entCount; i++) {
                generateModelsAndTextures();
            }
        }
        return entities;
    }

    private void generateModelsAndTextures() {
        Model3D model3d = new Model3D();
        int txCount = random.nextInt(3);
        for (int i = 0; i < txCount; i++) {
            Texture texture = new Texture();
            model3d.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model3d);
    }

}

/**
 * Database interface
 */
interface Database {

    void load();

    void save();

    Collection<Entity> getAll();

}

/**
 * Model3D
 */
class Model3D implements Entity {

    private static int counter = 10000;

    private int id;

    private Collection<Texture> textures = new ArrayList<>();

    @Override
    public int getId() {
        return id;
    }

    {
        id = counter++;
    }

    public Model3D() {

    }

    public Model3D(Collection<Texture> textures) {
        this.textures = textures;
    }

    public Collection<Texture> getTextures() {
        return textures;
    }

    @Override
    public String toString() {
        return String.format("3DModel #%s", id);
    }

}

/**
 * Texture
 */
class Texture implements Entity {

    private static int counter = 50000;

    private int id;

    {
        id = counter++;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Texture #%s", id);
    }

}

/**
 * Entity / Сущность
 */
interface Entity {

    int getId();

}

/**
 * ProjectFile
 */
class ProjectFile {

    private String fileName;
    private int setting1;
    private String setting2;
    private boolean setting3;

    public ProjectFile(String fileName) {
        this.fileName = fileName;

        // TODO: Загрузка настроек проекта из файла

        setting1 = 1;
        setting2 = "default";
        setting3 = false;
    }

    public String getFileName() {
        return fileName;
    }

    public int getSetting1() {
        return setting1;
    }

    public String getSetting2() {
        return setting2;
    }

    public boolean getSetting3() {
        return setting3;
    }

}
