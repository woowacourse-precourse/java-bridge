package bridge.utils;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    public static int readNumber() {
        try {
            return Integer.parseInt(readAndTrim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 입력되었습니다. 숫자를 입력해주세요.");
        }
    }

    public static String readAndTrim() {
        return Console.readLine().trim();
    }
}
