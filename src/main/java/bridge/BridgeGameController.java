package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeGameController {
    private int gameCount;
    private BridgeGame bridgeGame;
    private List<String> answerBridge;

    public BridgeGameController() {
        answerBridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(new InputView().readBridgeSize());
        gameCount = 1;
        bridgeGame = new BridgeGame(answerBridge);
    }

    public void gameStart() {
        while (bridgeGame.getStatus().equals(StatusType.PLAY)) {
            move();
            checkGameStatus();
        }
        new OutputView().printResult(bridgeGame.getStatus(), updatedBridge(), gameCount);
    }

    public void move() {
        bridgeGame.move(new InputView().readMoving());
        new OutputView().printMap(updatedBridge());
    }

    public void checkGameStatus() {
        bridgeGame.isSuccess();
        if (bridgeGame.getStatus().equals(StatusType.FAIL)) {
            checkGameContinued();
        }
    }

    public void checkGameContinued() {
        String input = new InputView().readGameCommand();
        if (input.equals("R")) {
            bridgeGame.retry();
            gameCount++;
        }
        if (input.equals("Q")) {
            bridgeGame.quit();
        }
    }

    private List<List<String>> updatedBridge() {
        List<String> upperBridge = new ArrayList<>();
        List<String> lowerBridge = new ArrayList<>();
        List<List<String>> currentBridge = new ArrayList<>(Arrays.asList(lowerBridge, upperBridge));

        for (int idx = 0; idx < bridgeGame.getRoute().size(); idx++) {
            currentBridge.get(checkDirection(bridgeGame.getRoute().get(idx))).add(findAnswer(idx, bridgeGame.getRoute().get(idx)));
            currentBridge.get(1 - checkDirection(bridgeGame.getRoute().get(idx))).add(" ");
        }
        return currentBridge;
    }

    private String findAnswer(int idx, String move) {
        if (answerBridge.get(idx).equals(move)) {
            return "O";
        }
        return "X";
    }

    private int checkDirection(String move) {
        if (move.equals("U")) {
            return 0;
        }
        return 1;
    }
}
