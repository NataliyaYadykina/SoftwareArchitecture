package seminars.sem3.lsp.sample1;

/**
 * T
 */
public class Bird {

    private boolean canFly = true;

    public Bird(boolean canFly) {
        this.canFly = canFly;
    }

    public Bird() {
    }

    public void fly() {
        System.out.println("Bird flies");
    }

    public boolean isCanFly() {
        return canFly;
    }

}
