package menu.loginmenu;

import bean.Client;
import util.Check;
import util.Input;
import util.Show;

public class LoginAccountImpl implements menu.loginmenu.inter.LoginAccount {

    public void process() {
        String[] nameAndSurnameArr = Check.nameAndSurname(Input.text("Adınız və soyadınız"));

        String cardPinCode = Check.cardPinCode(Input.text("Kartınızın pin kodu"));

        Client client = Check.verifyLogin(nameAndSurnameArr[0], nameAndSurnameArr[1], cardPinCode);

        if (client != null) {
            System.out.println("Salam, " + client.getName() + " " + client.getSurname() + "\n");
            Show.mainMenu(client);
        } else {
            System.out.println("Ad və ya pin kod yanlışdır!\n");
        }
    }
}
