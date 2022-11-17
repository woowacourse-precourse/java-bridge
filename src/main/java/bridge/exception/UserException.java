package bridge.exception;

public class UserException {
    public static int parseInt(String s) {
        int num = 0;

        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력해 주세요.");
            throw new IllegalArgumentException();
        }

        return num;
    }

    public static void numberRange(int num) {
        if (num < 3 && num > 20) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
