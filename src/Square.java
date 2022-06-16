public class Square {
    private Soldier soldier = null;
    private int x;
    private int y;

    public Square (Soldier soldier){
        this.x = soldier.getX();
        this.y = soldier.getY();
        this.soldier = soldier;
    }

    public Square(int x, int y, Soldier soldier) {
        this.x = x;
        this.y = y;
        this.soldier=soldier;
    }

    public Soldier getSoldier() {
        return soldier;
    }
}
