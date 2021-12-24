package ru.company.FirstMove;

import ru.company.EnteringInformation;
import ru.company.Game;
import ru.company.Player;
import ru.company.PrintString;

import java.util.Random;

public class RockPaperScissors extends Game {

    public static Player firstMove;
    public static Player secondMove;

    @Override
    public void playGame() {
        pause(2000);
        PrintString.charByChar("Отлично! Фишки заработаны!");
        pause(1500);
        System.out.println("");
        System.out.println("Теперь давай разыграем первый ход. Правила просты:\n" +
                "Введи слово камень, ножницы или бумага. Победитель определяется по следующим правилам:\n" +
                "* Камень побеждает ножницы (камень затупляет или ломает ножницы)\n" +
                "* Бумага побеждает камень (бумага накрывает камень)\n" +
                "* Ножницы побеждают бумагу (ножницы разрезают бумагу)\n" +
                "Начнём, и да прибудет с тобой удача)\n" +
                player.getName() + ", ходи!");
        System.out.print(player.getName() + ": ");
        player.setAnswerInRockPaperScissors(EnteringInformation.enteringStringInformation());
        while(!isRightObject(player.getAnswerInRockPaperScissors())) {
            System.out.println("Введи: камень, ножницы или бумага!");
            System.out.print(player.getName() + ": ");
            player.setAnswerInRockPaperScissors(EnteringInformation.enteringStringInformation());
        }
        cpu.setAnswerInRockPaperScissors(cpuMove());
        System.out.println(cpu.getName() + ": " + cpu.getAnswerInRockPaperScissors());
        whoIsWin(player, cpu);
    }

    private boolean isRightObject(String object) {
        if(object.equals("камень") || object.equals("ножницы") || object.equals("бумага")) {
            return true;
        }
        return false;
    }

    private String cpuMove() {
        int random = (int)(Math.random() * 3);
        if(random == 0) {
            return "камень";
        }
        if(random == 1) {
            return "ножницы";
        }
        return "бумага";
    }

    private void whoIsWin(Player player1, Player player2) {
        String player1Answer = player1.getAnswerInRockPaperScissors();
        String player2Answer = player2.getAnswerInRockPaperScissors();
        while(player1Answer.equals(player2Answer)) {
            System.out.println("Ничья! Играем ещё раз!");
            pause(2000);
            System.out.print(player1.getName() + ": ");
            player1Answer = EnteringInformation.enteringStringInformation();
            player1.setAnswerInRockPaperScissors(player1Answer);
            player2Answer = cpuMove();
            System.out.println(cpu.getName() + ": " + player2Answer);
            player2.setAnswerInRockPaperScissors(player2Answer);
        }
        if((player1Answer.equals("камень") && player2Answer.equals("ножницы")) || (player1Answer.equals("бумага") && player2Answer.equals("камень")) || (player1Answer.equals("ножницы") && player2Answer.equals("бумага"))) {
            System.out.println("");
            PrintString.charByChar(player1.getName() + " отлично! Ты начинаешь игру \"четное нечетное\"!\n");
            firstMove = player1;
            secondMove = player2;
        }else{
            System.out.println("");
            PrintString.charByChar("Игру \"четное нечетное\" начинает " + player2.getName());
            System.out.println("");
            firstMove = player2;
            secondMove = player1;
        }
    }


}
