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
        System.out.println("다리 길이를 입력해주세요.");
        int bridgeSize = inputView.readBridgeSize();
        System.out.println(" ");
        return bridgeSize;
    }

    private Bridge makeBridge(int bridgeSize) {
        List<String> strings = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(strings);
    }

    private String getMovingInput() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return inputView.readMoving();
    }

    private String getGameCommandInput() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return inputView.readGameCommand();
    }

    private int moveOrNot(BridgeGame bridgeGame, boolean isMovable) {
        outputView.printMap(bridgeGame, isMovable);
        if (isMovable) {
            return bridgeGame.move();
        }
        return bridgeGame.getPosition();
    }

    private boolean doBridgeGame(int bridgeSize, BridgeGame bridgeGame) {
        int position;
        do {
            String movingInput = getMovingInput();
            boolean isMovable = bridgeGame.isMovable(movingInput);
            position = moveOrNot(bridgeGame, isMovable);
            if (retryOrQuit(bridgeGame,isMovable).equals(QUIT_GAME)) {
                return false;
            }
        } while (position < bridgeSize);
        return true;
    }

    private String retryOrQuit(BridgeGame bridgeGame, boolean isMove) {
        if (isMove) {
            return RETRY_GAME;
        }
        String gameCommandInput = getGameCommandInput();
        if (gameCommandInput.equals(RETRY_GAME)) {
            bridgeGame.retry();
            return RETRY_GAME;
        }
        this.outputView.printResult(bridgeGame, false);
        return QUIT_GAME;
    }
}
