public class Driver {
    public static void main(String[] args) {
        int[] gameValues = {5, 10, 8, 10, 7, 5, 9, 10, 6, 7, 10, 6, 5, 8, 9, 5, 10, 5, 9, 6, 8, 7, 10, 6, 8};
        DoublyLinkedBoardGame boardGame = new DoublyLinkedBoardGame();
        boardGame.createBoard(gameValues);
        DoublyLinkedBoardGame.Player playerA = boardGame.new Player("A");
        DoublyLinkedBoardGame.Player playerB = boardGame.new Player("B");
        DoublyLinkedBoardGame.Player playerC = boardGame.new Player("C");
        DoublyLinkedBoardGame.Player playerD = boardGame.new Player("D");
        
        
        //SINGLE PLAYER
        System.out.println("SINGLE PLAYER ROUNDS");
        DoublyLinkedBoardGame.Player[] playerArray1 = {playerA};
        int numTimesWonA1 = 0;
        int avgTurnsA1 = 0;
        for (int i = 1; i < 1001; i++) {
            DoublyLinkedBoardGame.Player gameWinner = boardGame.playGame(playerArray1);
            if (gameWinner == playerA) {
                numTimesWonA1++;
                avgTurnsA1 += playerA.getnumTurns();
            }
            if (i % 100 == 1) {
                System.out.println("Round: " + i);
                boardGame.printBoard();
            }
            boardGame.reset();
            playerA.reset();
        }
        System.out.println();

        //TWO PLAYER
        System.out.println("TWO PLAYER ROUNDS");
        DoublyLinkedBoardGame.Player[] playerArray2 = {playerA, playerB};
        int numTimesWonA2 = 0;
        int numTimesWonB2 = 0;
        int avgTurnsA2 = 0;
        int avgTurnsB2 = 0;
        for (int i = 1; i < 1001; i++) {
            DoublyLinkedBoardGame.Player gameWinner = boardGame.playGame(playerArray2);
            if (gameWinner == playerA) {
                numTimesWonA2++;
                avgTurnsA2 += playerA.getnumTurns();
            }
            if (gameWinner == playerB) {
                numTimesWonB2++;
                avgTurnsB2 += playerB.getnumTurns();
            }
            if (i % 100 == 1) {
                System.out.println("Round: " + i);
                boardGame.printBoard();
            }
            boardGame.reset();
            playerA.reset();
            playerB.reset();
        }
        System.out.println();
        
        //THREE PLAYER
        System.out.println("THREE PLAYER ROUNDS");
        DoublyLinkedBoardGame.Player[] playerArray3 = {playerA, playerB, playerC};
        int numTimesWonA3 = 0;
        int numTimesWonB3 = 0;
        int numTimesWonC3 = 0;
        int avgTurnsA3 = 0;
        int avgTurnsB3 = 0;
        int avgTurnsC3 = 0;
        for (int i = 1; i < 1001; i++) {
            DoublyLinkedBoardGame.Player gameWinner = boardGame.playGame(playerArray3);
            if (gameWinner == playerA) {
                numTimesWonA3++;
                avgTurnsA3 += playerA.getnumTurns();
            }
            if (gameWinner == playerB) {
                numTimesWonB3++;
                avgTurnsB3 += playerB.getnumTurns();
            }
            if (gameWinner == playerC) {
                numTimesWonC3++;
                avgTurnsC3 += playerC.getnumTurns();
            }
            if (i % 100 == 1) {
                System.out.println("Round: " + i);
                boardGame.printBoard();
            }
            boardGame.reset();
            playerA.reset();
            playerB.reset();
            playerC.reset();
        }
        System.out.println();
        

        //FOUR PLAYER
        System.out.println("FOUR PLAYER ROUNDS");
        DoublyLinkedBoardGame.Player[] playerArray4 = {playerA, playerB, playerC, playerD};
        int numTimesWonA4 = 0;
        int numTimesWonB4 = 0;
        int numTimesWonC4 = 0;
        int numTimesWonD4 = 0;
        int avgTurnsA4 = 0;
        int avgTurnsB4 = 0;
        int avgTurnsC4 = 0;
        int avgTurnsD4 = 0;
        for (int i = 1; i < 1001; i++) {
            DoublyLinkedBoardGame.Player gameWinner = boardGame.playGame(playerArray4);
            if (gameWinner == playerA) {
                numTimesWonA4++;
                avgTurnsA4 += playerA.getnumTurns();
            }
            if (gameWinner == playerB) {
                numTimesWonB4++;
                avgTurnsB4 += playerB.getnumTurns();
            }
            if (gameWinner == playerC) {
                numTimesWonC4++;
                avgTurnsC4 += playerC.getnumTurns();
            }
            if (gameWinner == playerD) {
                numTimesWonD4++;
                avgTurnsD4 += playerD.getnumTurns();
            }
            if (i % 100 == 1) {
                System.out.println("Round: " + i);
                boardGame.printBoard();
            }
            boardGame.reset();
            playerA.reset();
            playerB.reset();
            playerC.reset();
            playerD.reset();
        }
        System.out.println();

        //Print Results Table
        System.out.println("| Player in Game | pA Moves/AVG % W | pB Moves/AVG % W | pC Moves/AVG % W| pD Moves/AVG % W |");
        System.out.println("| A              | " + average(avgTurnsA1, numTimesWonA1) + "/" + percent(numTimesWonA1, 1000.0) + "%          |                  |                 |                  |");
        System.out.println("| A,B            | " + average(avgTurnsA2, numTimesWonA2) + "/" + percent(numTimesWonA2, 1000.0) + "%           |" + average(avgTurnsB2, numTimesWonB2) + "/" + percent(numTimesWonB2, 1000.0) + "%            |                 |                  |");
        System.out.println("| A,B,C          | " + average(avgTurnsA3, numTimesWonA3) + "/" + percent(numTimesWonA3, 1000.0) + "%           |" + average(avgTurnsB3, numTimesWonB3) + "/" + percent(numTimesWonB3, 1000.0) + "%            |" + average(avgTurnsC3, numTimesWonC3) + "/" + percent(numTimesWonC3, 1000.0) + "%           |                  |");
        System.out.println("| A,B,C,D        | " + average(avgTurnsA4, numTimesWonA4) + "/" + percent(numTimesWonA4, 1000.0) + "%           |" + average(avgTurnsB4, numTimesWonB4) + "/" + percent(numTimesWonB4, 1000.0) + "%            |" + average(avgTurnsC4, numTimesWonC4) + "/" + percent(numTimesWonC4, 1000.0) + "%           |" + average(avgTurnsD4, numTimesWonD4) + "/" + percent(numTimesWonD4, 1000.0) + "%            |");
    }

    public static int average (int sum, int numTimes) {
        return (sum / numTimes);
    }

    public static int percent (int part, double whole) {
        return (int)((part / whole) * 100);
    }
}
