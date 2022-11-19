package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        outputView.printGameStart();
        try {
            BridgeGame bridgeGame = generateGame();
            playGame(bridgeGame);
        } catch(IllegalStateException exception) {
            outputView.printError(exception);
        }
    }

    private BridgeGame generateGame() {
        while (true) {
            try {
                return new BridgeGame(generateBridge(), new Player());
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception);
            }
        }
    }

    private List<String> generateBridge() {
        int bridgeSize = getBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private int getBridgeSize() {
        outputView.printBridgeSizeInputRequest();
        int bridgeSize = inputView.readBridgeSize();
        return bridgeSize;
    }

    private void playGame(BridgeGame bridgeGame) {
        // do - while구조로 바꿀 생각해보기
        // while 조건 식에 게임 상태가 종료가 아니면 이렇게 하는건?
        while (true) {
            try {
                crossBridgeUntilFinish(bridgeGame);
                // 다리 건너기(crossBridgeUntilExit);
                // 재시작/종료 여부 입력받기(askRetryOrFinish)
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception);
            }
        }
    }

    private void crossBridgeUntilFinish(BridgeGame bridgeGame) {
        do {
            crossBridge(bridgeGame);
        } while (true);
//        } while (재시작종료여부가 재시작이라면);
    }

    private void crossBridge(BridgeGame bridgeGame) {
        outputView.printMovingInputRequest();
        String spaceToMove = inputView.readMoving();
    }
}
