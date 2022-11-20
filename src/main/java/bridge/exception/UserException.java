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
        if (num < 3 || num > 20) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    
    public static void movingException(String s) {
        if (!s.contentEquals("U") && !s.contentEquals("D")) {
            System.out.println("[ERROR] U 또는 D를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }

    public static void reGameException(String s) {
        if (!s.contentEquals("R") && !s.contentEquals("Q")) {
            System.out.println("[ERROR] R 또는 Q를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
    }
}
