package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

import static bridge.util.Constant.QUIT_GAME;
import static bridge.util.Constant.RETRY_GAME;

/**
 * 다리 건너기 게임 컨트롤러 클래스
 */
public class BridgeGameController {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        int bridgeSize = getBridgeSize();
        Bridge bridge = makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        if (!doBridgeGame(bridgeSize, bridgeGame)) {
            return;
        }
        outputView.printResult(bridgeGame, true);
    }

    private int getBridgeSize() {
        while (true) {
            System.out.println("다리 길이를 입력해주세요.");
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Bridge makeBridge(int bridgeSize) {
        List<String> strings = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(strings);
    }

    private boolean doBridgeGame(int bridgeSize, BridgeGame bridgeGame) {
        int position;
        do {
            boolean isMovable = bridgeGame.isMovable(getMovingInput());
            position = moveOrNot(bridgeGame, isMovable);
            if (retryOrQuit(bridgeGame, isMovable).equals(QUIT_GAME)) {
                return false;
            }
        } while (position < bridgeSize);
        return true;
    }

    private String getMovingInput() {
        while (true) {
            try {
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int moveOrNot(BridgeGame bridgeGame, boolean isMovable) {
        outputView.printMap(bridgeGame, isMovable);
        if (isMovable) {
            return bridgeGame.move();
        }
        return bridgeGame.getPosition();
    }

    private String retryOrQuit(BridgeGame bridgeGame, boolean isMove) {
        if (!isMove) {
            if (getGameCommandInput().equals(QUIT_GAME)) {
                this.outputView.printResult(bridgeGame, false);
                return QUIT_GAME;
            }
            bridgeGame.retry();
        }
        return RETRY_GAME;
    }

    private String getGameCommandInput() {
        while (true) {
            try {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
