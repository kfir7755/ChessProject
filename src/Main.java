public class Main {

    public static void print_possible_moves(int[][] arr){
        if (arr.length != 0){
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.println("(" + arr[i][0] + "," + arr[i][1] + ")");
            }
            System.out.print("]");
            System.out.println();
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Board board= new Board();
        board.gameStart();
        Soldier soldier1 = new Pawn(4,4, "white", false);
        Soldier soldier2 = new Queen(5,3, "black");
        Soldier soldier3 = new Knight(5,5, "black");
        Square square1 = new Square(soldier1);
        Square square2 = new Square(soldier2);
        Square square3 = new Square(soldier3);
        board.setSquareInBoard(square1, 4, 4);
        board.setSquareInBoard(square2, 5, 3);
        board.setSquareInBoard(square3, 5, 5);
        board.possible_moves(square1);
    }
}
