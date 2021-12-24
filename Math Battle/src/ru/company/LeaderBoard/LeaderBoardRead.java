package ru.company.LeaderBoard;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class LeaderBoardRead implements Serializable {
    private static FileInputStream fis;
    private static ObjectInputStream ois;
    private static Map<Integer, String> map;

    public static Map<Integer, String> readLeaderBoard() {
        try {
            fis = new FileInputStream("Leaderboard.txt");
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            LeaderBoardTable.setLeaderBoard((TreeMap<Integer, String>) ois.readObject());
            ois.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
