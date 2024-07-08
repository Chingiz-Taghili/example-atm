package menu.mainmenu;

import bean.OrdinaryClient;
import data.Data;
import menu.mainmenu.inter.MoneyTransferInter;
import util.Check;
import util.Input;

public class MoneyTransfer implements MoneyTransferInter {

    public void process(OrdinaryClient orClnt) {
        if (orClnt.getCardBalance() <= 0) {
            System.out.println("Balansınızda vəsait yoxdur! Balansı artırın və yenidən cəhd edin!\n");
            return;
        }

        int select = Input.number("1. Bank daxili hesaba köçür" +
                "\n2. Başqa bankın hesabına köçür");

        if (select == 1) {
            internalTransfer(orClnt);
        } else if (select == 2) {
            externalTransfer(orClnt);
        } else {
            System.out.println("Menyunu düzgün daxil edin!\n");
        }
    }

    private void internalTransfer(OrdinaryClient orClnt) {
        if (Data.instance().getOrClnts().size() > 1) {
            for (OrdinaryClient oCl : Data.instance().getOrClnts()) {
                if (oCl == orClnt) {
                    continue;
                }
                System.out.println(oCl);
            }

            String cardNumber = Check.cardNumber(Input.text(
                    "Köçürmək istədiyiniz hesabın son 8 rəqəmini daxil edin"));

            for (OrdinaryClient oCl : Data.instance().getOrClnts()) {
                if (oCl.getCardNumber().endsWith(cardNumber)) {
                    int amount = Check.amount(Input.text("Köçürüləcək məbləği daxil edin"
                            + " (Balansınız: " + orClnt.getCardBalance() + " AZN)"));

                    while (amount > orClnt.getCardBalance()) {
                        amount = Check.amount(Input.text("Köçürə biləcəyiniz maksimum məbləğ: "
                                + orClnt.getCardBalance() + " AZN"));
                    }
                    orClnt.minusCardBalance(amount);
                    oCl.plusCardBalance(amount);
                    System.out.println(amount + " AZN " + oCl.getName() + " " + oCl.getSurname() + " adlı hesaba köçürüldü!\n");
                    return;
                } else {
                    System.out.println("Daxil etdiyiniz hesab tapılmadı!\n");
                }
            }
        } else {
            System.out.println("Pul köçürə biləcəyiniz bank daxili hesab yoxdur!\n");
        }
    }

    private void externalTransfer(OrdinaryClient orClnt) {
        Input.text("Köçürüləcək kartın 16 rəqəmli nömrəsini daxil edin");
        int amount = Check.amount(Input.text("Köçürüləcək məbləği daxil edin" +
                " (Balansınız: " + orClnt.getCardBalance() + " AZN)"));
        while (amount > orClnt.getCardBalance()) {
            amount = Check.amount(Input.text("Köçürə biləcəyiniz maksimum məbləğ: "
                    + orClnt.getCardBalance() + " AZN"));
        }

        orClnt.minusCardBalance(amount);
        System.out.println(amount + " AZN məbləğ daxil etdiyiniz karta köçürüldü!\n");
    }
}

