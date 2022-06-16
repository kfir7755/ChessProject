public class Main {

    public static void print_possible_moves(int[][] arr){
        if (arr.length == 0){;}
        else {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.println("(" + arr[i][0] + "," + arr[i][1] + ")");
            }
            System.out.print("]");
            System.out.println();
            System.out.println();
        }
    }

    public static void print_board(Board board){
        System.out.println("_________________");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print('|');
                Soldier soldier = board.getBoard()[i][j].getSoldier();
                if (soldier == null) {
                    System.out.print(" ");
                }
                else System.out.print(soldier.getLetter());
            }
            System.out.println('|');
        }
        System.out.print("_________________");
    }

    public static void main(String[] args) {
        Board board= new Board();
        board.gameStart();
        print_board(board);
    }
}

