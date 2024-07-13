package util;

import bean.Client;
import bean.OrdinaryClient;
import bean.Data;

public class Check {

    public static String[] nameAndSurname(String nameAndSurname) {
        String[] nameAndSurnameArr = nameAndSurname.split(" ");
        while (nameAndSurnameArr.length != 2) {
            nameAndSurname = Input.text("Ad və soyadı düzgün daxil edin!");
            nameAndSurnameArr = nameAndSurname.split(" ");
        }
        return nameAndSurnameArr;
    }

    public static String cardNumber(String cardNumber) {
        while (true) {
            boolean isDigit = true;

            for (char c : cardNumber.toCharArray()) {
                if (!Character.isDigit(c)) {
                    isDigit = false;
                    break;
                }
            }

            if (isDigit && cardNumber.length() == 8) {
                break;
            } else if (isDigit) {
                cardNumber = Input.text("Yalnız son 8 rəqəmi daxil edin!");
            } else {
                cardNumber = Input.text("Kart nömrəsi yalnız rəqəmlərdən ibarət olmalıdır!");
            }
        }
        return cardNumber;
    }

    public static String cardPinCode(String cardPinCode) {
        while (true) {
            boolean isDigit = true;

            for (char c : cardPinCode.toCharArray()) {
                if (!Character.isDigit(c)) {
                    isDigit = false;
                    break;
                }
            }

            if (isDigit && cardPinCode.length() == 4) {
                break;
            } else if (isDigit) {
                cardPinCode = Input.text("Pin kod 4 rəqəmdən ibarət olmalıdır!");
            } else {
                cardPinCode = Input.text("Pin kod yalnız rəqəmlərdən ibarət olmalıdır!");
            }
        }
        return cardPinCode;
    }

    public static int amount(String amount) {
        while (true) {
            boolean isDigit = true;

            for (char c : amount.toCharArray()) {
                if (!Character.isDigit(c)) {
                    isDigit = false;
                    break;
                }
            }

            if (isDigit && amount.length() <= 4) {
                break;
            } else if (isDigit) {
                amount = Input.text("Hər əməliyyat üçün maksimum limit: 9999 AZN");
            } else {
                amount = Input.text("Məbləği düzgün daxil edin!");
            }
        }
        return Integer.parseInt(amount);
    }

    public static boolean accountExistence(String[] nameAndSurnameArr) {
        for (Client cl : Data.instance().getClients()) {
            if (cl.getName().equalsIgnoreCase(nameAndSurnameArr[0])
                    && cl.getSurname().equalsIgnoreCase(nameAndSurnameArr[1])) {
                System.out.println("Bu ad və soyad ilə hesab artıq mövcuddur\n");
                return true;
            }
        }
        return false;
    }

    public static Client verifyLogin(String name, String surname, String cardPinCode) {
        Client client = null;

        if (!Data.instance().getClients().isEmpty()) {
            for (int i = 0; i < Data.instance().getClients().size(); i++) {
                if (Data.instance().getClients().get(i).getName().equalsIgnoreCase(name) &&
                        Data.instance().getClients().get(i).getSurname().equalsIgnoreCase(surname)
                        && Data.instance().getClients().get(i).getCardPinCode().equals(cardPinCode)) {
                    client = Data.instance().getClients().get(i);
                    break;
                }
            }
        }
        return client;
    }
}
