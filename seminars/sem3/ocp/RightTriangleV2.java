package seminars.sem3.ocp;

public class RightTriangleV2 implements ShapeV2 {

    private int katet1;
    private int katet2;
    private double hypotenuse;

    public int getKatet1() {
        return katet1;
    }

    public int getKatet2() {
        return katet2;
    }

    public double getHypotenuse() {
        return hypotenuse;
    }

    public RightTriangleV2(int katet1, int katet2) {
        this.katet1 = katet1;
        this.katet2 = katet2;
        hypotenuse = Math.sqrt(Math.pow(katet1, 2) + Math.pow(katet2, 2));
    }

    @Override
    public double getArea() {
        return 0.5 * katet1 * katet2;
    }

}
