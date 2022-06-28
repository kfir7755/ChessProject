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
        board.setSquareInBoard(new Square(5,4,null));
        Soldier soldier= new Knight(board.getSquare(5,4), "b");
        board.move(5,4, 7,3);
        board.print_board();
    }
}
