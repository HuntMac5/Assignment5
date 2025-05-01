package sudoku;

public class Sudoku {
    private static final int SIZE = 9; //9 by 9 board
    private int[][] board =  new int[SIZE][SIZE];

    public void loadBoard(String filepath){}
    public boolean solveSudoku(int row, int col){}
    public void solve(){}
    public boolean isSafe(int row, int col, int numb){}//selected num in cell
    public void printBoard(){}

    public int[][] getBoard(){return this.board;}
    public void setBoard(int[][] board){this.board = board;}
}
