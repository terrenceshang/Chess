public class Knight extends Piece {
    
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    public boolean canMove(Board board, Spot start, Spot end) throws Exception {
        if (validMove(board, start, end)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validMove(Board board, Spot start, Spot end) throws Exception {
        int distX = Math.abs(start.getX() - end.getX());
        int distY = Math.abs(start.getY() - end.getY());
        
        if (distX*distY==2) {
            if  ( (end.getPiece().getIsWhite()!=this.getIsWhite()) ){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}