package util;

import bean.OrdinaryClient;
import data.Data;

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

    public static boolean accountExistence(String[] nameAndSurnameArr) {
        for (OrdinaryClient oc : Data.instance().getOrClnts()) {
            if (oc.getName().equalsIgnoreCase(nameAndSurnameArr[0])
                    && oc.getSurname().equalsIgnoreCase(nameAndSurnameArr[1])) {
                System.out.println("Bu ad və soyad ilə hesab artıq mövcuddur\n");
                return true;
            }
        }
        return false;
    }

    public static OrdinaryClient verifyLogin(String name, String surname, String cardPinCode) {
        OrdinaryClient orClnt = null;

        if (!Data.instance().getOrClnts().isEmpty()) {
            for (int i = 0; i < Data.instance().getOrClnts().size(); i++) {
                if (Data.instance().getOrClnts().get(i).getName().equalsIgnoreCase(name) &&
                        Data.instance().getOrClnts().get(i).getSurname().equalsIgnoreCase(surname)
                        && Data.instance().getOrClnts().get(i).getCardPinCode().equals(cardPinCode)) {
                    orClnt = Data.instance().getOrClnts().get(i);
                    break;
                }
            }
        }

        return orClnt;
    }
}
