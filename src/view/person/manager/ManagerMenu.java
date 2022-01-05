package view.person.manager;

import model.person.Manage;

import static view.Constant.ADMIN;
import static view.Constant.STAFF;

public class ManagerMenu {
    public static void run(Manage manager) {
        String position = manager.getPosition();
        switch (position) {
            case ADMIN:
                AdminMenu.run(manager);
                break;
            case STAFF:
                StaffMenu.run(manager);
                break;
        }
    }
}
