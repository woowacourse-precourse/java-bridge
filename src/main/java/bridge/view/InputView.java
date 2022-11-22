package bridge.view;

import bridge.game.GameCommand;
import bridge.structure.BridgeMoveValue;
import bridge.view.util.Transfer;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String bridgeSize = Console.readLine();
            return Transfer.toNumber(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public BridgeMoveValue readMoving() {
        try {
            String input = Console.readLine();
            BridgeMoveValue.validateInput(input);
            return BridgeMoveValue.generate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        try {
            String input = Console.readLine();
            GameCommand.validateInput(input);
            return GameCommand.generate(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}
