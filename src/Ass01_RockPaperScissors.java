import java.util.Scanner;

public class Ass01_RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Player A, enter your move (R/P/S): ");
            String playerAMove = getValidMove(scanner);

            System.out.println("Player B, enter your move (R/P/S): ");
            String playerBMove = getValidMove(scanner);

            String result = getWinner(playerAMove, playerBMove);
            System.out.println(result);

            System.out.println("Do you want to play again? (Y/N): ");
            String playAgain = scanner.next().trim().toLowerCase();
            if (!playAgain.equals("y")) {
                break;
            }
        }
        scanner.close();
    }

    public static String getValidMove(Scanner scanner) {
        while (true) {
            String move = scanner.next().trim().toLowerCase();
            if (move.equals("r") || move.equals("p") || move.equals("s")) {
                return move;
            } else {
                System.out.println("Invalid move. Please choose R, P, or S.");
            }
        }
    }

    public static String getWinner(String playerAMove, String playerBMove) {
        if (playerAMove.equals(playerBMove)) {
            if(playerAMove.equals("r")){
                return "Rock vs Rock it's a Tie!";
            }
            else if(playerAMove.equals("p")){
                return "Paper vs Paper it's a Tie!";
            }
            else{
                return "Scissors vs Scissors it's a Tie!";
            }
        } else if ((playerAMove.equals("r") && playerBMove.equals("s")) ||
                (playerAMove.equals("s") && playerBMove.equals("p")) ||
                (playerAMove.equals("p") && playerBMove.equals("r"))) {
            return getPhrase(playerAMove, playerBMove) + ". Player A wins!";
        } else {
            return getPhrase(playerBMove, playerAMove) + ". Player B wins!";
        }
    }

    public static String getPhrase(String winningMove, String losingMove) {
        if ((winningMove.equals("r") && losingMove.equals("s")) ||
                (winningMove.equals("s") && losingMove.equals("r"))) {
            return "Rock breaks Scissors";
        } else if ((winningMove.equals("p") && losingMove.equals("r")) ||
                (winningMove.equals("r") && losingMove.equals("p"))) {
            return "Paper covers Rock";
        } else {
            return "Scissors cuts Paper";
        }
    }
}
