package bridge;

import java.util.regex.Pattern;

public class Valid {

    public void validBridgeSize(String value) {
        if (!isBridgeSizeNumber(value)) { // 3 ~ 20이 아니면 true
            throw new IllegalArgumentException();
        }
    }

    // 3 이상 20 이하의 숫자인지 검사
    public boolean isBridgeSizeNumber(String value) {
        final String REGEX = "^[3-9]{1}$|^[1]{1}[0-9]{1}$|^2{1}[0]{1}$";
        if (Pattern.matches(REGEX, value)) {
            return true;
        }
        return false;
    }

    public void validReadMoving(String moving) {
        if (!isReadMoving(moving)) { // U 또는 D가 아니라면
            throw new IllegalArgumentException();
        } // end if
    }

    // 입력 값이 U 또는 D 인지 검사
    public boolean isReadMoving(String moving) {
        if (moving.equals("U") || moving.equals("D")) {
            return true;
        }
        return false;
    }

    public void validReadGameCommand(String retry) {
        if (!isRetry(retry)) { // R 또는 Q가 아니라면
            throw new IllegalArgumentException();
        } // end if
    }

    // 입력 값이 R 또는 Q 인지 검사
    public boolean isRetry(String retry) {
        if (retry.equals("R") || retry.equals("Q")) {
            return true;
        }
        return false;
    }

}
