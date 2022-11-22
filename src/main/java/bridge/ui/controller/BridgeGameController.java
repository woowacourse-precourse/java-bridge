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
    public void move() {
        String moving = inputView.readMoving();
        bridgeGame.move(moving);
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserRoute());
    }

    /**
     * 이동이 제대로 되었는지 확인하는 메서드
     */
    public boolean isCorrectMove() {
        return bridgeGame.isCorrectMove();
    }


    /**
     * 게임을 종료하고 결과를 출력하는 메서드
     */
    public void endGame() {
        List<String> bridge = bridgeGame.getBridge();
        List<String> userRoute = bridgeGame.getUserRoute();
        int count = bridgeGame.getGameCount();
        outputView.printResult(bridge, userRoute, count);
    }


    /**
     * 게임을 재실행 하는 메서드(재실행 할 경우에 맞게 값 초기화 및 게임 시작)
     */
    public void retry() {
        bridgeGame.retry();
        play();
    }

    /**
     * 사용자가 재실행을 원하는지 입력 받는 메서드
     */
    private boolean wantRetry() {
        GameCommand gameCommand = inputView.readGameCommand();
        return GameCommand.RETRY.equals(gameCommand);
    }


    /**
     * 게임을 진행하는 메서드
     */
    public void play() {
        for (int i = 0; i < bridgeGame.getBridge().size(); i++) {
            move();
            if (!isCorrectMove() && wantRetry()) {
                retry();
                break;
            }
        }
    }

}
