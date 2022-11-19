package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다. 리
 * 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 "있다".
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 "있다".
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int bridgeSize = 0;
        try {
            bridgeSize = convertToInt(Console.readLine());
        }
        catch (IllegalArgumentException e) {
            e.getMessage();
            bridgeSize = readBridgeSize();
        }
        return bridgeSize;
    }

    public int convertToInt(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수가 아닙니다.");

        }
        return number;
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
