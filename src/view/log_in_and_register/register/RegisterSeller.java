package view.log_in_and_register.register;
import model.account.Account;
import model.person.Seller;
import view.error.Error;

import static view.Constant.*;

public class RegisterSeller {
    public static void run() {
        int choose;
        Seller seller = inputBuyer();
        if (Register.checkAccount(seller)) return;
        System.out.println("[\uD83D\uDD14]"+ "[Kiểm tra lại thông tin tài khoản]");
        System.out.println(seller);
        do {
            menu();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 3);
            switch (choose) {
                case 1:
                    System.out.println("[\uD83D\uDD14]"+ "Tài khoản sẽ được Admin kiểm định lại thông tin " + "\n" + " thời gian phê duyệt có thể là 2 ngày");
                    people.add(seller);
                    break;
                case 2:
                    run();
                    break;
            }
        } while (choose != 1 && choose != 3);
    }

    public static Seller inputBuyer() {
        System.out.println(".>Nhập tên tài khoản");
        String name = scanner.nextLine();
        System.out.println(".>Nhập mật khẩu");
        String password = scanner.nextLine();
        System.out.println(".>Nhập mã số giấy phép kinh doanh");
        String license = scanner.nextLine();
        boolean checkPhoneNumber;
        String phoneNumber = "";
        do {
            System.out.println(".>Nhập số điện thoại");
            phoneNumber = scanner.nextLine();
            checkPhoneNumber = Error.styleNumberPhoneError(phoneNumber);
        } while (!checkPhoneNumber);
        System.out.println(".>Nhập địa chỉ");
        String address = scanner.nextLine();
        Account account = new Account(name, password);
        return new Seller(account, SELLER, license, phoneNumber, address);
    }

    public static void menu() {
        System.out.println("[1. Đồng ý  ]");
        System.out.println("[2. Nhập lại]");
        System.out.println("[3. Hủy     ]");
    }
}
