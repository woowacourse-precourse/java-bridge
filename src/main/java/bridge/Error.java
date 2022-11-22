package bridge;

public class Error {

    public static int validBridegeLen(int bridegeLen) {
        if ((bridegeLen < 3) || (bridegeLen > 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3이상 20이하의 숫자만 입력해주세요.");
        }
        return bridegeLen;
    }

    public static void validUOrD(String input) {
        if(!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U 또는 D만 입력하세요.");
        }
    }
    public static void validRetry(String input) {
        if(!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q만 입력하세요.");
        }
    }

}
