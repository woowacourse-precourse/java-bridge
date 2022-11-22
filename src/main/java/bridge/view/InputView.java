package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static bridge.util.BridgeValidator.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {
    public static String readInput() {
        String input = readLine().trim();
        return input;
    }


    // 다리의 길이를 입력받는다.
    public static int readBridgeSize() {
        int num = 0;
        String input = readInput();
        try {
            if(possibleBridgeSize(input)) num = Integer.parseInt(input);
        } catch(IllegalArgumentException e) {
            return readBridgeSize();
        }
        return num;
    }


    // 사용자가 이동할 칸을 입력받는다.
    public static String readMoving() {
        String select = readInput();
        try {
            if(possibleMovingSelect(select)) return select;
        } catch(IllegalArgumentException e) {
            return readMoving();
        }

        return null;
    }


    // 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
    public static String readGameCommand() {
        String decision = readInput();
        try {
            if(possibleRetryDecision(decision)) return decision;
        } catch(IllegalArgumentException e) {
            return readGameCommand();
        }

        return null;
    }
}
