package ru.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class EnteringInformation {
    public static String enteringStringInformation() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = "";
        try {
            string = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static Integer enteringIntegerInformation() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer i = 0;
        try {
            i = parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }
}
