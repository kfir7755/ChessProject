public class Rook extends Soldier{


    public Rook(Square square, String color) {
        super(square ,color, 'R');
    }

    @Override
    public int[][] possible_moves(){
        int counter = 0;
        int newX = this.square.getX() -1;
        int newY = this.square.getY() -1;
        int[][] board = new int[8][8];
        Board board1 = new Board();
        board1.getBoard();
        while (newX >= 0) {
            if (board1.getBoard()[newX][this.square.getY()].getSoldier() == null) {
                board[newX][this.square.getY()] = 1;
                counter++;
                newY++;
            } else if (!color.equals(board1.getBoard()[newX][square.getY()])) {
                board[newX][this.square.getY()] = 1;
                counter++;
                break;
            } else {
                break;
            }
        }
        newX = this.square.getX() + 1;
        while (newX < 8) {
            if (board1.getBoard()[square.getX()][newY].getSoldier() == null) {
                board[this.square.getX()][newY] = 1;
                counter++;
                newY++;
            } else if (!color.equals(board1.getBoard()[newX][square.getY()])) {
                board[this.square.getX()][newY] = 1;
                counter++;
                break;
            } else {
                break;
            }
        }
        newY = this.square.getY() + 1;
        while (newY < 8) {
            if (board1.getBoard()[square.getX()][newY].getSoldier() == null) {
                board[this.square.getX()][newY] = 1;
                counter++;
                newY++;
            } else if (!color.equals(board1.getBoard()[newX][square.getY()])) {
                board[this.square.getX()][newY] = 1;
                counter++;
                break;
            } else {
                break;
            }
        }
        newY = this.square.getY() - 1;
        while (newY >= 0) {
            if (board1.getBoard()[square.getX()][newY].getSoldier() == null) {
                board[this.square.getX()][newY] = 1;
                counter++;
                newY--;
            } else if (!color.equals(board1.getBoard()[newX][square.getY()])) {
                board[this.square.getX()][newY] = 1;
                counter++;
                break;
            } else {
                break;
            }
        }
        int[][] possible_moves = new int[counter][2];
        int k = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1){
                    possible_moves[k][0] = i;
                    possible_moves[k][1] = j;
                    k++;
                }
            }
        }
        return possible_moves;
    }
}
