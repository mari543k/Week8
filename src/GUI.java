import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GUI {

    ArrayList<Integer>  xPositions = new ArrayList<>();
    ArrayList<Integer>  oPositions = new ArrayList<>();

    Scanner userInput = new Scanner(System.in);
    private int xInput;
    private int oInput;

    // Layoutet for spillebrættet
    String[][] board = {{"   ", "|", "   ", "|", "   "},
            {"---", "|", "---", "|", "---"},
            {"   ", "|", "   ", "|", "   "},
            {"---", "|", "---", "|", "---"},
            {"   ", "|", "   ", "|", "   "}};

    public void makeBoard() {

        // Udprint af spillebrættet
        for (String[] row : board) {
            for (String c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // X spillerens metode
    public void getXPlayer() {
        System.out.println("X's turn: make a move (1-9)");
        int xInput = userInput.nextInt();

        // Checker at xPositions eller oPositions ikke allerede har optaget den valgte plads ved "make a move"
        while (xPositions.contains(xInput) || oPositions.contains(xInput)) {
            System.out.println("This move is not available! Make anoter move");
            xInput = userInput.nextInt();
        }

        // Gennemfører make move hvis pladsen er ledig
        makeMove(board, xInput, "X");
    }

    // O spillerens metode
    public void getOPlayer() {
        System.out.println("O's turn: make a move (1-9)");
        int oInput = userInput.nextInt();

        // Checker at xPositions eller oPositions ikke allerede har optaget den valgte plads ved "make a move"
        while (xPositions.contains(oInput) || oPositions.contains(oInput)) {
            System.out.println("This move is not available! Make anoter move");
            oInput = userInput.nextInt();
        }

        // Gennemfører make move hvis pladsen er ledig
        makeMove(board, oInput, "O");
    }

    public void makeMove(String[][] board, int input, String player) {

        // Tom piece
        String piece = " ";

        // Piece får værdien X
        if (player.equals("X")) {
            piece = "X";
            xPositions.add(input);
        }
        // Piece får værdien O
        else if (player.equals("O")) {
            piece = "O";
            oPositions.add(input);
        }

        // Placerer X eller O på den valgte position på spillebrættet
        switch (input) {
            case 1:
                board[0][0] = " " + piece + " ";
                break;
            case 2:
                board[0][2] = " " + piece + " ";
                break;
            case 3:
                board[0][4] = " " + piece + " ";
                break;
            case 4:
                board[2][0] = " " + piece + " ";
                break;
            case 5:
                board[2][2] = " " + piece + " ";
                break;
            case 6:
                board[2][4] = " " + piece + " ";
                break;
            case 7:
                board[4][0] = " " + piece + " ";
                break;
            case 8:
                board[4][2] = " " + piece + " ";
                break;
            case 9:
                board[4][4] = " " + piece + " ";
                break;
            default:
                break;
        }
    }

    public String checkWinner() {

        // Laver liste ud af de forskellige positioner på spillebrættet
        List firstRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List lastRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        // Tilføjer ovenfor listerne til en samlet liste
        List<List> winningCond = new ArrayList<>();
        winningCond.add(firstRow);
        winningCond.add(midRow);
        winningCond.add(lastRow);
        winningCond.add(leftCol);
        winningCond.add(midCol);
        winningCond.add(rightCol);
        winningCond.add(cross1);
        winningCond.add(cross2);

        // For each loop der tjekker på if statements omkring hvorvidt spillerne har åbnået 3 på stribe eller om
        // spillet er end som uafgjort
        for (List list : winningCond) {
            if (xPositions.containsAll(list)) {
                return "Congratulations X won!";
            } else if (oPositions.containsAll(list)) {
                return "Congratulations O won!";
            } else if (xPositions.size() + oPositions.size() == 9) {
                return "It's a tie!";
            }
        }

        return "";
    }
}
