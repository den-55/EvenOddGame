package ru.company;

import ru.company.Math.Examples;

public class Game {

    protected static Player player;
    protected static Player cpu;
    protected static Examples example;
    protected static int playerCount;
    protected static int cpuCount;

    public Examples getExample() {
        return example;
    }

    protected void initialization() {
        System.out.println("Приветствую тебя игрок! Давай сыграем в игру \"четное нечетное\"! Как тебя зовут?");
        String playerName = EnteringInformation.enteringStringInformation();
        while (playerName.isEmpty()) {
            System.out.println("Введи имя!");
            playerName = EnteringInformation.enteringStringInformation();
        }
        player = new Player(playerName);
        playerCount = player.getCount();
        System.out.println("Придумай имя сопернику:");
        String cpuName = EnteringInformation.enteringStringInformation();
        while (cpuName.isEmpty()) {
            System.out.println("Введи имя!");
            cpuName = EnteringInformation.enteringStringInformation();
        }
        cpu = new Player(cpuName);
        cpuCount = cpu.getCount();
    }

    protected void difficultyLevel() {
        System.out.println(player.getName() + ", выбери уровень сложности:\n" +
                "1 - простой\n" +
                "2 - средний\n" +
                "3 - сложный");
        int difficultyLevel = EnteringInformation.enteringIntegerInformation();
        example = new Examples(difficultyLevel);
    }

    protected void rules() {
        System.out.println("Правила игры:\n" +
                "У каждого игрока есть определенное количество фишек (их мы определим, сыграя в викторину \"Математический батл\"). \n" +
                "Игроки ставят какое-то количество фишек. \n" +
                "Далее один из игроков (кто первый ходит мы определим, сыграя в \"камень, ножницы, бумага\") угадывает четное или нечетное количество фишек поставил его соперник. \n" +
                "Если он угадывает, забирает ставку своего соперника (но не более своей ставки). Если нет отдает свою ставку (но не более ставки соперника). \n" +
                "Всё понятно? Жмакай Enter и начнём!");
        String answer = EnteringInformation.enteringStringInformation();
        resumeGame(answer);
    }

    protected void resumeGame(String s) {
        while (!s.isEmpty()) {
            System.out.println("Неизвестная команда. Нажми Enter!");
            s = EnteringInformation.enteringStringInformation();
        }
    }

    public void playGame() {
        initialization();
        difficultyLevel();
        rules();
    }

    protected void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
