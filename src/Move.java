public class Move {
    private Player player;
    private Spot start;
    private Spot end;
    private Piece pieceMoved;
    private Piece pieceKilled;
    private boolean castlingMoved = false;

    public Move (Player player, Spot start, Spot end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }

    public boolean isCastlingMove() {
        return this.castlingMoved;
    }

    public void setCastlingMove(boolean castlingMoved) {
        this.castlingMoved = castlingMoved;
    }

    public void setCanCastling(boolean castlingMoved) {
        this.castlingMoved = castlingMoved;
    }

    public Spot getStart() {
        return this.start;
    }

    public void setStart(Spot start) {
        this.start = start;
    }

    public Spot getEnd() {
        return this.end;
    }

    public void setEnd(Spot end) {
        this.end = end;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Piece getPieceMoved() {
        return this.pieceMoved;
    }

    public void setPieceMoved(Piece pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public Piece getPieceKilled() {
        return this.pieceKilled;
    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }
}
 