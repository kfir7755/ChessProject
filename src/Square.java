public class Square {
    private Soldier soldier = null;
    private final int x;
    private final int y;

    public Square (int x, int y,Soldier soldier){
        this.x = x;
        this.y = y;
        this.soldier = soldier;
    }

    public Soldier getSoldier() {
        return soldier;
    }

    public void setSoldier(Soldier soldier) {
        this.soldier = soldier;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
