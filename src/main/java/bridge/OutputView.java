package bridge;

import static bridge.OutputViewDetail.*;

public class OutputView {
    String upperBridge = "";
    String lowerBridge = "";

    private boolean isUp(BridgeGame bridgeGame){
        return bridgeGame.getBridgePosition().equals(BridgeDirection.U.toString());
    }

    private boolean isDown(BridgeGame bridgeGame){
        return bridgeGame.getBridgePosition().equals(BridgeDirection.D.toString());
    }

    private boolean isOnGoing(BridgeGame bridgeGame){
        return (0 < bridgeGame.bridgeIndex && bridgeGame.bridgeIndex < bridgeGame.bridge.size());
    }

    private void makeUpperBridge(BridgeGame bridgeGame) {
        if (isUp(bridgeGame) && bridgeGame.isMovable) {
            upperBridge += CAN_MOVE.getMessage();
        }
        if (isUp(bridgeGame) && !bridgeGame.isMovable) {
            upperBridge += CANNOT_MOVE.getMessage();
        }
        if (isDown(bridgeGame)) {
            upperBridge += NONE.getMessage();
        }
    }

    private void makeLowerBridge(BridgeGame bridgeGame) {
        if (isDown(bridgeGame) && bridgeGame.isMovable) {
            lowerBridge += CAN_MOVE.getMessage();
        }
        if (isDown(bridgeGame) && !bridgeGame.isMovable) {
            lowerBridge += CANNOT_MOVE.getMessage();
        }
        if (isUp(bridgeGame)) {
            lowerBridge += NONE.getMessage();
        }
    }

    private void addLine(BridgeGame bridgeGame) {
        if (isOnGoing(bridgeGame)) {
            upperBridge += MIDDLE_LINE.getMessage();
            lowerBridge += MIDDLE_LINE.getMessage();
        }
    }

    public void makeBridgeMap(BridgeGame bridgeGame) {
        addLine(bridgeGame);
        makeUpperBridge(bridgeGame);
        makeLowerBridge(bridgeGame);
    }

    public void printMap(BridgeGame bridgeGame) {
        makeBridgeMap(bridgeGame);
        System.out.println(START_LINE.getMessage() + upperBridge + END_LINE.getMessage());
        System.out.println(START_LINE.getMessage() + lowerBridge + END_LINE.getMessage());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStartGame() {
        System.out.println(START_GAME.getMessage());
    }

    public void inputBridgeSize() {
        System.out.println(NEW_LINE.getMessage() + INPUT_BRIDGE_SIZE.getMessage());
    }

    public void inputMoving() {
        System.out.println(NEW_LINE.getMessage() +  INPUT_MOVING.getMessage());
    }
}
