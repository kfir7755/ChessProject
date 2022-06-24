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

    public int[][] possible_moves(Square square) {
        int[][] possible_moves = square.getSoldier().possible_moves();
        int counter = 0;
        int x, y, newX = 0, newY = 0, x1 = -1, y1 = -1, x2 = -1, y2 = -1, eatingRight=0, eatingLeft=0;
        for (int i = 0; i < possible_moves.length; i++) {
            x = possible_moves[i][0];
            y = possible_moves[i][1];
            if (this.board[x][y].getSoldier() == null) {
                counter++;
            }
        }
        if (square.getSoldier().getLetter() == 'P') {
            x = square.getX();
            y = square.getY();
            if (square.getSoldier().getColor().equals("b")) {
                newX = x + 1;
                newY = y + 1;
                if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8)
                    if (board[newX][newY].getSoldier() != null)
                        if (board[newX][newY].getSoldier().getColor().equals("w")) {
                            eatingRight++;
                            x1 = newX;
                            y1 = newY;
                        }


                newY = y - 1;
                if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                    if (board[newX][newY].getSoldier().getColor().equals("w")) {
                        eatingLeft++;
                        x2 = newX;
                        y2 = newY;
                    }
                }
            }
        } else if (square.getSoldier().getLetter() == 'P') {
            x = square.getX();
            y = square.getY();
            if (square.getSoldier().getColor().equals("w")) {
                newX = x - 1;
                newY = y + 1;
            }
            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                if (board[newX][newY].getSoldier().getColor().equals("b")) {
                    eatingRight++;
                    x1 = newX;
                    y1 = newY;
                }
            }
            newY = y - 1;
            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                if (board[newX][newY].getSoldier().getColor().equals("b")) {
                    eatingLeft++;
                    x2 = newX;
                    y2 = newY;
                }
            }
        }

        int k = 0;
        int k_counter = 0;
        int[][] new_possible_moves = new int[counter+ eatingLeft+ eatingRight][2];
        while (k_counter < counter) {
            x = possible_moves[k][0];
            y = possible_moves[k++][1];
            if (board[x][y].getSoldier() == null) {
                new_possible_moves[k_counter][0] = x;
                new_possible_moves[k_counter++][1] = y;
                k_counter++;
            }
        }

        if (eatingRight > 0) {
            new_possible_moves[counter][0] = x1;
            new_possible_moves[counter++][1] = y1;
        }
        if(eatingLeft > 0) {
            new_possible_moves[counter][0] = x2;
            new_possible_moves[counter][1] = y2;
        }
        return new_possible_moves;
    }

    public void print_board() {
        System.out.println("_________________________");
        for (int i = 0; i < 8; i++) {
            System.out.print('|');
            for (int j = 0; j < 8; j++) {
                Soldier soldier = this.board[i][j].getSoldier();
                if (soldier == null) {
                    System.out.print("  ");
                } else  {
                    System.out.print(soldier.getColor() + soldier.getLetter());
                }
                System.out.print('|');
            }
            System.out.println();
        }
        System.out.println("_________________________");
    }

    public boolean move(int x, int y, Square square) {
        boolean can_move = false;
        int[][] possible_moves = possible_moves(square);
        for (int i = 0; i < possible_moves[0].length; i++) {
            if (possible_moves[i][0] == x && possible_moves[i][1] == y){
                can_move = true;
            }
        }
        return can_move;
    }
}
