public class Bishop extends Piece {
        
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    public boolean canMove(Board board, Spot start, Spot end) throws Exception {
        if ((validMove(board, start, end)) && (isBlocked(board, start, end)==false)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validMove(Board board, Spot start, Spot end) throws Exception {
        int distX = Math.abs(start.getX() - end.getX());
        int distY = Math.abs(start.getY() - end.getY());
        
        if (distX/distY==1) {
            if  ( (end.getPiece().getIsWhite()!=this.getIsWhite()) && (isBlocked(board, start, end)==false) ){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isBlocked (Board board, Spot start, Spot end) throws Exception { //Check if there are any blockers
        int distX = Math.abs(start.getX() - end.getX());
        int distY = Math.abs(start.getY() - end.getY());
        int xSign = 0;
        int ySign = 0;

        if (distX == 0) { // finding the direction of the move
            ySign = (end.getY() - start.getY()) / distY;
        } else if (distY == 0) {
            xSign = (end.getX() - start.getX()) / distX;
        } else {
            xSign = (end.getX() - start.getX()) / distX;
            ySign = (end.getY() - start.getY()) / distY;
        }

        if (distX/distY==1) { // if the move is diagonal
            for (int i = 0; i < distX; i++) {
                Spot tempSpot = board.getBox(start.getX()+xSign*i, start.getY()+ySign*i);
                if (tempSpot.getPiece().getIsWhite() == null) {
                    continue;
                } else {
                    return true;
                }
            }
            return false;
        } 
        else {
            return true;
        }
    }
}
