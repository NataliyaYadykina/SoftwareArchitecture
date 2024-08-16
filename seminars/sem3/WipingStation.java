package seminars.sem3;

public class WipingStation implements IWiping {

    @Override
    public void wipMirrors() {
        System.out.println("Очистка зеркал.\n");
    }

    @Override
    public void wipWindshield() {
        System.out.println("Очистка стекол.\n");
    }

    @Override
    public void wipHeadlights() {
        System.out.println("Очистка фар.\n");
    }

}
