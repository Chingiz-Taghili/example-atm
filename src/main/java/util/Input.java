package util;

import java.util.Scanner;

public class Input {

    public static String text(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question + " ");
        return scanner.nextLine();
    }

    public static int number(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question + " ");
        int answer = 0;
        try {
            answer = scanner.nextInt();
        } catch (Exception ignored) {
        }
        return answer;
    }
}
