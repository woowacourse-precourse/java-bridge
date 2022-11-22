package bridge;

import java.util.List;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();

    public List<String> makeBridge() {
        int bridgeSize = inputView.readBridgeSize();
        return bridgeGame.makeBridge(bridgeSize);
    }

    public void gameStart() {
        System.out.println(printOutput.START_GAME.getGameOutput());
        System.out.println();
    }

    public void playGame(List<String> bridge) {
        while (bridgeGame.getAcrossBridge() < bridge.size()) {
            System.out.println(printOutput.SELECT_BRIDGE_UP_DOWN.getGameOutput());
            String moving = inputView.readMoving();
            String move = bridgeGame.move(bridge, bridgeGame.getAcrossBridge(), moving);
            outputView.printMap(move);
            bridgeGame.accrosBridgePlus();
            if (gameFail(move)) {
                break;
            }
        }
    }

    public Boolean gameFail(String move) {
        if (move.contains("X")) {
            String readGameCommand = inputView.readGameCommand();
            if (readGameCommand.equals("R")) {
                bridgeGame.retry();
            }
            if (readGameCommand.equals("Q")) {
                return true;
            }
        }
        return false;
    }

    public void result(List<String> bridge,int bridgeSize) {
        String resultMap = bridgeGame.InstanceMap(bridgeSize);
        outputView.printResult(resultMap);
        bridgeGame.isSuccess(bridge, bridgeGame.getAcrossBridge(), resultMap);
        System.out.println(printOutput.ALL_TRY.getGameOutput() + bridgeGame.getCount());
    }
}
