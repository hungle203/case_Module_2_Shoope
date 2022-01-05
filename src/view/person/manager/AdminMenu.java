package view.person.manager;

import model.person.Manage;
import model.person.Person;
import model.person.Seller;
import model.product.Product;
import view.error.Error;

import java.util.Iterator;

import static view.Constant.*;

public class AdminMenu {

    public static void run(Manage manage) {
        int choose;
        do {
            menuAdmin();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 6);
            switch (choose) {
                case 1:
                    showSellerRegister();
                    break;
                case 2:
                    addSeller();
                    break;
                case 5:
                    removeSeller();
                    break;
            }
        } while (choose != 6);
    }

    public static void removeSeller() {
        System.out.println("Nhập tên người bán hàng");
        String name = scanner.nextLine();
        int index = people.searchPersonByName(name);
        if (index == -1) {
            System.err.println("Không có người bán này");
            System.out.println(END);
            return;
        }
        Person person = people.getPeople().get(index);
        Iterator<Product> productIterator = products.getProducts().iterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getSeller().getAccount().equals(person.getAccount())) {
                productIterator.remove();
            }
        }
        people.remove(index);
        System.out.println("Đã xóa.");
        System.out.println(END);
    }

    public static void showSellerRegister() {
        int count = 0;
        for (Person person : people.getPeople()) {
            if (person instanceof Seller) {
                Seller seller = (Seller) person;
                if (!seller.isStatus()) {
                    System.out.println(seller);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Không có người bán hàng nào đăng ký.");
        }
    }

    public static void addSeller() {
        System.out.println("Nhập tên người đăng ký bán hàng");
        String name = scanner.nextLine();
        int index = people.searchPersonByName(name);
        if (index == -1) {
            System.err.println("Không có người bán này");
            System.out.println(END);
            return;
        }
        Person person = people.getPeople().get(index);
        if (person instanceof Seller) {
            Seller seller = (Seller) people.getPeople().get(index);
            if (!seller.isStatus()) {
                seller.setStatus(true);
                System.out.println("Đã thêm người bán hàng " + seller.getAccount().getName());
                System.out.println(END);
                return;
            } else {
                System.err.println("Người bán hàng này đã đăng ký");
                System.out.println(END);
            }
        }
        System.out.println("Đây là người dùng không phải người bán hàng");
        System.out.println(END);
    }

    public static void menuAdmin() {
        System.out.println("------------Quản trị viên----------");
        System.out.println("1. Hiển thị người đăng ký bán hàng trên hệ thống");
        System.out.println("2. Thêm người bán hàng");
        System.out.println("3. Xóa người bán hàng");
        System.out.println("6. Thoát");
        System.out.println("Nhập lựa chọn");
    }

}
