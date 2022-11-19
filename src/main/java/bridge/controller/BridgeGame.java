package bridge.controller;

import bridge.model.Bridge;
import bridge.model.Player;
import bridge.model.Referee;
import bridge.type.ErrorType;
import bridge.valid.Validation;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static int progressCount = 1;
    public static int BRIDGE_LENGTH = 0;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Bridge bridge = new Bridge();
    private Player player = new Player();
    private Referee referee = new Referee();

    public void play() {
        OutputView.printStartGame();
        generateBridge();
        while (true) {
            move();
        }
    }

    public void generateBridge() {
        try {
            BRIDGE_LENGTH = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            inputView.printError(ErrorType.INPUT_BRIDGE_SIZE_ERROR_TYPE.getText());
            generateBridge();
        }
        bridge.setBridge(BRIDGE_LENGTH);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String moveType = "";
        try {
            moveType = inputView.readMoving();
            Validation.inputMoveSquareValid(moveType);
            player.add(moveType);
        } catch (IllegalArgumentException e) {
            inputView.printError(ErrorType.INPUT_SQUARE_ERROR_TYPE.getText());
            move();
        }
        printMove(moveType);
    }

    private void printMove(String moveType) {
        referee.addPlayerChoiceResult(bridge.getBridge(), moveType, progressCount - 1);

        outputView.printMap(referee.getUpSideBridgeResult(), referee.getDownSideBridgeResult());
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
