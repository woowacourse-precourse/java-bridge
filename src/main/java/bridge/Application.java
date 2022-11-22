package bridge;

import bridge.model.BridgeGame;
import bridge.model.Command;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    static InputView inputView;
    static OutputView outputView;
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    static BridgeMaker bridgeMaker;
    static BridgeGame bridgeGame;

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        startState();
        gameState();
        endState();
    }

    private static void startState() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.getValidBridgeSize()));
        inputView = new InputView(bridgeGame);
        outputView = new OutputView();
    }

    private static void gameState() {
        while (!bridgeGame.isGameEnd()) {
            inputView.getValidMoving();
            outputView.printMap(bridgeGame.getUpperRoad(), bridgeGame.getLowerRoad());
            if (endGameState()) {
                break;
            }
        }
    }

    private static boolean endGameState() {
        if (!bridgeGame.isRightFoothold()) {
            if (inputView.getValidGameCommand().equals(Command.QUIT.getValue())) {
                return true;
            }
            bridgeGame.retry();
        }
        return false;
    }

    private static void endState() {
        outputView.printResult(bridgeGame);
    }
}
