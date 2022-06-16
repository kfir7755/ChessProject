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

    public King(int x, int y, String color) {
        super(x,y,color, 'K');
    }

    private boolean is_valid_move(int[] move){
        int[] location={this.x+move[0], this.y+move[1]};
        if (location[0]>7 || location[0]< 0) return false;
        if (location[1]>7 || location[1]< 0) return false;
        return true;
    }

    @Override
    public int[][] possible_moves (){
        int size_of_legal_moves=0;
        for(int[] move : moves){
            if (is_valid_move(move))
            size_of_legal_moves++;
        }
        int[][] possible_moves= new int[size_of_legal_moves][2];
        int i=0;
        for(int[] move : moves){
            if (is_valid_move(move)) {
                possible_moves[i][0] = this.x + move[0];
                possible_moves[i][1] = this.y + move[1];
                i++;
            }
        }
        return possible_moves;
    }
}
