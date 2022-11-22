package bridge;

public class Util {

    public static int toInt(String number) {
        try {
            return Integer.parseInt(number);

        } catch (Exception e) {
            throw new IllegalArgumentError("숫자를 입력해주세요.");
        }
    }
}
