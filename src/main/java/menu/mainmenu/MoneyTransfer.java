package menu.mainmenu;

import bean.Client;
import bean.Data;
import menu.mainmenu.inter.MoneyTransferInter;
import util.Check;
import util.File;
import util.Input;

public class MoneyTransfer implements MoneyTransferInter {

    public void process(Client client) {
        if (client.getCardBalance() <= 0) {
            System.out.println("Balansınızda vəsait yoxdur! Balansı artırın və yenidən cəhd edin!\n");
            return;
        }

        int select = Input.number("1. Bank daxili hesaba köçür" +
                "\n2. Başqa bankın hesabına köçür");

        if (select == 1) {
            internalTransfer(client);
        } else if (select == 2) {
            externalTransfer(client);
        } else {
            System.out.println("Menyunu düzgün daxil edin!\n");
        }
    }

    private void internalTransfer(Client client) {
        Data database = (Data) File.readObject("Database.obj");
        if (database.getClients().size() > 1) {
            for (Client clnt : database.getClients()) {
                if (clnt == client) {
                    continue;
                }
                System.out.println(clnt);
            }

            String cardNumber = Check.cardNumber(Input.text(
                    "Köçürmək istədiyiniz hesabın son 8 rəqəmini daxil edin"));

            for (Client cl : database.getClients()) {
                if (cl.getCardNumber() == Integer.parseInt(cardNumber)) {
                    int amount = Check.amount(Input.text("Köçürüləcək məbləği daxil edin"
                            + " (Balans: " + client.getCardBalance() + " AZN)"));

                    while (amount > client.getCardBalance()) {
                        amount = Check.amount(Input.text("Köçürə biləcəyiniz maksimum məbləğ: "
                                + client.getCardBalance() + " AZN"));
                    }
                    client.minusCardBalance(amount);
                    cl.plusCardBalance(amount);

                    if (client.isPremium()) {
                        int cashback = amount * 5 / 100;
                        client.plusCardBalance(cashback);
                        System.out.println(amount + " AZN " + cl.getName() + " " +
                                cl.getSurname() + " adlı hesaba köçürüldü!" +
                                "\nVə " + cashback + " AZN cashback balansınıza yükləndi!\n");
                    } else {
                        System.out.println(amount + " AZN " + cl.getName() + " " +
                                cl.getSurname() + " adlı hesaba köçürüldü!\n");
                    }
                    File.writeObject(Data.instance(), "Database.obj");
                    return;
                }
            }
            System.out.println("Daxil etdiyiniz hesab tapılmadı!\n");
        } else {
            System.out.println("Pul köçürə biləcəyiniz bank daxili hesab yoxdur!\n");
        }
    }

    private void externalTransfer(Client client) {

        String cardNumber = Check.cardNumber(Input.text(
                "Köçürüləcək kart nömrəsinin son 8 rəqəmini daxil edin"));

        int amount = Check.amount(Input.text("Köçürüləcək məbləği daxil edin" +
                " (Balans: " + client.getCardBalance() + " AZN)"));
        while (amount > client.getCardBalance()) {
            amount = Check.amount(Input.text("Köçürə biləcəyiniz maksimum məbləğ: "
                    + client.getCardBalance() + " AZN"));
        }

        client.minusCardBalance(amount);
        File.writeObject(Data.instance(), "Database.obj");
        System.out.println(amount + " AZN məbləğ ********" + cardNumber + " nömrəli karta köçürüldü!\n");
    }
}

