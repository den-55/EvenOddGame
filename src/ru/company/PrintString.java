package ru.company;

public class PrintString {

    public static void charByChar(String str) {
        char[] strToChar = str.toCharArray();
        for (char c : strToChar) {
            System.out.print(c);
            try {
                Thread.sleep(35);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }
}
