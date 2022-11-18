package bridge;

import java.util.List;

public class Application {

    public static InputView inputView = new InputView();
    public static BridgeGame bridgeGame = new BridgeGame();
    public static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    public static BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    public static GameData gameData = new GameData();
    public static OutputView outputView = new OutputView();

    public static int bridgeSize = -1;
    public static String direction = "-1";
    public static List<String> bridge;
    public static String movingResult;
    public static String stopFlag = "-1";

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        while (!(bridgeGame.getBridgeIndex() == bridgeSize) && !stopFlag.equals("Q")) {
            direction = inputView.readMoving();
            movingResult = bridgeGame.move(bridge, direction);
            gameData.updateStatus(direction, movingResult);
            outputView.printMap(gameData.getTopStatus(), gameData.getBottomStatus());
            if (movingResult.equals("X")) { stopFlag = inputView.readGameCommand(); }
            if (bridgeGame.retry(stopFlag)) { stopFlag = gameData.restartGame(); }}
        System.out.println("최종 게임 결과");
        outputView.printMap(gameData.getTopStatus(), gameData.getBottomStatus());
        outputView.printResult(bridgeGame.checkGameResult(bridgeSize), gameData.getTotalTry());
    }
}