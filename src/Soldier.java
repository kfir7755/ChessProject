public abstract class Soldier {
    protected Square square;
    protected String color;
    protected char letter;

    public Soldier(Square square, String color, char letter) {
        this.square = square;
        this.square.setSoldier(this);
        this.color = color;
        this.letter= letter;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public String getColor() {
        return color;
    }

    public char getLetter() {
        return letter;
    }

    public abstract int[][] possible_moves (Board board);
}
