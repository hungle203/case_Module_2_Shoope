package view.person.manager;

import model.person.Manage;

import static view.Constant.ADMIN;

public class ManagerMenu {
    public static void run(Manage manager) {
        String position = manager.getPosition();
        if (ADMIN.equals(position)) {
            AdminMenu.run(manager);
        }
    }
}
