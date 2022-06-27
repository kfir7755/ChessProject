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
        Square square = new Square(1, 0, null);
        board.setSquareInBoard(square);
        board.move(0,0, 6, 0, board);
        board.print_board();
        board.move(7,0, 6, 0, board);
        board.print_board();
    }
}
