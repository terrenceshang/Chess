public class Pawn extends Piece {
    private boolean firstMove;

    public Pawn(boolean isWhite) {
        super(isWhite);
        this.firstMove = true;
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
        int distY = start.getY() - end.getY();

        if (distX==1 && distY==1) {
            if (end.getPiece().getIsWhite()!=this.getIsWhite()) {
                return true;
            } else {
                return false;
            }
        }
        else if (distX==0 && distY == 1) {
            if (end.getPiece().getIsWhite() == null) {
                return true;
            } else {
                return false;
            }
        }
        if ((distX == 0) && (distY == 2) && (firstMove==true)) {
            Boolean temp = board.getBox(start.getX(), (start.getY()+end.getY())/2 ).getPiece().getIsWhite();
            if  ( (end.getPiece().getIsWhite()==null) && (temp == null )){
                return true;
            } else {
                return false;
            }
        } 
        else {
            return false;
        }
    }
}
