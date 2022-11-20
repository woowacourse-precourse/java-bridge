package bridge.view;

import bridge.constant.Directive;
import bridge.constant.ViewStatus;
import bridge.controller.BridgeGameController;
import bridge.dto.GameResult;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final BridgeGameController bridgeGameController;

    private ViewStatus status = ViewStatus.DETERMINE_BRIDGE_SIZE;

    public InputView(BridgeGameController bridgeGameController) {
        this.bridgeGameController = bridgeGameController;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public void makeBridge() {
        while (status == ViewStatus.DETERMINE_BRIDGE_SIZE) {
            System.out.println(Directive.INPUT_SIZE_OF_BRIDGE.getMessage());
            status = bridgeGameController.makeBridge(Console.readLine());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public void move() {
        while (status != ViewStatus.WIN && status != ViewStatus.DETERMINE_CONTINUE) {
            System.out.println(Directive.INPUT_MOVE_COMMAND.getMessage());
            GameResult result = bridgeGameController.move(Console.readLine());
            status = result.getNextViewStatus();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
