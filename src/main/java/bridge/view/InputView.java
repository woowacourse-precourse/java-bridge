package bridge.view;

import bridge.exception.BridgeSizeException;
import bridge.exception.GameCommandException;
import bridge.exception.MovingException;
import bridge.exception.UserException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해 주세요");
        UserException bridgeSizeException = new BridgeSizeException();
        String bridgeSize = checkInput(bridgeSizeException);
        System.out.println();
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        UserException movingException = new MovingException();
        return checkInput(movingException);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        UserException gameCommandException = new GameCommandException();
        return checkInput(gameCommandException);
    }

    private String checkInput(UserException userException) {
        while (true) {
            try {
                String input = Console.readLine();
                userException.checkException(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
