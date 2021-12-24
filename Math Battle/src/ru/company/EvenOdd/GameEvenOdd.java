package ru.company.EvenOdd;

import ru.company.FirstMove.RockPaperScissors;
import ru.company.Game;
import ru.company.EnteringInformation;
import ru.company.LeaderBoard.LeaderBoardTable;
import ru.company.Player;
import ru.company.PrintString;

public class GameEvenOdd extends Game {
    private Player firstMovePlayer = RockPaperScissors.firstMove;
    private Player secondMovePlayer = RockPaperScissors.secondMove;

    @Override
    public void playGame() {
        while (player.getCount() > 0 && cpu.getCount() > 0) {
            playerBet();
            cpuBet();
            playRound();
        }
        pause(2000);
        System.out.println("");
        PrintString.charByChar("*************************************!!!ИГРА ЗАКОНЧЕНА!!!*************************************");
        System.out.println("");
        PrintString.charByChar(getWinner().getName() + ", поздравляем! Ты выиграл игру! Твой баланс: " + getWinner().getCount() + " фишек!\n");
        LeaderBoardTable.putLeaderBoard();
        PrintString.charByChar("Вывести рейтинг победителей?");
        String answer = EnteringInformation.enteringStringInformation();
        while(!answer.equals("да") && !answer.equals("нет")) {
            System.out.println("Введи да или нет!");
            answer = EnteringInformation.enteringStringInformation();
        }
        if(answer.equals("да")) {
            LeaderBoardTable.printLeaderBoard();
        }
    }

    public static Player getWinner() {
        if(player.getCount() > cpu.getCount()) {
            return player;
        }
        return cpu;
    }

    private void cpuBet() {
        int cpuBet = getCpuBet(cpu.getCount());
        cpu.setBet(cpuBet);
        cpu.setCount(cpu.getCount() - cpuBet);
        PrintString.charByChar(cpu.getName() + " сделал ставку.");
    }

    public void playerBet() {
        int playerCount = player.getCount();
        PrintString.charByChar(player.getName() + " твой баланс: " + player.getCount());
        PrintString.charByChar(player.getName() + " делай ставку.");
        player.setBet(EnteringInformation.enteringIntegerInformation());
        while (player.getBet() > playerCount || player.getBet() == 0 || player.getBet() < 0) {
            if (player.getBet() > playerCount) {
                PrintString.charByChar(player.getName() + ", ставка больше количества твоих фишек!\n" +
                        "твой баланс " + playerCount);
                player.setBet(EnteringInformation.enteringIntegerInformation());
            }
            if (player.getBet() == 0) {
                PrintString.charByChar(player.getName() + ", нужно сделать ставку!\n" +
                        "твой баланс " + playerCount);
                player.setBet(EnteringInformation.enteringIntegerInformation());
            }
            if (player.getBet() < 0) {
                PrintString.charByChar(player.getName() + ", ставка не может быть отрицательная!\n" +
                        "твой баланс " + playerCount);
                player.setBet(EnteringInformation.enteringIntegerInformation());
            }
        }
        player.setCount(player.getCount() - player.getBet());
    }

    private int getCpuBet(int maxValue) {
        return ((int) (Math.random() * maxValue) + 1);
    }

    private String getCpuGuess() {
        if ((int) (Math.random() * 2) == 0) {
            return "четное";
        }
        return "нечетное";
    }

    private boolean isWin(String guess, int bet) {
        if ((bet % 2 == 0 && guess.equals("четное")) || (bet % 2 != 0 && guess.equals("нечетное"))) {
            return true;
        }
        return false;
    }

    private int getBenefit(int bet1, int bet2) {
        return bet1 >= bet2 ? bet2 : bet1;
    }

    private void playRound() {
        PrintString.charByChar(firstMovePlayer.getName() + " четное или нечетное?");
        if (firstMovePlayer.getName().equals(player.getName())) {
            player.setGuess(EnteringInformation.enteringStringInformation());
            while (!player.getGuess().equals("четное") && !player.getGuess().equals("нечетное")) {
                PrintString.charByChar("Введи: четное или нечетное!");
                player.setGuess(EnteringInformation.enteringStringInformation());
            }
        } else {
            cpu.setGuess(getCpuGuess());
            pause(1000);
            PrintString.charByChar(firstMovePlayer.getName() + " сделал предположение!");
        }
        PrintString.charByChar(firstMovePlayer.getName() + " сделал ставку " + firstMovePlayer.getBet() + " фишек и предполагает, что " + secondMovePlayer.getName() + " поставил " + firstMovePlayer.getGuess() + " количество фишек.\n" +
                secondMovePlayer.getName() + " твоя ставка: " + secondMovePlayer.getBet());
        if (isWin(firstMovePlayer.getGuess(), secondMovePlayer.getBet())) {
            int wonChips = getBenefit(firstMovePlayer.getBet(), secondMovePlayer.getBet());
            PrintString.charByChar(firstMovePlayer.getName() + " угадал! Его выигрыш " + wonChips + " фишки!");
            firstMovePlayer.setCount(firstMovePlayer.getCount() + wonChips + firstMovePlayer.getBet());
            if (secondMovePlayer.getBet() > firstMovePlayer.getBet()) {
                secondMovePlayer.setCount(secondMovePlayer.getCount() + secondMovePlayer.getBet() - firstMovePlayer.getBet());
            }
        } else {
            int wonChips = getBenefit(firstMovePlayer.getBet(), secondMovePlayer.getBet());
            PrintString.charByChar(firstMovePlayer.getName() + " не угадал! " + secondMovePlayer.getName() + " забирает " + wonChips + " фишки!");
            secondMovePlayer.setCount(secondMovePlayer.getCount() + wonChips + secondMovePlayer.getBet());
            if (firstMovePlayer.getBet() > secondMovePlayer.getBet()) {
                firstMovePlayer.setCount(firstMovePlayer.getCount() + firstMovePlayer.getBet() - secondMovePlayer.getBet());
            }
        }
        Player reverse = firstMovePlayer;
        firstMovePlayer = secondMovePlayer;
        secondMovePlayer = reverse;
    }

}