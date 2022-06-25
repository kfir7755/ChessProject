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
        Square square2 = new Square(3,0, null);
        Soldier soldier2 = new Queen(square2, "w");
        board.setSquareInBoard(square2);
        board.move(1,0,3,0, board);
        board.print_board();

    }
}
