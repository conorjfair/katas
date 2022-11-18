public class WinnerCheck {
    public static boolean checkHorizontal(Slot[][] board, int player) {
        boolean won = false;
        for(int i = 0; i <= 6; i++){
            for(int j = 0; j <= 7; j++){
                if(board[i][j].whoControls == player && board[i][j+1].whoControls == player && board[i][j+2].whoControls == player && board[i][j+3].whoControls == player)
                won = true;
            }
        }
        return won;
    }

    public static boolean checkVertical(Slot[][] board, int player) {
        boolean won = false;
        for(int i = 0; i <= 6; i++){
            for(int j = 0; j <= 7; j++){
                if(board[i][j].whoControls == player && board[i+1][j].whoControls == player && board[i+2][j].whoControls == player && board[i+3][j].whoControls == player)
                won = true;
            }
        }
        return won;
    }

    public static boolean checkAscDiagonal(Slot[][] board, int player) {
        boolean won = false;
        for(int i = 3; i <= 6; i++){
            for(int j = 0; j <= 4; j++){
                if(board[i][j].whoControls == player && board[i-1][j+1].whoControls == player && board[i-2][j+2].whoControls == player && board[i-3][j+3].whoControls == player)
                won = true;
            }
        }
        return won;
    }

    public static boolean checkDescDiagonal(Slot[][] board, int player) {
        boolean won = false;
        for(int i = 3; i <= 6; i++){
            for(int j = 0; j <= 7; j++){
                if(board[i][j].whoControls == player && board[i-1][j-1].whoControls == player && board[i-2][j-2].whoControls == player && board[i-3][j-3].whoControls == player)
                won = true;
            }
        }
        return won;
    }
}
