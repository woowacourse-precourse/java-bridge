package bridge.ui.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import bridge.vo.GameCommand;

import java.util.List;

/**
 * console 으로 요청 받아 게임을 진행하는 클래스
 */
public class BridgeGameController {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    /**
     * 게임 시작시 게임을 초기화 하는 메서드
     */
    public BridgeGame initGame() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.init(bridge);

        return bridgeGame;
    }

    /**
     * 사용자의 입력을 받아 이동 가능한지 여부를 판단하는 메서드
     */
    public boolean move() {
        String moving = inputView.readMoving();
        boolean isMovable = bridgeGame.move(moving);
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserRoute());

        return isMovable;
    }


    public void endGame(int count) {
        List<String> bridge = bridgeGame.getBridge();
        List<String> userRoute = bridgeGame.getUserRoute();
        outputView.printResult(bridge, userRoute, count);
    }

    public boolean retry() {
        GameCommand gameCommand = inputView.readGameCommand();
        if (wantRetry(gameCommand)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private static boolean wantRetry(GameCommand command) {
        if (GameCommand.RETRY.equals(command)) {
            return true;
        }
        return false;
    }


    public void play() {
        for (int i = 0; i < bridgeGame.getBridge().size(); i++) {
            boolean isMovable = move();
            if (!isMovable && retry()) {
                play();
                break;
            }
        }
    }

    public int getCount() {
        return this.bridgeGame.getGameCount();
    }
}
