package bridge.view;

import bridge.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static int bridgeSize;
    public static String retryGame;
    static Validator validator = new Validator();

    // 다리의 길이를 입력받는다
    public static int readBridgeSize() {
        OutputView.printBridgeSize();
        String input = Console.readLine();
        System.out.println();
        if (input != null && !input.matches("-?\\d+")) {
            validator.checkBridgeSizeInputInteger(input);
            input = validator.inputNum;
        }
        bridgeSize = Integer.parseInt(input);
        if (bridgeSize < 3 || bridgeSize > 20) {
            validator.checkBridgeSize(bridgeSize);
        }
        return bridgeSize;
    }

    // 이동할 값을 입력한다.
    public static String readMoving() {
        OutputView.printSelectBlock();
        String moveCount = Console.readLine();
        return moveCount;
    }

    // 사용자가 게임을 다시 시도할 지 여부 (재시도 : R, 종료 : Q)
    public static String readGameCommand() {
        OutputView.printGameRestart();
        retryGame = Console.readLine();
        return retryGame;
    }
}
