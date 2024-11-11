package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();

        while(true) {
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.printf("Source: ");
            ChessPosition source = UI.readChessPosistion(sc);

            System.out.println();
            System.out.printf("Target: ");
            ChessPosition target = UI.readChessPosistion(sc);

            ChessPiece capturedpiece = chessMatch.performChessMove(source, target);
        }
    }
}