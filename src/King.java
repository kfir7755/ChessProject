public class King extends Soldier{
    private final static int[][] moves={
            {0,1},
            {-1,1},
            {-1,0},
            {-1,-1},
            {0,-1},
            {1,-1},
            {1,0},
            {1,1}
    };

    public King(Square square, String color) {
        super(square ,color, 'K');
    }

    private boolean is_valid_move(int[] move, Board board){
        int[] location={this.square.getX()+move[0], this.square.getY()+move[1]};
        if ((location[0]>7 || location[0]< 0) && (location[1]>7 || location[1]< 0) && board.getSquare(location[0], location[1]).getSoldier().getColor().equals(this.color)){
            return false;
        }
        else if (board.getBoard()[location[0]][location[1]].getSoldier() == null || !board.getSquare(location[0],location[1]).getSoldier().getColor().equals(this.color)){
            return true;
        }
        else return false;
    }


    @Override
    public int[][] possible_moves (Board board){
        int size_of_legal_moves=0;
        for(int[] move : moves){
            if (is_valid_move(move ,board))
            size_of_legal_moves++;
        }
        int[][] possible_moves= new int[size_of_legal_moves][2];
        int i=0;
        for(int[] move : moves){
            if (is_valid_move(move ,board)) {
                possible_moves[i][0] = this.square.getX() + move[0];
                possible_moves[i][1] = this.square.getY() + move[1];
                i++;
            }
        }
        return possible_moves;
    }
}
