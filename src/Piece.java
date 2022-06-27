public abstract class Piece {
    private Boolean iskilled;
    private Boolean isWhite;
    public boolean isCastlingMove;

    public Piece(Boolean isWhite) {
        this.iskilled = false;
        this.isWhite = isWhite;
    }

    public Boolean getIsWhite() {
        return this.isWhite;
    }

    public void setIsWhite(Boolean isWhite) {
        this.isWhite = isWhite;
    }

    public Boolean getIsKilled() {
        return this.iskilled;
    }

    public void setIsKilled(boolean isKilled) {
        this.iskilled = isKilled;
    }

    public abstract boolean canMove(Board board, Spot start, Spot end) throws Exception;
}
