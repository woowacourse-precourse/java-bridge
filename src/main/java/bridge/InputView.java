package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size = Console.readLine();
        if (isEmptyOrNull(size) || !isNumber(size)) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다. 숫자만 입력해주세요.");
        }
        return Integer.parseInt(size);
    }

    private boolean isNumber(String str) {
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private boolean isEmptyOrNull(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = Console.readLine();
        Arrays.stream(BridgeCell.values())
                .filter(cell -> cell.equals(moving))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR]: 잘못된 칸을 입력하셨습니다."));
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
