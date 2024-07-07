package util;

import java.util.Scanner;

public class Input {

    public static String inputText(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question + " ");
        return scanner.nextLine();
    }

    public static int inputNumber(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question + " ");
        return scanner.nextInt();
    }
}
