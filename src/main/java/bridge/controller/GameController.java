package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.view.InputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public GameController() {
        inputView = new InputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    private void initializeGame() {
        bridgeGame = new BridgeGame(createNewBridge());
    }

    private Bridge createNewBridge() {
        while (true) {
            try {
                return new Bridge(generateBridge());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void play() {
        move();
    }

    private void move() {
        String nextPosition;
        while (true) {
            try {
                nextPosition = inputView.readMoving();
                bridgeGame.move(nextPosition); //그리고 bridgeGame 내에서 성공 여부 연산, 이동한 내역 업데이트
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private List<String> generateBridge() {
        return bridgeMaker.makeBridge(requestBridgeLength());
    }

    private int requestBridgeLength() {
        return inputView.readBridgeSize();
    }

}
