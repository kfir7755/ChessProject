public class Board{
    private Square[][] board = new Square[8][8];

    public void gameStart(){
        Soldier[][] soldiers = new Soldier[8][8];
        soldiers[0][0] = new Rook(0,0,"white");
        soldiers[0][1] = new Knight(0,1,"white");
        soldiers[0][2] = new Bishop(0,2,"white");
        soldiers[0][3] = new Queen(0,3,"white");
        soldiers[0][4] = new King(0,4,"white");
        soldiers[0][5] = new Bishop(0,5,"white");
        soldiers[0][6] = new Knight(0,6,"white");
        soldiers[0][7] = new Rook(0,7,"white");
        for (int i = 0; i < 8; i++) {
            soldiers[1][i] = new Pawn(1,i,"white", true);
        }
        for (int i = 0; i < 8; i++) {
            soldiers[6][i] = new Pawn(6,i, "black", true);
        }
        soldiers[7][0] = new Rook(7,0,"black");
        soldiers[7][1] = new Knight(7,1,"black");
        soldiers[7][2] = new Bishop(7,2,"black");
        soldiers[7][3] = new Queen(7,3,"black");
        soldiers[7][4] = new King(7,4,"black");
        soldiers[7][5] = new Bishop(7,5,"black");
        soldiers[7][6] = new Knight(7,6,"black");
        soldiers[7][7] = new Rook(7,7,"black");


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square(i, j, soldiers[i][j]);
            }
        }
    }

    public Square[][] getBoard() {
        return board;
    }

    public Square getSquare(int x, int y){
        return this.board[x][y];
    }

    public int[][] possible_moves(Square square){
        int[][] possible_moves = square.getSoldier().possible_moves();
        int counter = 0;
        int x, y, newX = 0, newY = 0, x1 = -1, y1 = -1, x2 = -1, y2 = -1;
        for (int i = 0; i < possible_moves.length; i++) {
            x = possible_moves[i][0];
            y = possible_moves[i][1];
            if (this.board[x][y].getSoldier() == null){
                counter++;
            }
        }
        if (square.getSoldier().getLetter() == 'P') {
            x = square.getSoldier().getX();
            y = square.getSoldier().getY();
            if (square.getSoldier().getColor().equals("white")) {
                newX = x + 1;
                newY = y + 1;
                if (newX > -1 && newX < 8 && newY > -1 && newY < 8)
                    if (board[newX][newY].getSoldier() != null)
                        if (board[newX][newY].getSoldier().getColor().equals("black")) {
                            counter++;
                            x1 = newX;
                            y1 = newY;
                        }


                newY = y - 1;
                if (newX > -1 && newX < 8 && newY > -1 && newY < 8) {
                    if (board[newX][newY].getSoldier().getColor().equals("black")) {
                        counter++;
                        x2 = newX;
                        y2 = newY;
                    }
                }
            }
        }
        else if (square.getSoldier().getLetter() == 'P'){
            x = square.getSoldier().getX();
            y = square.getSoldier().getY();
            if (square.getSoldier().getColor().equals("black")) {
                newX = x - 1;
                newY = y - 1;
            }
            if (newX >-1 && newX < 8 && newY > -1 && newY < 8){
                if (board[newX][newY].getSoldier().getColor().equals("white")){
                    counter++;
                }
            }
            newY = y-1;
            if (newX >-1 && newX < 8 && newY > -1 && newY < 8){
                if (board[newX][newY].getSoldier().getColor().equals("white")){
                    counter++;
                }
            }
        }

        int k = 0;
        int k_counter=0;
        int[][] new_possible_moves = new int[counter][2];
        while (k_counter < counter) {
            x = possible_moves[k][0];
            y = possible_moves[k++][1];
            if (board[x][y].getSoldier() == null){
                new_possible_moves[k_counter][0] = x;
                new_possible_moves[k_counter++][1] = y;
                k++;
                k_counter++;
            }
        }

        if (x1 != -1 && x2 != -1){
            new_possible_moves[counter-2][0] = x1;
            new_possible_moves[counter-2][1] = y1;
            new_possible_moves[counter-1][0] = x2;
            new_possible_moves[counter-1][1] = y2;
        }
        else if (x1 != -1 && x2 == -1){
            new_possible_moves[counter-1][0] = x1;
            new_possible_moves[counter-1][1] = y1;
        }
        else if (x1 == -1 && x2 != -1){
            new_possible_moves[counter-1][0] = x2;
            new_possible_moves[counter-1][1] = y2;
        }

        return new_possible_moves;
    }

    public void setSquareInBoard(Square square, int x, int y) {
        this.board[x][y] = square;
    }

    public void print_board(){
        System.out.println("_________________________");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print('|');
                Soldier soldier = this.board[i][j].getSoldier();
                if (soldier == null) {
                    System.out.print("  ");
                }
                else if (i==0 || i==1) {
                    System.out.print("w" + soldier.getLetter());
                }
                else if (i==7 || i==6){
                    System.out.print("b" + soldier.getLetter());
                }
            }
            System.out.println('|');
        }
        System.out.print("__________________________");
    }
}
