public class Queen extends Soldier{


    public Queen(int x, int y, String color) {
        super(x,y,color, 'Q');
    }

    @Override
    public int[][] possible_moves() {
        int counter = 0;
        int newX = x - 1;
        int[][] board = new int[8][8];
        while (newX > -1) {
            board[newX][y] = 1;
            counter++;
            newX--;
        }
        newX = x + 1;
        while (newX < 8) {
            board[newX][y] = 1;
            counter++;
            newX++;
        }
        int newY = y - 1;
        while (newY > -1) {
            board[x][newY] = 1;
            counter++;
            newY--;
        }
        newY = y + 1;
        while (newY < 8) {
            board[x][newY] = 1;
            counter++;
            newY++;
        }
        newX = x - 1;
        newY = y - 1;
        while (newY > -1 && newX > -1) {
            board[newX][newY] = 1;
            counter++;
            newY--;
            newX--;
        }
        newY = y + 1;
        while (newY < 8 && newX > -1) {
            board[newX][newY] = 1;
            counter++;
            newY++;
            newX--;
        }
        newX = x + 1;
        while (newY < 8 && newX < 8) {
            board[newX][newY] = 1;
            counter++;
            newY++;
            newX++;
        }
        newY = y - 1;
        while (newY > -1 && newX < 8) {
            board[newX][newY] = 1;
            counter++;
            newY--;
            newX++;
        }
        int[][] possible_moves = new int[counter][2];
        int k = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    possible_moves[k][0] = i;
                    possible_moves[k][1] = j;
                    k++;
                }
            }
        }
        return possible_moves;
    }
}
