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
        Square square1 = new Square(4,4, null);
        Square square2 = new Square(5,3, null);
        Square square3 = new Square(5,5, null);
        Soldier soldier1 = new Pawn(square1, "b", false);
        Soldier soldier2 = new Queen(square2, "w");
        Soldier soldier3 = new Knight(square3, "w");
        board.setSquareInBoard(square1);
        board.setSquareInBoard(square2);
        board.setSquareInBoard(square3);
        board.print_board();
        print_possible_moves(board.possible_moves(board.getSquare(0,1)), board);
    }
}
