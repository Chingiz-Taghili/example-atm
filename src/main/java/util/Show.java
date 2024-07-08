package util;

import bean.OrdinaryClient;
import menu.loginmenu.ExitProgram;
import menu.loginmenu.LoginAccount;
import menu.loginmenu.RegisterAccount;
import menu.loginmenu.inter.LoginMenu;
import menu.mainmenu.*;
import menu.mainmenu.inter.MainMenu;

public class Show {

    public static void entryScreen() {
        System.out.println("\n" + "MÜCƏRRƏD BANKA XOŞ GƏLMİSİNİZ! HESABINIZA DAXİL OLUN" +
                "\nVƏ YA ASAN QEYDİYYAT İLƏ MÜŞTƏRİMİZƏ ÇEVRİLİN" + "\n");
        loginMenu();
    }

    public static void loginMenu() {
        while (true) {
            int selectedMenu = Input.number("1. Hesaba daxil ol" + "\n2. Qeydiyyatdan keç" + "\n3. Çıxış");
            if (selectedMenu == 1) {
                loginMenuProcess(new LoginAccount());
            } else if (selectedMenu == 2) {
                loginMenuProcess(new RegisterAccount());
            } else if (selectedMenu == 3) {
                loginMenuProcess(new ExitProgram());
            } else {
                System.out.println("Menyunu düzgün daxil edin!" + "\n");
            }
        }
    }

    public static void loginMenuProcess(LoginMenu selectedMenu) {
        selectedMenu.process();
    }

    public static void mainMenu(OrdinaryClient orClnt) {
        while (true) {
            int selectedMenu = Input.number("1. Balansa bax" + "\n2. Balansı artır" +
                    "\n3. Pul nağdlaşdır" + "\n4. Köçürmə et" + "\n5. Hesabdan çıx");
            if (selectedMenu == 1) {
                mainMenuProcess(new CheckBalance(), orClnt);
            } else if (selectedMenu == 2) {
                mainMenuProcess(new PlusBalance(), orClnt);
            } else if (selectedMenu == 3) {
                mainMenuProcess(new MinusBalance(), orClnt);
            } else if (selectedMenu == 4) {
                mainMenuProcess(new MoneyTransfer(), orClnt);
            } else if (selectedMenu == 5) {
                mainMenuProcess(new LogoutAccount(), orClnt);
                break;
            } else {
                System.out.println("Menyunu düzgün daxil edin!" + "\n");
            }
        }
    }

    public static void mainMenuProcess(MainMenu selectedMenu, OrdinaryClient orClnt) {
        selectedMenu.process(orClnt);
    }
}
