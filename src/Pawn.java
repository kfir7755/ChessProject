
public class Pawn extends Soldier{
    private boolean isFirstMove;

    public Pawn(Square square,String color, boolean isFirstMove) {
        super(square ,color, 'P');
        this.isFirstMove = isFirstMove;
    }

    @Override
    public int[][] possible_moves() {
        int[][] newBoard = new int[8][8];
        Board board = new Board();
        board.getBoard();
        int x1 = -1, x2 = -1, y1 = 0, y2 = 0, counter = 0;
        if (isFirstMove && this.color.equals("w")) {
            int newX = this.square.getX() - 1;
            newBoard[newX][this.square.getY()] = 1;
            newX -= 1;
            newBoard[newX][this.square.getY()] = 1;
            counter += 2;
        } else if (this.color.equals("w")) {
            int newX = this.square.getX() - 1;
            newBoard[newX][this.square.getY()] = 1;
            counter++;
        }

        if (isFirstMove && this.color.equals("b")) {
            int newX = this.square.getX() + 1;
            newBoard[newX][this.square.getY()] = 1;
            newX += 1;
            newBoard[newX][this.square.getY()] = 1;
            counter += 2;
        } else if (this.color.equals("b")) {
            int newX = this.square.getX() + 1;
            newBoard[newX][this.square.getY()] = 1;
            counter++;
        }
        if (this.color.equals("b")) {
            int newX = square.getX() + 1;
            int newY = square.getY() + 1;
            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                if (board.getBoard()[newX][newY].getSoldier() != null) {
                    if (board.getBoard()[newX][newY].getSoldier().getColor().equals("w")) {
                        counter++;
                        x1 = newX;
                        y1 = newY;
                    }
                }
            }
            newY = square.getY() - 1;
            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                if (board.getBoard()[newX][newY].getSoldier() != null) {
                    if (board.getBoard()[newX][newY].getSoldier().getColor().equals("w")) {
                        counter++;
                        x1 = newX;
                        y1 = newY;
                    }
                }
            }
        } else {
            int newX = square.getX() - 1;
            int newY = square.getY() + 1;
            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                if (board.getBoard()[newX][newY].getSoldier().getColor().equals("b")) {
                    counter++;
                    x1 = newX;
                    y1 = newY;
                }
            }
            newY = square.getY() - 1;
            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                if (board.getBoard()[newX][newY].getSoldier().getColor().equals("b")) {
                    counter++;
                    x2 = newX;
                    y2 = newY;
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (newBoard[i][j] == 1) {
                        counter++;
                    }
                }
            }
        }
            int k = 0;
            int[][] possible_moves = new int[counter][2];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (newBoard[i][j] == 1) {
                        possible_moves[k][0] = i;
                        possible_moves[k][1] = j;
                        k++;
                    }
                }
            }
            if (x1 != -1 && x2 != -1){
                possible_moves[counter-2][0] = x1;
                possible_moves[counter-2][1] = y1;
                possible_moves[counter-1][0] = x2;
                possible_moves[counter-1][1] = y2;
            }
            else if (x1 != -1 && x2 == -1){
                possible_moves[counter-1][0] = x1;
                possible_moves[counter-1][1] = y1;
            }
            else if (x1 == -1 && x2 != -1){
                possible_moves[counter-1][0] = x2;
                possible_moves[counter-1][1] = y2;
            }
        return possible_moves;
    }
}

