# Project 2: Board Game
This project determines the probability of a player winning a board game.  The program will output the average number of moves necessary for one of the players to “win” the game for 1, 2, 3, and 4 players.

# Game Rules

<img width="416" alt="Screenshot 2024-08-12 at 5 50 55 PM" src="https://github.com/user-attachments/assets/93df3517-50c8-48af-a053-fe0335d190bc">

A player begins the game on the Start circle. The current player rolls a dice, that gives a number from 1 to 6. The current player moves that many colored blocks from the current player’s position. If the square is unoccupied, then the current player adds the number on the square to the player’s total. Also, If the square already has a previous player on it, the previous player has to go back to the Start square and the players score is set to zero..  A player must reach END with an exact roll. For example, a player on the last 10 must roll a 3 to get to the end. If the roll is bigger than the spaces needed to END, the players loses their turn.

# Output
The Driver class will print the game board for every 100th game at the end of the game, so one can see the final position of each player. For example:

```bash
Round: 701
[Start[ ]][ ][A][ ][ ][ ][ ][ ][ ][ ]
          [ ][ ][ ][ ][ ][ ][ ]
          [ ][ ][ ][C][ ][ ][B][ ][ ][End[D]]
```
At the end it will output the average number of moves it took the players to win after playing 1000 games.

```bash
| Player in Game | pA Moves/AVG % W | pB Moves/AVG % W | pC Moves/AVG % W| pD Moves/AVG % W |
| A              | 14/100%          |                  |                 |                  |
| A,B            | 13/46%           |12/53%            |                 |                  |
| A,B,C          | 12/33%           |12/33%            |12/32%           |                  |
| A,B,C,D        | 11/21%           |11/26%            |11/26%           |12/24%            |
```
