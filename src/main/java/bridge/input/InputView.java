package bridge.input;

import bridge.output.OutputView;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            OutputView.printReadBridgeSizeMessage();
            String bridgeSize = Console.readLine();

            try {
                Validator.bridgeSize(bridgeSize);
                return Integer.parseInt(bridgeSize);
            } catch (IllegalArgumentException e) {
                OutputView.printReadBridgeSizeErrorMessage();
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            OutputView.printReadMovingMessage();
            String moving = Console.readLine();

            try {
                Validator.moving(moving);
                return moving;
            } catch (IllegalArgumentException e) {
                OutputView.printReadMovingErrorMessage();
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            OutputView.printReadGameCommandMessage();
            String gameCommand = Console.readLine();

            try {
                Validator.gameCommand(gameCommand);
                return gameCommand;
            } catch (IllegalArgumentException e) {
                OutputView.printReadGameCommandErrorMessage();
            }
        }
    }
}
