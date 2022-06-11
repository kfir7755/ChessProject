public class Main {

    public static void print_arr(int[][] arr){
        if (arr.length == 0){;}
        else {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.println("(" + arr[i][0] + "," + arr[i][1] + ")");
            }
            System.out.print("]");
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args) {
    Queen queen = new Queen(0,0, "black");
    System.out.println("hello");
    int[][] test = queen.possible_moves();
    print_arr(test);
    }
}
