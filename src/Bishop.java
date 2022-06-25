public class Bishop extends Soldier{

    public Bishop(Square square, String color) {
        super(square ,color, 'B');
    }

    @Override
    public int[][] possible_moves(){
        int[][] board = new int[8][8];
        int newX = this.square.getX()-1;
        int newY = this.square.getY()-1;
        int counter = 0;
        Board board1 = new Board();
        newX = this.square.getX() - 1;
        newY = this.square.getY() - 1;
        while (newY >= 0 && newX >= 0) {
            if (board1.getBoard()[newX][newY].getSoldier() == null) {
                board[newX][newY] = 1;
                counter++;
                newY--;
                newX--;
            } else if (!color.equals(board1.getBoard()[newX][newY])) {
                board[newX][newY] = 1;
                counter++;
                break;
            } else {
                break;
            }
        }

        newX = this.square.getX() - 1;
        newY = this.square.getY() + 1;
        while (newY < 8 && newX >= 0) {
            if (board1.getBoard()[newX][newY].getSoldier() == null) {
                board[newX][newY] = 1;
                counter++;
                newY++;
                newX--;
            } else if (!color.equals(board1.getBoard()[newX][newY])) {
                board[newX][newY] = 1;
                counter++;
                break;
            } else {
                break;
            }
        }

        newX = this.square.getX() + 1;
        newY = this.square.getY() + 1;
        while (newY < 8 && newX < 8 && board1.getBoard()[newX][newY].getSoldier() == null) {
            if (board1.getBoard()[newX][newY].getSoldier() == null) {
                board[newX][newY] = 1;
                counter++;
                newY++;
                newX++;
            } else if (!color.equals(board1.getBoard()[newX][newY])) {
                board[newX][newY] = 1;
                counter++;
                break;
            } else {
                break;
            }
        }
        newX = this.square.getX() + 1;
        newY = this.square.getY() - 1;
        while (newY >= 0 && newX < 8 && board1.getBoard()[newX][newY].getSoldier() == null) {
            if (board1.getBoard()[newX][newY].getSoldier() == null) {
                board[newX][newY] = 1;
                counter++;
                newY--;
                newX++;
            } else if (!color.equals(board1.getBoard()[newX][newY])) {
                board[newX][newY] = 1;
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
