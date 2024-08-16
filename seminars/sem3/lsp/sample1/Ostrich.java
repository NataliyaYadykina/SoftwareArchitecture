package seminars.sem3.lsp.sample1;

/**
 * S
 */
public class Ostrich extends Bird {

    public Ostrich() {
        super(false);
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Страус не умеет летать.");
    }

    public void run() {
        System.out.println("Страус бежит!");
    }

}
