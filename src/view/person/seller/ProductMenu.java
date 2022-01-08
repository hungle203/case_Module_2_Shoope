package view.person.seller;

import model.person.Seller;
import model.product.Product;
import view.error.Error;

import static view.Constant.*;

public class ProductMenu {
    public static void editProduct(Product product) {
        String[] informationProduct = inputInformation();
        String name = informationProduct[0];
        double price = Double.parseDouble(informationProduct[1]);
        String description = informationProduct[2];
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        System.out.println("[\uD83D\uDD14]" + "[sửa thành công].");
    }

    public static Product inputProduct(Seller seller) {
        String[] informationProduct = inputInformation();
        String name = informationProduct[0];
        double price = Double.parseDouble(informationProduct[1]);
        String description = informationProduct[2];
        String category = inputCategory();
        return new Product(name, price, description, category, seller);
    }

    private static String[] inputInformation() {
        String[] productInformation = new String[3];
        System.out.println(".>Nhập tên sản phẩm");
        String name = scanner.nextLine();
        productInformation[0] = name;

        System.out.println(".>Nhập giá sản phẩm");
        double price = scanner.nextDouble();
        productInformation[1] = String.valueOf(price);
        scanner.nextLine();

        System.out.println(".>Nhập mô tả sản phẩm");
        String description = scanner.nextLine();
        productInformation[2] = description;
        return productInformation;
    }

    public static String inputCategory() {
        System.out.println(".>Nhập danh mục sản phẩm");
        String category = null;
        int choose;
        do {
            menuCategory();
            choose = Error.inputMismatchError();
            Error.selectionInputError(choose, 1, 5);
            switch (choose) {
                case 1:
                    category = PHONE_LAPTOP_TABLET;
                    break;
                case 2:
                    category = TV_SPEAKER;
                    break;
                case 3:
                    category = AIR_CONDITIONING;
                    break;
                case 4:
                    category = WASHING_DRYER_MACHINE;
                    break;
                case 5:
                    category = KITCHEN_TOOLS;
                    break;
            }
        } while (choose != 1 && choose != 2 && choose != 3 && choose != 4 && choose != 5);

        return category;
    }

    public static void menuCategory() {
        System.out.println("[------------DANH MỤC SẢN PHẨM------------]");
        System.out.println("[1. Điện thoại, Laptop, Tablet            ]");
        System.out.println("[2. Tivi, Loa, Dàn Karaoke                ]");
        System.out.println("[3. Máy lạnh, Quạt điều hòa               ]");
        System.out.println("[4. Máy giặt, Sấy quần áo                 ]");
        System.out.println("[5. Đồ dùng nhà bếp                       ]");
        System.out.println("[-----------------------------------------]");
        System.out.println("[\uD83D\uDCDD]"+ ".>Nhập lựa chọn");
    }
}
