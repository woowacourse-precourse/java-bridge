package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Status;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameManager {
    public void run() {
        BridgeGame bridgeGame = makeGame();

        setGame(bridgeGame);

        printStart();

        int bridgeSize = inputBridgeSizeRepeat();

        Bridge targetBridge = bridgeGame.makeTargetBridge(bridgeSize);

        inputMovingAndPrintMap(targetBridge, bridgeGame);

        printResult(targetBridge, bridgeGame);
    }

    private void judgeRetry(BridgeGame bridgeGame, int step, String retryAnswer) {
        if (retryAnswer.equals("R")) {
            bridgeGame.back(step);
            bridgeGame.retry();
        }
    }

    private boolean judgeQuit(String retryAnswer) {
        return retryAnswer.equals("Q");
    }

    private String inputAndMoveAndPrint(Bridge targetBridge, BridgeGame bridgeGame) {
        String upDownInput = inputUpDownRepeat();
        bridgeGame.move(upDownInput);
        printStatus(bridgeGame, targetBridge);
        return upDownInput;
    }

    private void inputMovingAndPrintMap(Bridge targetBridge, BridgeGame bridgeGame) {
        int step = 0;
        boolean isQuit = false;
        while (step < targetBridge.getSize() || isQuit) {
            String upDownInput = inputAndMoveAndPrint(targetBridge, bridgeGame);
            if (isFault(targetBridge, step, upDownInput)) {
                String retryAnswer = inputRetryRepeat();
                judgeRetry(bridgeGame, step, retryAnswer);
                isQuit = judgeQuit(retryAnswer);
            }
            step++;
        }
    }

    private boolean isFault(Bridge targetBridge, int tries, String upDownInput) {
        return !targetBridge.bridgeSameIndex(tries, upDownInput);
    }

    private void printStatus(BridgeGame bridgeGame, Bridge targetBridge) {
        Status preStatus = bridgeGame.getPreStatus();
        OutputView.printMap(targetBridge, preStatus);
    }

    private void setGame(BridgeGame bridgeGame) {
        bridgeGame.setTryNumber();
    }

    private BridgeGame makeGame() {
        return new BridgeGame();
    }

    private int inputBridgeSizeRepeat() {
        while (true) {
            try {
                return InputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String inputUpDownRepeat() {
        while (true) {
            try {
                return InputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String inputRetryRepeat() {
        while (true) {
            try {
                return InputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printResult(Bridge targetBridge, BridgeGame bridgeGame) {
        OutputView.printResult();
        OutputView.printMap(targetBridge, bridgeGame.getPreStatus());
        OutputView.printSuccessFailure(targetBridge, bridgeGame.getPreStatus());
        OutputView.printTryNumber(bridgeGame.getTryNumber());
        bridgeGame.resetTryNumber();
    }

    private void printStart() {
        OutputView.printStart();
    }
}
