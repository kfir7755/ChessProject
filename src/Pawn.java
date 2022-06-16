
public class Pawn extends Soldier{
    private boolean isFirstMove;

    public Pawn(int x, int y,String color, boolean isFirstMove) {
        super(x,y,color, 'P');
        this.isFirstMove = isFirstMove;
    }

    @Override
    public int[][] possible_moves() {
        int[][] newBoard = new int[8][8];

        if (isFirstMove && this.color.equals("black")){
            int newX = x+1;
            newBoard[newX][y] = 1;
            newX+=1;
            newBoard[newX][y] = 1;
        }
        else if (this.color.equals("black")){
            int newX = x+1;
            newBoard[newX][y] = 1;
        }

        if (isFirstMove && this.color.equals("white")){
            int newX = x-1;
            newBoard[newX][y] = 1;
            newX-=1;
            newBoard[newX][y] = 1;
        }
        else if (this.color.equals("white")){
            int newX = x-1;
            newBoard[newX][y] = 1;
        }
        int counter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (newBoard[i][j] == 1){
                    counter++;
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
        return possible_moves;
    }
}

