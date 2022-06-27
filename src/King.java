public class King extends Piece {
    
    public boolean canCastling;

    public King(boolean isWhite) {
        super(isWhite);
        this.canCastling = true;
    }

    public void setCanCastling() {
        this.canCastling = true;
    }

    public boolean getCanCastling() {
        return this.canCastling;
    }

    @Override
    //************************************************************
    //Still need to add what if the king is at check at Spot end
    //Castling
    public boolean canMove(Board board, Spot start, Spot end) {

        if (validMove(board, start, end)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validMove(Board board, Spot start, Spot end) {
        int distX = Math.abs(start.getX() - end.getX());
        int distY = Math.abs(start.getY() - end.getY());
        
        if ( (distX+distY==1) || ((distX==1)&&(distY==1))) {
            if  (end.getPiece().getIsWhite()!=this.getIsWhite()) {
                canCastling = false;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
