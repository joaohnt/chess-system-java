package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn (Board board, Color color) {
        super(board, color);
    }

    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        if(getColor() == Color.WHITE) {
            // move
            p.setValues(position.getRow() -1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //first move
            p.setValues(position.getRow() -2, position.getColumn());
            Position p2 = new Position(position.getRow()-1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //capture piece left diagonal
            p.setValues(position.getRow() -1, position.getColumn()-1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //capture piece right diagonal
            p.setValues(position.getRow() -1, position.getColumn()+1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        else {
            //move
            p.setValues(position.getRow() +1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //first move
            p.setValues(position.getRow() +2, position.getColumn());
            Position p2 = new Position(position.getRow()+1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //capture piece left diagonal
            p.setValues(position.getRow() +1, position.getColumn()-1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //capture piece right diagonal
            p.setValues(position.getRow() +1, position.getColumn()+1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        return mat;
    }


}
