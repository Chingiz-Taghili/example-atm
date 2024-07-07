package util;

import bean.OrdinaryClient;
import data.Data;
import menu.loginmenu.ExitProgram;
import menu.loginmenu.LoginAccount;
import menu.loginmenu.RegisterAccount;
import menu.mainmenu.*;

public class Menu {

    public static void menuProcess() {
        while (true) {
            loginMenuProcess();
        }
    }

    public static int showLoginMenu() {
        int menu = Input.inputNumber(
                "1. Hesaba daxil ol" +
                        "\n2. Qeydiyyatdan keç" +
                        "\n3. Çıxış");
        return menu;
    }

    public static void loginMenuProcess() {
        int menu = showLoginMenu();
        if (menu == 1) {
            LoginAccount.process();
        } else if (menu == 2) {
            RegisterAccount.process();
        } else if (menu == 3) {
            ExitProgram.process();
        }
    }

    public static int showMainMenu() {
        int menu = Input.inputNumber(
                "1. Balansa bax" +
                        "\n2. Balansı artır" +
                        "\n3. Pul nağdlaşdır" +
                        "\n4. Köçürmə et" +
                        "\n5. Hesabdan çıx");
        return menu;
    }

    public static void mainMenuProcess(OrdinaryClient orClnt) {
        while (true) {
            int menu = showMainMenu();
            if (menu == 1) {
                CheckBalance.process(orClnt);
            } else if (menu == 2) {
                PlusBalance.process(orClnt);
            } else if (menu == 3) {
                MinusBalance.process(orClnt);
            } else if (menu == 4) {
                MoneyTransfer.process(orClnt);
            } else if (menu == 5) {
                LogoutAccount.process(orClnt);
                break;
            }
        }
    }
}
