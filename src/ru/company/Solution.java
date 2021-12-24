package ru.company;

import ru.company.EvenOdd.GameEvenOdd;
import ru.company.FirstMove.RockPaperScissors;
import ru.company.Math.GameMath;

public class Solution {
    Game game;
    Game gameMath;
    Game gameRockPaperScissors;
    Game gameEvenOdd;

    public void startGame() {
        game = new Game();
        gameMath = new GameMath();
        gameRockPaperScissors = new RockPaperScissors();

        game.playGame();
        gameMath.playGame();
        gameRockPaperScissors.playGame();
        gameEvenOdd = new GameEvenOdd();
        gameEvenOdd.playGame();
    }

}
