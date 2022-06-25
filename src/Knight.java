public class Knight extends Soldier{
    Board board = new Board();
    private final static int[][] moves={
            {-1,-2},
            {-2,-1},
            {-2,1},
            {-1,2},
            {1,2},
            {2,1},
            {2,-1},
            {1,-2}
    };

    public Knight(Square square, String color) {
        super(square,color, 'k');
    }

    private boolean is_valid_move(int[] move) {
        int[] location = {this.square.getX() + move[0], this.square.getY() + move[1]};
        if ((location[0] < 8 && location[0] > 0) && (location[1] < 8 && location[1] >= 0)) {
            if (board.getBoard()[location[0]][location[1]].getSoldier()==null ||
                    (!board.getBoard()[location[0]][location[1]].getSoldier().getColor().equals(this.color))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int[][] possible_moves (){
        int size_of_legal_moves=0;
        String color = square.getSoldier().getColor();
        for(int[] move : moves){
            if (this.is_valid_move(move))
                size_of_legal_moves++;
        }
        int[][] possible_moves= new int[size_of_legal_moves][2];
        int i=0;
        for(int[] move : moves){
            if (is_valid_move(move)) {
                possible_moves[i][0] = this.square.getX() + move[0];
                possible_moves[i][1] = this.square.getY() + move[1];
                i++;
            }
        }

        return possible_moves;
    }
}
