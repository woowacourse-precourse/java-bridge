package bridge.view;

import bridge.domain.GameSymbol;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return bridgeSizeValidate(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String inputMovingCommand = Console.readLine();
        movingCommandValidate(inputMovingCommand);
        return inputMovingCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameSymbol readGameCommand() {
        String inputGameCommand = Console.readLine();
        gameCommandValidate(inputGameCommand);
        return GameSymbol.conversionString(inputGameCommand);
    }

    private int bridgeSizeValidate(String inputBridgeSize) {
        if (!inputBridgeSize.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력 할 수 있습니다.");
        }
        int inputBridgeSizeToDigit = Integer.parseInt(inputBridgeSize);
        if (inputBridgeSizeToDigit < 3 || 20 < inputBridgeSizeToDigit) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3이상 20이하의 정수만 입력 할 수 있습니다.");
        }
        return inputBridgeSizeToDigit;
    }

    private void movingCommandValidate(String inputMovingCommand) {
        if (!inputMovingCommand.equals("U") && !inputMovingCommand.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 위로 이동은 U, 아래로 이동은 D만 입력 할 수 있습니다.");
        }
    }

    private void gameCommandValidate(String inputGameCommand) {
        if (!inputGameCommand.equals("R") && !inputGameCommand.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 재시작은 R, 종료는 Q만 입력 할 수 있습니다.");
        }
    }
}
