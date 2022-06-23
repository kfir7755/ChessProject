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

    public void setSquareInBoard(Square square, int x, int y) {
        this.board[x][y] = square;
    }

    public void gameStart() {
        Soldier[][] soldiers = new Soldier[8][8];
        soldiers[0][0] = new Rook(this.board[0][0], "w");
        soldiers[0][1] = new Knight(this.board[0][1], "w");
        soldiers[0][2] = new Bishop(this.board[0][2], "w");
        soldiers[0][3] = new Queen(this.board[0][3], "w");
        soldiers[0][4] = new King(this.board[0][4], "w");
        soldiers[0][5] = new Bishop(this.board[0][5], "w");
        soldiers[0][6] = new Knight(this.board[0][6], "w");
        soldiers[0][7] = new Rook(this.board[0][7], "w");
        for (int i = 0; i < 8; i++) {
            soldiers[1][i] = new Pawn(board[1][i], "w", true);
        }
        for (int i = 0; i < 8; i++) {
            soldiers[6][i] = new Pawn(board[6][i], "b", true);
        }
        soldiers[7][0] = new Rook(this.board[7][0], "b");
        soldiers[7][1] = new Knight(this.board[7][1], "b");
        soldiers[7][2] = new Bishop(this.board[7][2], "b");
        soldiers[7][3] = new Queen(this.board[7][3], "b");
        soldiers[7][4] = new King(this.board[7][4], "b");
        soldiers[7][5] = new Bishop(this.board[7][5], "b");
        soldiers[7][6] = new Knight(this.board[7][6], "b");
        soldiers[7][7] = new Rook(this.board[7][7], "b");
    }

    public int[][] possible_moves(Square square) {
        int[][] possible_moves = square.getSoldier().possible_moves();
        int counter = 0;
        int x, y, newX = 0, newY = 0, x1 = -1, y1 = -1, x2 = -1, y2 = -1;
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
            if (square.getSoldier().getColor().equals("w")) {
                newX = x + 1;
                newY = y + 1;
                if (newX > -1 && newX < 8 && newY > -1 && newY < 8)
                    if (board[newX][newY].getSoldier() != null)
                        if (board[newX][newY].getSoldier().getColor().equals("b")) {
                            counter++;
                            x1 = newX;
                            y1 = newY;
                        }


                newY = y - 1;
                if (newX > -1 && newX < 8 && newY > -1 && newY < 8) {
                    if (board[newX][newY].getSoldier().getColor().equals("b")) {
                        counter++;
                        x2 = newX;
                        y2 = newY;
                    }
                }
            }
        } else if (square.getSoldier().getLetter() == 'P') {
            x = square.getX();
            y = square.getY();
            if (square.getSoldier().getColor().equals("b")) {
                newX = x - 1;
                newY = y - 1;
            }
            if (newX > -1 && newX < 8 && newY > -1 && newY < 8) {
                if (board[newX][newY].getSoldier().getColor().equals("w")) {
                    counter++;
                }
            }
            newY = y - 1;
            if (newX > -1 && newX < 8 && newY > -1 && newY < 8) {
                if (board[newX][newY].getSoldier().getColor().equals("w")) {
                    counter++;
                }
            }
        }

        int k = 0;
        int k_counter = 0;
        int[][] new_possible_moves = new int[counter][2];
        while (k_counter < counter) {
            x = possible_moves[k][0];
            y = possible_moves[k++][1];
            if (board[x][y].getSoldier() == null) {
                new_possible_moves[k_counter][0] = x;
                new_possible_moves[k_counter++][1] = y;
                k++;
                k_counter++;
            }
        }

        if (x1 != -1 && x2 != -1) {
            new_possible_moves[counter - 2][0] = x1;
            new_possible_moves[counter - 2][1] = y1;
            new_possible_moves[counter - 1][0] = x2;
            new_possible_moves[counter - 1][1] = y2;
        } else if (x1 != -1 && x2 == -1) {
            new_possible_moves[counter - 1][0] = x1;
            new_possible_moves[counter - 1][1] = y1;
        } else if (x1 == -1 && x2 != -1) {
            new_possible_moves[counter - 1][0] = x2;
            new_possible_moves[counter - 1][1] = y2;
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
        System.out.print("__________________________");
    }
}
