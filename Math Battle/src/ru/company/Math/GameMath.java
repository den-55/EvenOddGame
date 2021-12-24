package ru.company.Math;

import ru.company.EnteringInformation;
import ru.company.Game;
import ru.company.PrintString;

import static java.lang.Integer.parseInt;

public class GameMath extends Game {

    @Override
    public void playGame() {
        System.out.println(player.getName() + ", давай заработаем с тобой фишек, для этого сыграем в викторину \"Математический батл\". Цель игры решить как можно больше примеров за 20 секунд.\n" +
                "За правильно решенный пример даётся 1 бал (1 балл = 1 фишка).\n" +
                "В консоле будут появляться примеры, вводи свои ответы\n" +
                "Как будешь готов, жми Enter");
        playerPlay();
        cpuPlay();
    }

    private String howManyPoints(int i) {
        if(i == 1 || i == 21 || i == 31) {
            return " поздравляю! Ты набрал " + i + " балл.\n";
        }
        if(i > 1 && i < 5) {
            return " поздравляю! Ты набрал " + i + " балла.\n";
        }
        return " поздравляю! Ты набрал " + i + " баллов.\n";
    }

    private static int cpuMistake() {
        if((Math.random() * 10) < 3.0) {
            return 1;
        }
        return 0;
    }

    private void playerPlay() {
        resumeGame(EnteringInformation.enteringStringInformation());
        long currentTime = System.currentTimeMillis();
        long endTime = currentTime + 10000;
        while (System.currentTimeMillis() < endTime) {
            int rightAnswer = example.exampleGenerator();
            int playerAnswer = EnteringInformation.enteringIntegerInformation();
            if (playerAnswer == rightAnswer) {
                playerCount++;
                player.setCount(playerCount);
            }
        }
        System.out.println(player.getName() + howManyPoints(player.getCount()));
        System.out.println("Теперь давай посмотрим как справится " + cpu.getName() +
                ", жми Enter!");
        resumeGame(EnteringInformation.enteringStringInformation());
    }

    private void cpuPlay() {;
        long currentTime = System.currentTimeMillis();
        long endTime = currentTime + 10000;
        while (System.currentTimeMillis() < endTime) {
            int rightAnswer = example.exampleGenerator();
            int cpuAnswer = rightAnswer + cpuMistake();
            pause(1000);
            System.out.println(cpuAnswer);
            pause(500);
            if (cpuAnswer == rightAnswer) {
                cpuCount++;
                cpu.setCount(cpuCount);
            }
        }
        System.out.println(cpu.getName() + howManyPoints(cpu.getCount()));
    }
}
