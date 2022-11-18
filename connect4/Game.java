import java.util.Scanner;

public class Game {

    public static int dropCoinAt(int player, Slot[][] board, int column) {
        if(column > 7 || column < 0) {
            System.out.println("BAD NUMBER \n");
            return -1;
        }
        
        int row = 6;
        // Check if below is occupied, 
        // if empty, go down, else stop

        if(board[row-1][column].isEmpty == false) {
            System.out.println("BAD MOVE - SKIP TURN \n");
        }
        while( board[row-1][column].isEmpty == true) {

            // First time - edgecase
            if(row-1 == 0){
                System.out.print("Row: ");
                System.out.println(row-1 + " Col: " + column + " is now occupied by Player" + player + "\n");
                board[row-1][column].isEmpty = false;
                board[row-1][column].whoControls = player;
                return row-1; 
            }
            
            row--;    
        }

        //when a coin is dropped, if the column is full, skip turn
        if(board[row][column].isEmpty == false) {
            System.out.println("COLUMN FULL - SKIP TURN");
        }

        // Default 
        System.out.println("Row: " + row + " Col: " + column + " is now occupied by Player" + player + "\n");
        board[row][column].isEmpty = false;
        board[row-1][column].whoControls = player;
        return row;
    }

    public static boolean checkForVictory(Slot[][] board, int player) {
        if(WinnerCheck.checkHorizontal(board, player) == true) return true;
        if(WinnerCheck.checkVertical(board, player) == true) return true;
        if(WinnerCheck.checkAscDiagonal(board, player) == true) return true;
        if(WinnerCheck.checkDescDiagonal(board, player) == true) return true;
        return false;
    }

    // Main
    public static void main(String[] args) {

        // BoilerPlate
        Scanner scan = new Scanner(System.in);
        int select = 0;
        boolean gameIsOn = true;
        boolean player1turn = true;
        boolean player2turn = false;
        player1turn = true;

        // Set up the board
        Slot[][] board = new Slot[10][10];
        
        //fill board with empty slots
        for(int i = 0; i <= 6; i++) {
            for(int j = 0; j <= 7; j++) {
                board[i][j] = new Slot(true);
            }
        }
        

        
        // Main gameloop
        while(gameIsOn = true) {

            if(player1turn == true) {

                System.out.println("Player1: Select a column to drop, 0-7");
                select = scan.nextInt();
                dropCoinAt(1, board, select);

                if(checkForVictory(board, 1) == true) {
                    System.out.println("PLAYER 1 HAS WON THE GAME!!!!");
                    gameIsOn = false;
                    break;
                }

                player2turn = true;
                player1turn = false;
            }
            else if(player2turn == true) {

                System.out.println("Player2: Select a column to drop");
                select = scan.nextInt();
                dropCoinAt(2, board, select);

                if(checkForVictory(board, 2) == true) {
                    System.out.println("PLAYER 2 HAS WON THE GAME!!!!");
                    gameIsOn = false;
                    break;
                }

                player1turn = true;
                player2turn = false;
            }
        }
        scan.close();
    }
}