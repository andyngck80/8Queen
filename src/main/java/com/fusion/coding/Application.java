package com.fusion.coding;

public class Application {

    public static void main(String[] args) {
        hasEngagingQueens(args);
    }

    public static boolean hasEngagingQueens(String[] positions) {
        ChessBoard chessBoard = new ChessBoard();
        for (int i = 0; i < positions.length; i++) {
            if (!chessBoard.placeQueen(positions[i])) {
                return true;
            }
        }

        return false;
    }
}
