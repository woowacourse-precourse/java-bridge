package bridge;

import static validator.BridgeValidator.validateBridgeLength;
import static validator.MoveValidator.validateMovingPath;
import static validator.RetryValidator.validateRetryCommand;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        validateBridgeLength(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String movingPath = Console.readLine();
        validateMovingPath(movingPath);
        return movingPath;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String retryCommand = Console.readLine();
        //재시작 여부 입력값을 검증하는 함수를 호출하는 자리
        return retryCommand;
    }
}
