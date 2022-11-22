package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeProgram {

    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeProgram(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        this.bridgeGame = bridgeGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    // 전체 프로그램을 가동하는 기능
    public void runBridgeProgram() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        runBridgeGame(bridgeMaker.makeBridge(getBridgeSize()));
    }

    public void runBridgeGame(List<String> bridge) {
        int tryCount = 0;
        List<String> moved = new ArrayList<>();
        do {
            String moving = getMoving();
            bridgeGame.move(moved, moving);
            outputView.printMap(bridge, moved);
            tryCount = getTryCount(bridge, tryCount, moved);
        } while (!bridgeGame.isFinished(bridge, moved) || wantRetry(bridge, moved));
        outputView.printResult(bridge, moved, tryCount);
    }

    private int getTryCount(List<String> bridge, int tryCount, List<String> moved) {
        if (bridgeGame.isFinished(bridge, moved)) {
            tryCount++;
        }
        return tryCount;
    }

    private boolean wantRetry(List<String> bridge, List<String> moved) {
        if (bridgeGame.isFailed(bridge, moved)) {
            String gameCommand = getGameCommand();
            if (gameCommand.equals("R")) {
                bridgeGame.retry(moved); // moved를 초기화, tryCount++;
                return true;
            }
        }
        return false;
    }

    private int getBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getMoving() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getGameCommand() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
