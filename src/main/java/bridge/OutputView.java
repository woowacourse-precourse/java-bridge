package bridge;

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
            upperBridge += " O ";
        }
        if (isUp(bridgeGame) && !bridgeGame.isMovable) {
            upperBridge += " X ";
        }
        if (isDown(bridgeGame)) {
            upperBridge += "   ";
        }
    }

    private void makeLowerBridge(BridgeGame bridgeGame) {
        if (isDown(bridgeGame) && bridgeGame.isMovable) {
            lowerBridge += " O ";
        }
        if (isDown(bridgeGame) && !bridgeGame.isMovable) {
            lowerBridge += " X ";
        }
        if (isUp(bridgeGame)) {
            lowerBridge += "   ";
        }
    }

    private void addLine(BridgeGame bridgeGame) {
        if (isOnGoing(bridgeGame)) {
            upperBridge += "|";
            lowerBridge += "|";
        }
    }

    public void makeBridgeMap(BridgeGame bridgeGame) {
        addLine(bridgeGame);
        makeUpperBridge(bridgeGame);
        makeLowerBridge(bridgeGame);
    }

    public void printMap(BridgeGame bridgeGame) {
        makeBridgeMap(bridgeGame);
        System.out.println('[' + upperBridge + ']');
        System.out.println('[' + lowerBridge + ']');
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
