package bridge;

import java.util.List;

public class BridgeGameController {
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void gameStart() {
        bridgeGame.printGameStartMessage();
        System.out.println();
    }

    public List<String> makeBridge() {
        int bridgeSize = inputView.readBridgeSize();
        return bridgeGame.makeBridge(bridgeSize);
    }

    public void playGame(List<String> bridge) {
        while (bridgeGame.getLevel() < bridge.size()) {
            bridgeGame.printRequestMovingMessage();
            String moving = inputView.readMoving();
            String move = bridgeGame.move(bridge, moving, bridgeGame.getLevel());
            outputView.printMap(move);

            if (wantFinish(move)) {
                break;
            }
            bridgeGame.nextLevel();
        }
    }

    private boolean wantFinish(String move) {
        if (move.contains("X")) {
            String gameCommand = inputView.readGameCommand();
            if (gameCommand.equals("Q")) {
                return true;
            }
            if (gameCommand.equals("R")) {
                bridgeGame.printBeforeMap(bridgeGame.getLevel());
                bridgeGame.goToBackStage();
            }
        }
        return false;
    }

    public void printResult(List<String> bridge,int bridgeSize) {
        String makeGameResultMap = bridgeGame.makeCurrentResultMap(bridgeSize);
        outputView.printResult(makeGameResultMap);
        bridgeGame.isSuccess(bridge, bridgeGame.getLevel());
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }
}
