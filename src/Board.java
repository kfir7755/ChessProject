public class Board {
    private Square[][] board = new Square[8][8];

    public Square[][] getBoard() {
        return board;
    }

    public Square getSquare(int x, int y) {
        return this.board[x][y];
    }

    public Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = new Square(i, j, null);
            }
        }
    }

    public void setSquareInBoard(Square square) {
        this.board[square.getX()][square.getY()] = square;
    }

    public void gameStart() {
        Soldier[][] soldiers = new Soldier[8][8];
        soldiers[0][0] = new Rook(this.board[0][0], "b");
        soldiers[0][1] = new Knight(this.board[0][1], "b");
        soldiers[0][2] = new Bishop(this.board[0][2], "b");
        soldiers[0][3] = new Queen(this.board[0][3], "b");
        soldiers[0][4] = new King(this.board[0][4], "b");
        soldiers[0][5] = new Bishop(this.board[0][5], "b");
        soldiers[0][6] = new Knight(this.board[0][6], "b");
        soldiers[0][7] = new Rook(this.board[0][7], "b");
        for (int i = 0; i < 8; i++) {
            soldiers[1][i] = new Pawn(board[1][i], "b", true);
        }
        for (int i = 0; i < 8; i++) {
            soldiers[6][i] = new Pawn(board[6][i], "w", true);
        }
        soldiers[7][0] = new Rook(this.board[7][0], "w");
        soldiers[7][1] = new Knight(this.board[7][1], "w");
        soldiers[7][2] = new Bishop(this.board[7][2], "w");
        soldiers[7][3] = new Queen(this.board[7][3], "w");
        soldiers[7][4] = new King(this.board[7][4], "w");
        soldiers[7][5] = new Bishop(this.board[7][5], "w");
        soldiers[7][6] = new Knight(this.board[7][6], "w");
        soldiers[7][7] = new Rook(this.board[7][7], "w");
    }

    public void print_board() {
        System.out.println("_________________________");
        for (int i = 0; i < 8; i++) {
            System.out.print('|');
            for (int j = 0; j < 8; j++) {
                Soldier soldier = getSquare(i, j).getSoldier();
                if (soldier == null) {
                    System.out.print("  ");
                } else {
                    System.out.print(soldier.getColor() + soldier.getLetter());
                }
                System.out.print('|');
            }
            System.out.println();
        }
        System.out.println("_________________________");
    }

    public int[][] possible_moves(Square square, Board board) {
        return square.getSoldier().possible_moves(board);
    }

    public void move(int x, int y, int to_move_x, int to_move_y) {
        int[][] possible_moves = getSquare(x, y).getSoldier().possible_moves(this);
        boolean is_valid = false;
        for (int i = 0; i < possible_moves.length; i++) {
            if (possible_moves[i][0] == to_move_x && possible_moves[i][1] == to_move_y){
                is_valid = true;
            }
        }
        if (is_valid == true) {
            Soldier soldier = getSquare(x, y).getSoldier();
            getSquare(x, y).setSoldier(null);
            getSquare(to_move_x, to_move_y).setSoldier(soldier);
        }
    }

}


