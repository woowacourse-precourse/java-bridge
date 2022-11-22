package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static BridgeGame bridgeGame = new BridgeGame();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge, CurrentBridgeState currentBridgeState, int turn) {

        boolean isPossibleMove;

        String moveCommand = inputView.readMoving();
        isPossibleMove = bridgeGame.isPossibleMove(bridge, moveCommand, turn);
        currentBridgeState.recordBridgeMove(moveCommand, isPossibleMove);
        outputView.printMap(currentBridgeState);

    }

    public boolean isPossibleMove(List<String> bridge, String moveCommand, int turn) {

        String bridgeInformation = bridge.get(turn);

        if (bridgeInformation.equals(moveCommand)) {
            return true;
        }

        return false;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * @param currentBridgeState
     * @param isPossibleMove
     * @param tryNumber
     */
    public boolean retry(CurrentBridgeState currentBridgeState, boolean isPossibleMove, int tryNumber) {
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("Q")) {
            outputView.printResult(currentBridgeState, isPossibleMove, tryNumber);
            return false;
        } else if (gameCommand.equals("R")) {
            return true;
        }
        return false;
    }
}
