import java.util.Scanner;

public class chess {
    static int N;

    // Function for printing the solution
    static void printSol(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* Optimized isSafe function
       isSafe function to check if current row contains or current left diagonal or current right diagonal contains any queen or not if
       yes return false
       else return true
    */
    static boolean isSafe(int row, int col, boolean[] rows, boolean[] leftDiagonals, boolean[] rightDiagonals) {
        if(rows[row] || leftDiagonals[col+row] || rightDiagonals[col-row+N-1]){
            return false;
        }
        return true;
    }

    // Recursive function to solve N-queen Problem
    static boolean solve(int[][] board, int col, boolean[] rows, boolean[] leftDiagonals, boolean[] rightDiagonals) {
        // Base Case: If all Queens are placed
        if (col >= N) {
            return true;
        }

        /* Consider this Column and move in all rows one by one */
        for (int i = 0; i < N; i++) {
            if (isSafe(i, col, rows, leftDiagonals, rightDiagonals)) {
                rows[i]=true;
                leftDiagonals[col+i]=true;
                rightDiagonals[col-i+N-1]=true;
                board[i][col]=1;

                if(solve(board,col+1, rows, leftDiagonals, rightDiagonals)){
                    return true;

                }

                rows[i]=false;
                leftDiagonals[col+i]=false;
                rightDiagonals[col-i+N-1]=false;
                board[i][col]=0;


            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter the number of rows for the square Board: ");
        N = scanner.nextInt();

        // Board of size N*N
        int[][] board = new int[N][N];

        // Array to tell which rows are occupied
        boolean[] rows = new boolean[N];

        // Arrays to tell which diagonals are occupied
        boolean[] leftDiagonals = new boolean[2 * N - 1];
        boolean[] rightDiagonals = new boolean[2 * N - 1];

        boolean ans = solve(board, 0, rows, leftDiagonals, rightDiagonals);

        if (ans) {
            // Printing the solution Board
            printSol(board);
        } else {
            System.out.println("Solution Does not Exist");
        }
    }
}
