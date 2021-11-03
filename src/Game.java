import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        int playerScore = 0;
        int computerScore = 0;
        final int WINNINGSCORE = 100;
        do {
            if(playerTurn() == 0){
                playerScore = 0;
            } else {
                playerScore += playerTurn();
            }

            printScore(playerScore, computerScore);

            if(computerTurn() == 0){
                computerScore = 0;
            } else {
                computerScore += computerTurn();
            }

            printScore(playerScore, computerScore);

        } while(playerScore <WINNINGSCORE && computerScore < WINNINGSCORE);
        if(playerScore > WINNINGSCORE){
            System.out.println("Computer won!");
        }
        else if(computerScore > WINNINGSCORE){
            System.out.println("Player won!");
        }
        else if(playerScore == WINNINGSCORE){
            System.out.println("Player won!");
        } else {
            System.out.println("Computer won!");
        }

    }

    private static double generateChance() {
        double chance = Math.random();
        return chance;
    }

    private static int rollDice() {
        int die1 = (int)(Math.random()*6)+1;
        int die2 = (int)(Math.random()*6)+1;
        int sum;
        if(die1 == die2 && die1 == 1){
            sum = 0;
        } else if(die1 == 1 && die2 > 1|| die2 == 1 && die1 > 1){
            sum = 1;
        } else if(die1 == die2 && die1 != 1){
            sum = (die1 + die2) * 2;
        } else {
            sum = die1 + die2;
        }
        System.out.println("Dice: " + die1 + ", " + die2 + ". Score earned: " + sum);
        return sum;
    }
    private static int playerTurn(){
        Scanner Keyboard = new Scanner (System.in);
        int playerTurnScore = 0;
        int playerScore = 0;
        int WINNINGSCORE = 100;
        do {
            playerTurnScore = 0;
            System.out.println();
            System.out.println("Player, roll or hold?");
            String userChoice = Keyboard.nextLine();
            if (userChoice.equals("roll")) {
                playerTurnScore = rollDice();
                if (playerTurnScore == 0){
                    playerScore = 0;
                } else {
                    playerScore += playerTurnScore;
                }
            }
        } while (!(playerTurnScore == 0 || playerTurnScore == 1) && playerScore < WINNINGSCORE);
        System.out.println("Player turn, score earned in turn: " + playerScore);
        return playerScore;
    }
    private static void printScore(int playerScore, int computerScore){
        String score = "Score: Player - " + playerScore + " computer - " + computerScore;
        System.out.println(score);

    }
    private static int computerTurn(){
        int computerTurnScore;
        int computerScore = 0;
        int WINNINGSCORE = 100;
        do {
            computerTurnScore = 0;
            System.out.println();
            if (generateChance() >= 0.5) {
                computerTurnScore = rollDice();
                if(computerTurnScore == 0){
                    computerScore = 0;
                } else {
                    computerScore += computerTurnScore;
                }
            }
        } while (!(computerScore == 0 || computerTurnScore == 1) && computerScore < WINNINGSCORE);
        System.out.println("Computer turn, score earned in turn: " + computerScore);
        return computerScore;
    }

}
