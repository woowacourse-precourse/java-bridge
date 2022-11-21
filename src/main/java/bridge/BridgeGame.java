package bridge;

import bridge.domain.Bridge;
import bridge.domain.Result;
import bridge.util.BridgeComparator;
import bridge.view.InputView;
import bridge.view.Message;
import bridge.view.OutputView;

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
    public Result move(GameStatus gameStatus) {
        Bridge selectedBridges = gameStatus.getSelectedBridge();
        Bridge realBridges = gameStatus.getRealBridge();

        String newBridge = requestMove();
        selectedBridges.addNewBridge(newBridge);
        Result result = BridgeComparator.compareBridges(realBridges, selectedBridges);
        outputView.printMap(result);
        return result;
    }

    public String requestMove() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestMove();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Result retry(GameStatus gameStatus) {
        gameStatus.setNewSelectedBridge();
        gameStatus.addTryCount();
        return playOneTry(gameStatus);
    }

    private boolean requestRetryCommand() {
        try {
            return "R".equals(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestRetryCommand();
        }
    }

    public void run() {
        GameStatus gameStatus = GameStatus.startNewGame();
        System.out.println(Message.INITIAL_MESSAGE.getMessage());

        int bridgeSize = requestBridgeSize();
        gameStatus.setRealBridge(new Bridge(bridgeMaker.makeBridge(bridgeSize)));

        Result result = playGame(gameStatus);
        outputView.printResult(gameStatus, result);
    }

    private int requestBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestBridgeSize();
        }
    }

    private Result playGame(GameStatus gameStatus) {
        Result result = playOneTry(gameStatus);
        while (!result.isSuccess()) {
            if (requestRetryCommand()) {
                result = retry(gameStatus);
            }
        }
        return result;
    }


    public Result playOneTry(GameStatus gameStatus) {
        Bridge realBridges = gameStatus.getRealBridge();
        Bridge selectedBridges = gameStatus.getSelectedBridge();
        for (int index = 0; index < realBridges.getSize(); index++) {
            Result result = move(gameStatus);
            if (!result.isSuccess()) return result;
        }
        return Result.success(selectedBridges);
    }
}
