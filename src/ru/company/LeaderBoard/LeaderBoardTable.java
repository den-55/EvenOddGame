package ru.company.LeaderBoard;

import ru.company.EvenOdd.GameEvenOdd;
import ru.company.Player;

import java.util.Map;
import java.util.TreeMap;

public class LeaderBoardTable {
    private static Map<Integer, String> leaderBoard = new TreeMap<>();
    private static Player winner = GameEvenOdd.getWinner();

    public static Map<Integer, String> getLeaderBoard() {
        return leaderBoard;
    }

    public static void setLeaderBoard(Map<Integer, String> leaderBoard) {
        LeaderBoardTable.leaderBoard = leaderBoard;
    }

    private static String playerCountInfo() {
        return winner.getName() + draw(winner.getName().length()) + winner.getCount();
    }

    public static void putLeaderBoard() {
        LeaderBoardRead.readLeaderBoard();
        leaderBoard.put(winner.getCount(), playerCountInfo());
        LeaderBordWrite.writePlayer(leaderBoard);
    }

    public static void printLeaderBoard() {
        int count = leaderBoard.size();
        for (Map.Entry entry : leaderBoard.entrySet()) {
            System.out.println(count + ". " + entry.getValue());
            count--;
        }
    }

    public static String draw(int nameLength) {
        int stringLength = 50 - nameLength;
        String result = "";
        for (int i = 0; i <= stringLength; i++) {
            result += "-";
        }
        return result;
    }
}
