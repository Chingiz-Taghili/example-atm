package menu.loginmenu;

import menu.loginmenu.inter.ExitProgramInter;

public class ExitProgram implements ExitProgramInter {

    public void process() {
        System.exit(0);
    }
}
