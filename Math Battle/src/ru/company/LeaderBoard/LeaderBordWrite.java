package ru.company.LeaderBoard;

import java.io.*;
import java.util.Map;

public class LeaderBordWrite implements Serializable {

    private static FileOutputStream fos;
    private static ObjectOutputStream oos;

    public static void writePlayer(Map<Integer,String> map) {
        try {
            fos = new FileOutputStream("Leaderboard.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
