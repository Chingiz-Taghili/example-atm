package menu.loginmenu;

import bean.OrdinaryClient;
import data.Data;
import menu.loginmenu.inter.LoginAccountInter;
import util.Check;
import util.Input;
import util.Show;

public class LoginAccount implements LoginAccountInter {

    public void process() {
        String[] nameAndSurnameArr = Check.nameAndSurname(Input.text("Adınız və soyadınız"));

        String cardPinCode = Check.cardPinCode(Input.text("Kartınızın pin kodu"));

        OrdinaryClient orClnt = Check.verifyLogin(nameAndSurnameArr[0], nameAndSurnameArr[1], cardPinCode);

        if (orClnt != null) {
            System.out.println("Salam, " + orClnt.getName() + " " + orClnt.getSurname() + "\n");
            Show.mainMenu(orClnt);
        } else {
            System.out.println("Ad və ya pin kod yanlışdır!\n");
        }
    }
}
