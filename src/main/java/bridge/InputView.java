package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Validation.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String enteredBridgeSize = Console.readLine();
        validateBridgeSize(enteredBridgeSize);
        return Integer.parseInt(enteredBridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String enteredMoving = Console.readLine();
        validateMoving(enteredMoving);
        return enteredMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String enteredGameCommand = Console.readLine();
        validateGameCommand(enteredGameCommand);
        return enteredGameCommand;
    }
}



