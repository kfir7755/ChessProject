public abstract class Soldier {
    protected int x;
    protected int y;
    protected String color;

    public Soldier(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract int[][] possible_moves ();
}
