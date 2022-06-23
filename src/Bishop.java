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
        while (newY > -1 && newX > -1){
            board[newX][newY] = 1;
            counter++;
            newY--;
            newX--;
        }
        newY = this.square.getY()+1;
        while (newY < 8 && newX > -1){
            board[newX][newY] = 1;
            counter++;
            newY++;
            newX--;
        }
        newX = this.square.getX()+1;
        while (newY < 8 && newX < 8){
            board[newX][newY] = 1;
            counter++;
            newY++;
            newX++;
        }
        newY = this.square.getY()-1;
        while (newY > -1 && newX < 8){
            board[newX][newY] = 1;
            counter++;
            newY--;
            newX++;
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
