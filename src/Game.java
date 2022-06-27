import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player[] players;
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    List<Move> movesPlayed;

    public Player getCurrentTurn() {
        return this.currentTurn;
    }
    public Game (Player p1, Player p2) {
        players = new Player[2];
        this.players[0] = p1;
        this.players[1] = p2;

        Board board = new Board();

        if (p1.isWhiteSide()) {
            this.currentTurn = p1;
        } else {
            this.currentTurn = p2;
        }
        movesPlayed = new ArrayList<Move>();
        movesPlayed.clear();
    }

    public boolean isEnd() {
        if (this.status != GameStatus.ACTIVE) {
            return true;
        } else {
            return false;
        }
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) throws Exception {
        Spot startBox = board.getBox(startX, startY);
        Spot endBox = board.getBox(endX, endY);
        Move move = new Move(player, startBox, endBox);
        return this.makeMove(move, player);
    }

    public boolean makeMove(Move move, Player player) throws Exception {
        Piece sourcePiece = move.getStart().getPiece();
        Piece destPiece = move.getEnd().getPiece();
        if (sourcePiece == null) {
            return false;
        }

        if (player != currentTurn) {
            return false;
        }

        if (sourcePiece.getIsWhite() != player.isWhiteSide()) { //Valid Player?
            return false;
        }

        if (! sourcePiece.canMove(board, move.getStart(), move.getEnd())) { // Valid move?
            return false;
        }

        if (destPiece.getIsWhite() != sourcePiece.getIsWhite() ){ //Killed?
            destPiece.setIsKilled(true);
            move.setPieceKilled(destPiece);
        }

        if (sourcePiece != null && sourcePiece instanceof King) { // Castling?
            move.setCanCastling(true);
        }

        movesPlayed.add(move); //Store move

        //move piece from start to end
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        if (destPiece != null && destPiece instanceof King) { //King is killed
            if (player.isWhiteSide()) {
                this.setStatus(GameStatus.WHITE_WIN);
            } else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
        }

        if (this.currentTurn == players[0]) {
            this.currentTurn = players[1];
        } else {
            this.currentTurn = players[0];
        }

        return true;
    }
}
