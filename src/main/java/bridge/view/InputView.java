package bridge.view;

import static bridge.validator.BridgeValidator.validateBridgeLength;
import static bridge.validator.MoveValidator.validateMovingPath;
import static bridge.validator.RetryValidator.validateRetryCommand;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() { //전부 이렇게 while문으로 감싸야 하나? 내일 더 보자..
        while (true) {
            try {
                System.out.println("다리의 길이를 입력해주세요.");
                String input = Console.readLine();
                validateBridgeLength(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                String movingPath = Console.readLine();
                validateMovingPath(movingPath);
                return movingPath;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String retryCommand = Console.readLine();
                validateRetryCommand(retryCommand);
                return retryCommand;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
