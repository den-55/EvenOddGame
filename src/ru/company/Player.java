package ru.company;

public class Player {
    private String name;
    private int count = 0;
    private String answerInRockPaperScissors;
    private int bet;
    private String guess;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAnswerInRockPaperScissors() {
        return answerInRockPaperScissors;
    }

    public void setAnswerInRockPaperScissors(String answerInRockPaperScissors) {
        this.answerInRockPaperScissors = answerInRockPaperScissors;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }
}
