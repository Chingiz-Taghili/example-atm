package menu.loginmenu;

import bean.OrdinaryClient;
import data.Data;
import menu.loginmenu.inter.RegisterAccountInter;
import util.Check;
import util.Input;
import util.Show;

public class RegisterAccount implements RegisterAccountInter {

    public void process() {

        String[] nameAndSurnameArr = Check.nameAndSurname(
                Input.text("Adınız və soyadınız"));

        if (Check.accountExistence(nameAndSurnameArr)) {
            return;
        }

        String cardNumber = Check.cardNumber(
                Input.text("Kart nömrəsinin son 8 rəqəmi"));

        String cardPinCode = Check.cardPinCode(
                Input.text("Kartınızın 4 rəqəmli pin kodu"));

        OrdinaryClient oc = new OrdinaryClient(nameAndSurnameArr[0], nameAndSurnameArr[1], cardNumber, cardPinCode);
        Data.instance().getOrClnts().add(oc);
        System.out.println("Təbriklər " + oc.getName() + " " + oc.getSurname() + ". Qeydiyyatınız uğurla tamamlandı!\n");
        Show.mainMenu(oc);
    }
}
