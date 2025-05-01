package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku {
    private static final int SIZE = 9; //9 by 9 board
    private int[][] board =  new int[SIZE][SIZE];

    public void loadBoard(String filepath){
        try(Scanner scan = new Scanner(new File(filepath))){
            for (int i=0; i<SIZE; i++){
                for (int j=0; j<SIZE; j++){
                    if(scan.hasNextInt()) {
                        board[i][j] = scan.nextInt();
                    }else{
                        throw new IllegalArgumentException("Error in sudoku.txt");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean solveSudoku(int row, int col){
        if(row == SIZE-1 && col == SIZE)//end of the board has been reached
        {
            return true;
        }
        if(board[row][col] != 0){//keeps moving if a cell is full
            return solveSudoku(row, col+1);
        }
        for(int i=0; i<SIZE; i++){
            if(isSafe(row, col, i)){
                board[row][col] = i;
                if(solveSudoku(row, col+1)){
                    return true;
                }
                board[row][col] = 0;//backtracking!
            }
        }
        return false;}

    public void solve(){
        System.out.println("\nSolving sudoku...");

        if(solveSudoku(0, 0)) {
            System.out.println("Solved!");
            printBoard();
        }else{
            System.out.println("\nPuzzle could not be solved.\nNo answer exists.");
        }
    }
    public boolean isSafe(int row, int col, int numb){
        for(int i=0; i<SIZE; i++){
            if(board[row][i] == numb || board[i][col] == numb){
                return false;
            }
        }

        int sRow = row - row%3;
        int sCol = col - col%3;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(board[sRow+i][sCol+j] == numb){
                    return false;
                }
            }
        }
        return true;
    }//selected num in cell
    public void printBoard(){
        for (int i=0; i<SIZE; i++){
            for (int j=0; j<SIZE; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getBoard(){return this.board;}
    public void setBoard(int[][] board){this.board = board;}
}
