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

    public static void print_board(Board board){
        System.out.println("_________________________");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print('|');
                Soldier soldier = board.getBoard()[i][j].getSoldier();
                if (soldier == null) {
                    System.out.print("  ");
                }
                else if (i==0 || i==1) {
                    System.out.print("w" + soldier.getLetter());
                }
                else if (i==7 || i==6){
                    System.out.print("b" + soldier.getLetter());
                }
            }
            System.out.println('|');
        }
        System.out.print("__________________________");
    }

    public static void main(String[] args) {
        Board board= new Board();
        board.gameStart();
        print_board(board);
    }
}

