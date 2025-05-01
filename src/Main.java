import sudoku.Sudoku;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();

        // Load the Sudoku puzzle from the specified file
        sudoku.loadBoard(".../Group4_Assignment5/src/sudoku.txt");
        System.out.println("Loaded Sudoku Puzzle:");
        sudoku.printBoard();

        // Solve the puzzle
        sudoku.solve();
    }
}
