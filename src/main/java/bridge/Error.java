package bridge;

public class Error {

    public static int validBridegeLen(int bridegeLen) {
        if ((bridegeLen < 3) || (bridegeLen > 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3이상 20이하의 숫자만 입력해주세요.");
        }
        return bridegeLen;
    }

}
