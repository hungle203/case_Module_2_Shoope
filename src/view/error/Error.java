package view.error;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static view.Constant.scanner;


public class Error {

    public static boolean selectionInputError(int choose, int firstChoose, int lastChoose) {
        try {
            final boolean isInvalid = choose != Integer.MIN_VALUE;
            if (isInvalid && choose < firstChoose || choose > lastChoose) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println("🔔"+ "Không có lựa chọn này.");
            return false;
        }
        return true;
    }

    public static boolean styleNumberPhoneError(String phoneNumber) {
        String regex = "^[0]{1}+[235789]{1}+\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        try {
            if (!matcher.matches()) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.err.println("[\uD83D\uDD14]" + "SỐ ĐIỆN THOẠI KHÔNG HỢP LỆ\nSố điện thoại phải bắt đầu bằng số 0 và có 10 số");
            return false;
        }
        return true;
    }

    public static int inputMismatchError() {
        int number = Integer.MIN_VALUE;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("[\uD83D\uDD14]" + "Nhập sai định dạng số.");
        }
        scanner.nextLine();
        return number;
    }

}
