import java.util.Scanner;

public class Chess {
    public static void main (String args[]) throws NumberFormatException, Exception {
        Scanner scanner = new Scanner(System.in);
        HumanPlayer p1 = new HumanPlayer(true);
        HumanPlayer p2 = new HumanPlayer(false);
        Game game = new Game(p1, p2);

        System.out.println("type startX, startY, endX, endY seperated by a space");
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");
        if (game.getCurrentTurn() == p1) {
            game.playerMove(p1, Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3]));
        } else {
            game.playerMove(p2, Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3]));
        }
        
        scanner.close();
    }
}
