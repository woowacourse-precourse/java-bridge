package bridge;

import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.Message;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGame(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return move();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        try {
            return "R".equals(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retry();
        }
    }

    public void run() {
        GameStatus gameStatus = GameStatus.startNewGame();
        System.out.println(Message.INITIAL_MESSAGE.getMessage());

        int bridgeSize = getBridgeSize();
        Bridge realBridges = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        Bridge selectedBridges = playGame(gameStatus, realBridges);
        outputView.printResult(gameStatus, realBridges, selectedBridges);
    }

    private int getBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBridgeSize();
        }
    }

    private Bridge playGame(GameStatus gameStatus, Bridge realBridges) {
        Bridge selectBridges = playOneTry(gameStatus, realBridges);
        while (!gameStatus.isEnd() && retry()) {
            selectBridges = playOneTry(gameStatus, realBridges);
            gameStatus.addTryCount();
        }
        return selectBridges;
    }

    public Bridge playOneTry(GameStatus gameStatus, Bridge realBridges) {
        Bridge selectBridges = new Bridge();
        for (int index = 0; index < realBridges.getSize(); index++) {
            String realBridge = realBridges.getBridgeByIndex(index);
            String selectedBridge = getSelectBridge(selectBridges);
            outputView.printMap(realBridges, selectBridges);
            if (!realBridge.equals(selectedBridge)) return selectBridges;
        }
        gameStatus.setSuccess(true);
        return selectBridges;
    }

    private String getSelectBridge(Bridge selectedBridges) {
        String selectedBridge = move();
        selectedBridges.addNewBridge(selectedBridge);
        return selectedBridge;
    }
}
