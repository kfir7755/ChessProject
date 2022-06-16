public abstract class Soldier {
    protected int x;
    protected int y;
    protected String color;
    protected char letter;

    public Soldier(int x, int y, String color, char letter) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.letter= letter;
    }

    public Soldier() {
        this.x=-1;
        this.y=-1;
        this.color=null;
        this.letter=' ';
    }


        public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    public char getLetter() {
        return letter;
    }

    public abstract int[][] possible_moves ();
}
