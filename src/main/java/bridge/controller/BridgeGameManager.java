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

        int step = 0;
        while (step < targetBridge.getSize()) {
            String upDownInput = inputUpDownRepeat();
            bridgeGame.move(upDownInput);
            printStatus(bridgeGame, targetBridge);

            // 만약 새로 간 칸이 잘 못된 칸이라면
            if (isFault(targetBridge, step, upDownInput)) {
                String retryAnswer = inputRetryRepeat();

                if (retryAnswer.equals("R")) {
                    bridgeGame.back(step);
                    bridgeGame.retry();
                    continue;
                }

                if (retryAnswer.equals("Q")) {
                    break;
                }
            }
            step++;
        }

        printResult(targetBridge, bridgeGame);
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
        int bridgeSize;
        while (true) {
            try {
                bridgeSize = InputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
        return bridgeSize;
    }

    private String inputUpDownRepeat() {
        String upDownInput;
        while (true) {
            try {
                upDownInput = InputView.readMoving();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 이동할 칸은 U 또는 D 여야 합니다.");
            }
        }
        return upDownInput;
    }

    private String inputRetryRepeat() {
        String retryAnswer;
        while (true) {
            try {
                retryAnswer = InputView.readGameCommand();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 재시작/종료는 Q 또는 R이어야 합니다.");
            }
        }
        return retryAnswer;
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
