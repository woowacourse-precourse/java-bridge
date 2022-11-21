package bridge.view;

import bridge.validation.ReadBridgeSizeValidation;
import bridge.validation.ReadMovingValidation;
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
        String inputBridgeSize = Console.readLine();
        System.out.println();

        ReadBridgeSizeValidation readBridgeSizeValidation = new ReadBridgeSizeValidation();
        readBridgeSizeValidation.validate(inputBridgeSize);
        return Integer.parseInt(inputBridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 입력해주세요. (위: U, 아래: D)");
        String movingCommand = Console.readLine();
        System.out.println();

        ReadMovingValidation readMovingValidation = new ReadMovingValidation();
        readMovingValidation.validateInputFormat(movingCommand);
        return movingCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();

        return gameCommand;
    }
}
